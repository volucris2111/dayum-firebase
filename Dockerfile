FROM openjdk:13-ea-19-jdk-alpine3.9

COPY build/libs/dayum-0.1.0.jar dayum.jar

EXPOSE 8080

ENTRYPOINT  java -jar dayum.jar