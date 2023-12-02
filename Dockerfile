FROM ubuntu:18.04
ENV SDKMAN_DIR=/root/.sdkman
RUN apt-get update
RUN apt -y install openjdk-8-jdk
RUN apt-get install zip unzip
RUN apt -y install curl
RUN curl -s "https://get.sdkman.io" | bash
RUN echo "sdkman_auto_answer=true" > $SDKMAN_DIR/etc/config
RUN echo "sdkman_auto_selfupdate=false" >> $SDKMAN_DIR/etc/config
RUN bash -c "source $SDKMAN_DIR/bin/sdkman-init.sh && sdk install gradle"
WORKDIR ~
RUN mkdir ~/myApp
VOLUME ~/myApp