FROM gradle:jdk11 as build
USER gradle
WORKDIR /app
COPY --chown=gradle:gradle build.gradle .
COPY --chown=gradle:gradle src src 
RUN gradle build
RUN java -Djarmode=layertools -jar build/libs/api.jar extract

FROM openjdk:11.0.10-jre-slim
WORKDIR /app
COPY --from=build /app/dependencies/ ./
COPY --from=build /app/hibernate-deps/ ./
COPY --from=build /app/spring-boot-loader/ ./
COPY --from=build /app/snapshot-dependencies/ ./
COPY --from=build /app/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
