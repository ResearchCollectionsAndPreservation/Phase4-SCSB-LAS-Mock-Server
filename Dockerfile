FROM phase4-scsb-base 
COPY build/libs/phase4-scsb-las-mock-server.jar  opt/
RUN cd /opt && ls -l 

EXPOSE 9104

ENTRYPOINT java -jar -Denvironment=$ENV /opt/phase4-scsb-las-mock-server.jar && bash
