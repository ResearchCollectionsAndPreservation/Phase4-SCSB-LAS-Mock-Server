# LAS-Mock-Server

      Once a request message is  placed to the request queue from SCSB-CIRC, the request message will  then be consumed by LAS mock Server. After doing some internal processing, LAS Mock Server will respond by sending a response message to the response queue. Later, SCSB-CIRC will consume the response message.

## Software Required

      - Java 11
      - Docker 19.03.13  
      
## Prerequisite

1. external-las-application properties

      - spring.datasource.url=jdbc:mysql://${MysqlDOckerIP}:3306/recaplas?autoReconnect=true&serverTimezone=America/New_York&useSSL=false
      - spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
      - spring.datasource.username=
      - spring.datasource.password=
      - spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect 
  
  #ActiveMQ
  
      - activemq.broker.url=tcp://localhost:61613
      - activemq.jmx.service.url=service:jmx:rmi:///jndi/rmi://127.0.0.1:1099/jmxrmi
      - activemq.web.console.url=http://localhost:8161
      - activemq.credentials=admin:admin 
      - activemq.jolokia.api.url=/api/jolokia/read/org.apache.activemq:type=Broker,brokerName=localhost,destinationType=Queue,destinationName=
      - activemq.jolokia.api.queue.size.attribute=/QueueSize
      
2. Update the below Property Values in scsb_properteis_t table.
  
      - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='http://${DOCKERIPOFLASMOCKSERVER}:9104/lasapi/rest/lasapiSvc/lasStatus' WHERE `P_KEY`='ims.server.status.endpoint';
      - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='http://${DOCKERIPOFLASMOCKSERVER}:9104/lasapi/rest/lasapiSvc/itemStatus' WHERE `P_KEY`='ims.item.status.endpoint';
      - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='http://${DOCKERIPOFLASMOCKSERVER}:9104/lasapi/rest/lasapiSvc/retrieveItem' WHERE `P_KEY`='ims.item.retrieval.order.endpoint';
      - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='http://${DOCKERIPOFLASMOCKSERVER}:9104/lasapi/rest/lasapiSvc/retrieveEDD' WHERE `P_KEY`='ims.item.edd.order.endpoint';
      - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='http://${DOCKERIPOFLASMOCKSERVER}:9104/lasapi/rest/lasapiSvc/permanentlyRetrieveItem' WHERE `P_KEY`='ims.item.permanent.withdrawal.direct.endpoint';
      - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='http://${DOCKERIPOFLASMOCKSERVER}:9104/lasapi/rest/lasapiSvc/permanentlyRetrieveItemIndirect' WHERE `P_KEY`='ims.item.permanent.withdrawal.indirect.endpoint'; 
  
## Build

Download the Project , navigate inside project folder and build the project using below command

**sudo ./gradlew clean build -x test**

## Docker Image Creation

Naviagte Inside project folder where Dockerfile is present and Execute the below command

**sudo docker build -t phase4-scsb-las-mock-server .**

## Docker Run

User the below command to Run the Docker
  
**sudo docker run --name phase4-scsb-las-mock-server -v /data:/recap-vol -p 9104:9104 -e "ENV= -Dorg.apache.activemq.SERIALIZABLE_PACKAGES="*" -Dspring.config.location=/recap-vol/config/external-las-application.properties " -d phase4-scsb-las-mock-server**
