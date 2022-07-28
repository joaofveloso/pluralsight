FROM gradle:jdk11 as build
USER gradle
WORKDIR /app
COPY --chown=gradle:gradle build.gradle .
COPY --chown=gradle:gradle src src
RUN gradle build

FROM tomcat:9
COPY --from=build /app/build/libs/web.war ${CATALINA_HOME}/webapps/ROOT.war
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh
EXPOSE 8080
ENTRYPOINT ["/wait-for-it.sh", "db:5432", "--timeout=20", "--", "catalina.sh", "run"]
