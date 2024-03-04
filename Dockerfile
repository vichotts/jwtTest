FROM eclipse-temurin:17-openjdk-alpine

WORKDIR /app
COPY target/JWT-Itau-1.0.0.jar JWT-Itau-1.0.0.jar
EXPOSE 8080
CMD ["java", "-jar", "JWT-Itau-1.0.0.jar"]