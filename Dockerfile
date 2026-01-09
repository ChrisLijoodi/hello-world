# ---------- Build stage ----------
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /hello-world
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# ---------- Runtime stage ----------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /hello-world
COPY --from=build /hello-world/target/*.jar hello-0.0.1-SNAPSHOT.jar


# Copy CockroachDB CA cert
COPY certs/root.crt /app/certs/root.crt

# Environment variables
ENV DB_SSL_ROOT_CERT=/app/certs/root.crt

EXPOSE 8080
ENTRYPOINT ["java","-jar","hello-0.0.1-SNAPSHOT.jar"]
