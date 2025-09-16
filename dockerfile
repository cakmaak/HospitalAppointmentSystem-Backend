FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/Appointment-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
COPY src/main/resources/application.properties application.properties
ENTRYPOINT ["java","-jar","/app.jar"]
