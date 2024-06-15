FROM maven:3.8.8-eclipse-temurin-21-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-slim
COPY --from=build /target/Assignment2-0.0.1-SNAPSHOT.jar Assignment2.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Assignment2.jar"]