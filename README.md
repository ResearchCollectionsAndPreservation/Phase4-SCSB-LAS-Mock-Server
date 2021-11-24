# LAS-Mock-Server

  Once a request message is  placed to the request queue from SCSB-CIRC, the request message will  then be consumed by LAS mock Server. After doing some internal processing, LAS Mock Server will respond by sending a response message to the response queue. Later, SCSB-CIRC will consume the response message.

## Software Required

      - Java 11
      - Docker 19.03.13  
      
## Prerequisite

1. external-las-application properties

      - spring.datasource.url=<jdbc-url>
      - spring.datasource.driver-class-name=<DB Driver class>
      - spring.datasource.username=
      - spring.datasource.password=
      - spring.jpa.properties.hibernate.dialect=<DB Dialect> 
  
  #ActiveMQ
  
      - activemq.broker.url=<activemq Brocker URL>
      - activemq.jmx.service.url=<JMX URL>
      - activemq.web.console.url=<Console URL>
      - activemq.credentials=<user> 
      - activemq.jolokia.api.url= <jolokia URL>
      - activemq.jolokia.api.queue.size.attribute=/QueueSize
      
2. Update the below Property Values in scsb_properteis_t table.
  
      - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='<DOCKER IP OF LAS MOCK SERVER:Port>/lasapi/rest/lasapiSvc/lasStatus' WHERE `P_KEY`='ims.server.status.endpoint';
      - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='<DOCKER IP OF LAS MOCK SERVER:Port>/lasapi/rest/lasapiSvc/itemStatus' WHERE `P_KEY`='ims.item.status.endpoint';
      - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='<DOCKER IP OF LAS MOCK SERVER:Port>/lasapi/rest/lasapiSvc/retrieveItem' WHERE `P_KEY`='ims.item.retrieval.order.endpoint';
      - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='<DOCKER IP OF LAS MOCK SERVER:Port>/lasapi/rest/lasapiSvc/retrieveEDD' WHERE `P_KEY`='ims.item.edd.order.endpoint';
      - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='<DOCKER IP OF LAS MOCK SERVER:Port>/lasapi/rest/lasapiSvc/permanentlyRetrieveItem' WHERE `P_KEY`='ims.item.permanent.withdrawal.direct.endpoint';
      - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='<DOCKER IP OF LAS MOCK SERVER:Port>/lasapi/rest/lasapiSvc/permanentlyRetrieveItemIndirect' WHERE `P_KEY`='ims.item.permanent.withdrawal.indirect.endpoint'; 
  
## Build

Download the Project , navigate inside project folder and build the project using below command

**sudo ./gradlew clean build -x test**

## Docker Image Creation

Naviagte Inside project folder where Dockerfile is present and Execute the below command

**sudo docker build -t phase4-scsb-las-mock-server .**

## Docker Run

User the below command to Run the Docker
  
**sudo docker run --name phase4-scsb-las-mock-server -v <volume> -p <port configuration> -e "ENV= -Dorg.apache.activemq.SERIALIZABLE_PACKAGES="*" -Dspring.config.location=<Config File Location> " -d phase4-scsb-las-mock-server**
