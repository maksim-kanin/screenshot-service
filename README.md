## Screenshot service

### Endpoints:

| Method | URI                     | Body                                                                                                 | Status code |
|--------|-------------------------|------------------------------------------------------------------------------------------------------|-------------|
| POST   | /screenshot/add         | { <br/>"id": String,<br/>"updatedBy": String,<br/>"updateDate": String,<br/>"updated": Boolean<br/>} | 201 / 400   |
| GET    | /screenshot/delete/{id} | -                                                                                                    | 200 / 400   |
| GET    | /screenshot/delete/all  | -                                                                                                    | 200 / 400   |
| GET    | /screenshot/all         | -                                                                                                    | 200 / 400   |
| GET    | /screenshot/get/{id}    | -                                                                                                    | 200 / 400   |
| POST   | /actuator/shutdown      | -                                                                                                    | 200 / 400   |

### Build JAR file

- ```./gradlew build```
- JAR file is available by path - ```build/libs```

### build.sh:

- build Docker image from local Dockerfile ```chmod u+x build.sh && ./build.sh \<TAG>```

### run.sh

- start docker-compose file with 2 services: screenshot-service and Postgres DB
- put ```application.properties``` by path ```/src/main/resources```
- service is up and accessible: ```http://localhost:8080```

```properties
spring.datasource.url=jdbc:postgresql://db:5432/<DB_NAME>
spring.datasource.username=<POSTGRES_USER>
spring.datasource.password=<POSTGRES_PASSWORD>
management.endpoint.shutdown.enabled=true
management.endpoint.info.enabled=true
management.endpoints.web.exposure.include=*
```

- ```chmod u+x run.sh && ./run.sh <POSTGRES_USER><POSTGRES_PASSWORD>```

### stop.sh

- stop docker-compose file with 2 services: screenshot-service and Postgres DB
- ```chmod u+x stop.sh && ./stop.sh```