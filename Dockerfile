FROM  adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
COPY /build/libs /app
RUN mkdir -p /app/configs
WORKDIR /app
ENTRYPOINT ["java", "-jar" ,"screenshot-service-1.0.jar", "--spring.config.location=configs/application.properties"]