# DockerHubの使用するイメージを指定。Java11を実行させるためのJDKを指定
# （公式のopenJDKもあるけど、AWSにデプロイする前提で作成したのでここではなんとなくAWS提供のものを指定）
FROM amazoncorretto:11 

# gradleのインストール
RUN apt-get update
RUN apt-get -y install curl
RUN apt-get -y install zip
RUN curl -s "https://get.sdkman.io" | bash
RUN echo ". $HOME/.sdkman/bin/sdkman-init.sh; sdk install gradle" | bash
WORKDIR /usr/project

# gradleのビルドコマンド実行
RUN gradle build


# 前に生成したjarが置いてあるディレクトリパスを格納する変数定義
ARG JAR_FILE=build/libs/test-build.jar

# jarファイルをコンテナ内にコピーする。(app.jarはコンテナ内での配置場所を指定（任意の場所）)
COPY ${JAR_FILE} app.jar

# 当コンテナ実行時に実行するコマンドを定義（ここではコピーしたjarを実行している）
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=docker"]
