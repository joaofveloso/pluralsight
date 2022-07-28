FROM maven:3.6.3-jdk-11-slim as build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn package
RUN java -Djarmode=layertools -jar target/api.jar extract

FROM openjdk:11.0.10-jre-slim
WORKDIR /app
COPY --from=build /app/dependencies/ ./
COPY --from=build /app/hibernate-deps/ ./
COPY --from=build /app/spring-boot-loader/ ./
COPY --from=build /app/snapshot-dependencies/ ./
COPY --from=build /app/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
