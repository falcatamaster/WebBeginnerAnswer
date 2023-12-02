# DockerHubの使用するイメージを指定。Java11を実行させるためのJDKを指定
# （公式のopenJDKもあるけど、AWSにデプロイする前提で作成したのでここではなんとなくAWS提供のものを指定）
FROM amazoncorretto:11 

# gradleのインストール
RUN apt-get update
RUN apt-get -y install curl
RUN apt-get -y install zip
RUN curl -s "https://get.sdkman.io" | bash
RUN echo ". $HOME/.sdkman/bin/sdkman-init.sh; sdk install gradle" | bash

# gradleのビルドコマンド実行
RUN gradle build

VOLUME /tmp
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]