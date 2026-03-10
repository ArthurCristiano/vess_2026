# BUILD
FROM eclipse-temurin:21-jdk-alpine as build
WORKDIR /workspace/vess

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# clean up the file
RUN sed -i 's/\r$//' mvnw
# create package
RUN /bin/sh mvnw package -DskipTests

# DELIVERY
FROM openjdk:21-ea-jdk
COPY --from=build /workspace/vess/target/vess-api-0.1.jar vess-api.jar
ENTRYPOINT ["java", "-jar", "vess-api.jar"]