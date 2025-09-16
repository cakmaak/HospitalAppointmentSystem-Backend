# 1. Build aşaması
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2. Run aşaması
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/Appointment-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
