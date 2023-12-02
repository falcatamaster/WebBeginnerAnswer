FROM ubuntu:18.04
ENV SDKMAN_DIR=/root/.sdkman
RUN apt-get update
RUN apt -y install openjdk-11-jdk
RUN apt-get install zip unzip
RUN apt -y install curl
RUN curl -s "https://get.sdkman.io" | bash
RUN echo "sdkman_auto_answer=true" > $SDKMAN_DIR/etc/config
RUN echo "sdkman_auto_selfupdate=false" >> $SDKMAN_DIR/etc/config
RUN bash -c "source $SDKMAN_DIR/bin/sdkman-init.sh && sdk install gradle"


RUN gradle build

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]