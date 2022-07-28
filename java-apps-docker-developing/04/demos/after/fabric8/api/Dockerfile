FROM openjdk:11.0.10-jre-slim
WORKDIR /app
COPY target/api.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
