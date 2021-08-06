# Phase4-SCSB-LAS-Mock-Server
Receives and responds to SCSB requests

### build Docker image
Build the application
```
./gradlew clean build -x test
```
Build the container:
```
docker build -t phase4-scsb-las-mock-server .
```
Run the container (example)
```
docker run --name phase4-scsb-las-mock-server -p 9103:9103 -e "ENV= -Dorg.apache.activemq.SERIALIZABLE_PACKAGES="*" -Dspring.config.location=/vol/config/external-las-application.properties " -d phase4-scsb-las-mock-server
```

## Endpoints
ims.server.status.endpoint = http://localhost:9103/lasapi/rest/lasapiSvc/lasStatus

ims.item.status.endpoint = http://localhost:9103/lasapi/rest/lasapiSvc/itemStatus

ims.item.retrieval.order.endpoint = http://localhost:9103/lasapi/rest/lasapiSvc/retrieveItem

ims.item.edd.order.endpoint = http://localhost:9103/lasapi/rest/lasapiSvc/retrieveEDD

ims.item.permanent.withdrawal.direct.endpoint = http://localhost:9103/lasapi/rest/lasapiSvc/permanentlyRetrieveItem

ims.item.permanent.withdrawal.indirect.endpoint = http://localhost:9103/lasapi/rest/lasapiSvc/permanentlyRetrieveItemIndirect
