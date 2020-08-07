FROM openjdk:11.0.7-jre-slim as builder
MAINTAINER HTC ReCAP Support "recap-support@htcindia.com"

ARG TAG
ENV envTag="$TAG"
ENV TERM=xterm

#Set Locale
RUN apt-get clean && apt-get update && apt-get install -y locales

RUN locale-gen en_US.UTF-8
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8

#Set EST Timezone
ENV TZ=America/New_York
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#Set Terminal
ENV TERM=xterm
COPY build/libs/phase4-scsb-las-mock-server.jar  opt/
RUN cd /opt && ls -l 

EXPOSE 9103

ENTRYPOINT java -jar -Denvironment=$ENV /opt/phase4-scsb-las-mock-server.jar && bash
