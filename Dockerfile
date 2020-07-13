FROM openjdk:11.0.7-jre-slim as builder
MAINTAINER HTC ReCAP Support "recap-support@htcindia.com"

ARG TAG
ENV envTag="$TAG"
COPY build/libs/phase4-scsb-las-mock-server.jar  opt/
RUN cd /opt && ls -l 

EXPOSE 9103

ENTRYPOINT java -jar -Denvironment=$ENV /opt/phase4-scsb-las-mock-server.jar && bash
