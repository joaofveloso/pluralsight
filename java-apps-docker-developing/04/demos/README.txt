BUILDING JAVA APPLICATIONS WITH BUILD TOOLS AND PLUGINS
Hi. Thanks for watching this course. Here you can find some notes and resources related to the content shown in this module.


==============Clip 2. Fabric8 Docker Maven Plugin==============
OFFICIAL DOCUMENTATION
https://github.com/fabric8io/docker-maven-plugin
http://dmp.fabric8.io/#maven-goals

EXECUTED COMMANDS
./mvnw clean package
-------------------------------------------
./mvnw docker:run
-------------------------------------------
docker ps
-------------------------------------------
./mvnw clean package
-------------------------------------------
cat target/docker/fabric8-dmp/v2/build/Dockerfile
-------------------------------------------
./mvnw docker:run



==============Clip 3. Palantir Docker Gradle Plugin==============
OFFICIAL DOCUMENTATION
https://github.com/palantir/gradle-docker

EXECUTED COMMANDS
./gradlew build docker
-------------------------------------------
ls build/docker
-------------------------------------------
./gradlew dockerRun
-------------------------------------------
docker container ls
-------------------------------------------
./gradlew dockerRun
-------------------------------------------
./gradlew dockerStop
-------------------------------------------
docker container ls



==============Clip 4. Layered Deployment with Spring Boot==============
OFFICIAL DOCUMENTATION
You can replace current in the URL with a particular version (2.4.3, for example):
- https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/#repackage-layers
- https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#packaging-layered-jars
- https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/#goals-build-image
- https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#build-image

Packeto
https://paketo.io
https://reproducible-builds.org

EXECUTED COMMANDS
./gradlew bootBuildImage --imageName=layers-gradle
-------------------------------------------
docker images
-------------------------------------------
docker run -it --rm -p 9030:8080 layers-gradle
-------------------------------------------
java -Djarmode=layertools -jar build/libs/api.jar list
-------------------------------------------
./gradlew clean build
-------------------------------------------
java -Djarmode=layertools -jar build/libs/api.jar list
-------------------------------------------
java -Djarmode=layertools -jar build/libs/api.jar extract
-------------------------------------------
ls hibernate-deps/BOOT-INF/lib/
-------------------------------------------
docker build -f layers-gradle.Dockerfile -t custom-layers-gradle .
-------------------------------------------
docker run -it --rm -p 9031:8080 custom-layers-gradle
-------------------------------------------
docker build -f layers-maven.Dockerfile -t layers-maven .
-------------------------------------------
docker run -it --rm -p 9031:8080 layers-maven



==============Clip 5. Building Docker Images with Google Jib==============
OFFICIAL DOCUMENTATION
- https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin
- https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin#war-projects
- https://github.com/GoogleContainerTools/jib/tree/master/jib-gradle-plugin
- https://github.com/GoogleContainerTools/jib/tree/master/jib-gradle-plugin#war-projects

EXECUTED COMMANDS
# Error not compiled
./mvnw com.google.cloud.tools:jib-maven-plugin:dockerBuild -Dimage=jib-web-maven
-------------------------------------------
./mvnw package com.google.cloud.tools:jib-maven-plugin:dockerBuild -Dimage=jib-web-maven
-------------------------------------------
docker images
-------------------------------------------
docker history jib-web-maven
-------------------------------------------
docker run -it --rm -p 9040:8080 jib-web-maven
-------------------------------------------
./gradlew jibDockerBuild
-------------------------------------------
docker run -it --rm -p 9041:8080 jib-web-gradle
-------------------------------------------
./mvnw jib:dockerBuild -f pom-jib.xml
