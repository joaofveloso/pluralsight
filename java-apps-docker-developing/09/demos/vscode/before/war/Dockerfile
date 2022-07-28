FROM tomcat:9
ARG OUTDIR=build/libs
COPY ${OUTDIR}/web.war ${CATALINA_HOME}/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]