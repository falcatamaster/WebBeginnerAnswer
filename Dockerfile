# from the base image of a jdk 11 container on Ubuntu 20.04.
FROM adoptopenjdk/openjdk11:x86_64-ubuntu-jdk-11.0.18_10-slim


RUN apt-get update
RUN apt-get -y install curl
RUN apt-get -y install zip
RUN curl -s "https://get.sdkman.io" | bash
RUN echo ". $HOME/.sdkman/bin/sdkman-init.sh; sdk install gradle" | bash
WORKDIR /usr/project

COPY . .

RUN ./gradlew build

# create a work dir.
# WORKDIR /app

# copy a jvm app.
#COPY build/libs/*.jar app.jar

# open port 8080 for a jvm app.
EXPOSE 8080

# startup a jvm app.
#ENTRYPOINT ["java","-jar","app.jar"]

ENTRYPOINT ["java","-jar","build/libs/*.jar"]
