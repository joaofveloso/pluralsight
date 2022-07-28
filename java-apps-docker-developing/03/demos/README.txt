BUILDING JAVA APPLICATIONS WITH DOCKERFILES
Hi. Thanks for watching this course. Here you can find some notes and resources related to the content shown in this module.


==============OFFICIAL DOCUMENTATION==============
https://docs.docker.com/engine/reference/builder/#from
https://docs.docker.com/engine/reference/builder/#copy
https://docs.docker.com/engine/reference/builder/#add
https://docs.docker.com/engine/reference/builder/#run
https://docs.docker.com/engine/reference/builder/#cmd
https://docs.docker.com/engine/reference/builder/#expose
https://docs.docker.com/engine/reference/builder/#user
https://docs.docker.com/engine/reference/builder/#workdir
https://docs.docker.com/engine/reference/builder/#dockerignore-file
https://docs.docker.com/develop/develop-images/dockerfile_best-practices/#add-or-copy
https://docs.docker.com/develop/develop-images/dockerfile_best-practices/#entrypoint
https://docs.docker.com/develop/develop-images/dockerfile_best-practices/#volume
https://docs.docker.com/config/labels-custom-metadata/



==============Docker Hub==============
https://hub.docker.com/_/openjdk
https://hub.docker.com/_/tomcat
https://hub.docker.com/_/maven
https://hub.docker.com/_/gradle



==============Clip 2. Using a Dockerfile==============
EXECUTED COMMANDS
docker build -f jar.Dockerfile -t my-api .
-------------------------------------------
docker images
-------------------------------------------
docker run -p 9000:8080 -it my-api
-------------------------------------------
docker container ls -a
-------------------------------------------
docker build -f web.Dockerfile -t my-web-app .
-------------------------------------------
docker run -p 9001:8080 -it --rm my-web-app



==============Clip 3. Using Maven and Gradle Docker Images==============
EXECUTED COMMANDS
docker build -f maven.Dockerfile -t my-api-maven .
-------------------------------------------
docker run -p 9010:8080 -it --rm my-api-maven
-------------------------------------------
docker build -f maven.Dockerfile -t my-api-maven:v2 .
-------------------------------------------
docker build -f gradle.Dockerfile -t my-api-gradle .
-------------------------------------------
docker run -p 9011:8080 -it --rm my-api-gradle
-------------------------------------------
docker volume ls
-------------------------------------------
For Linux/Mac:
docker run -it --rm  \
   -v ${PWD}:/app \
   -v ${HOME}/.m2:/root/.m2 \
   -w /app \
   maven:3.6.3-jdk-11-slim \
   mvn clean package

For Windows CMD:
docker run -it --rm  ^
   -v %cd%:/app ^
   -v %userprofile%/.m2:/root/.m2 ^
   -w /app ^
   maven:3.6.3-jdk-11-slim ^
   mvn clean package
-------------------------------------------
For Linux/Mac:
docker run -it --rm  \
   -u gradle \
   -v ${PWD}:/app \
   -v ${HOME}/.gradle:/home/gradle/.gradle \
   -w /app \
   gradle:jdk11 \
   gradle build

For Windows CMD:
docker run -it --rm  ^
   -u gradle ^
   -v %cd%:/app ^
   -v  %userprofile%/.gradle:/home/gradle/.gradle ^
   -w /app ^
   gradle:jdk11 ^
   gradle build



==============Clip 4. Using Multi-stage Builds==============
Use multi-stage builds
https://docs.docker.com/develop/develop-images/multistage-build/

EXECUTED COMMANDS
docker build -f maven-multi.Dockerfile -t my-web-maven-multi .
-------------------------------------------
docker images
-------------------------------------------
docker run -p 9020:8080 -it --rm my-web-maven-multi
-------------------------------------------
docker build -f gradle-multi.Dockerfile -t my-web-gradle-multi .
-------------------------------------------
docker images


==============Clip 5. Memory and CPU options==============
Clarification of meaning new JVM memory parameters InitialRAMPercentage and MinRAMPercentage
https://stackoverflow.com/a/54297753

Release Note: Java Improvements for Docker Containers
https://bugs.openjdk.java.net/browse/JDK-8196595

Improve docker container detection and resource configuration usage
https://bugs.openjdk.java.net/browse/JDK-8146115

Remove deprecated experimental flag UseCGroupMemoryLimitForHeap
https://bugs.openjdk.java.net/browse/JDK-8194086

jcmd -l and jps commands do not list Java processes running in Docker containers
https://bugs.openjdk.java.net/browse/JDK-8193710

Add -XshowSettings:system option to display system configuration
https://bugs.openjdk.java.net/browse/JDK-8204107

Update CPU count algorithm when both cpu shares and quotas are used
https://bugs.openjdk.java.net/browse/JDK-8197867

EXECUTED COMMANDS
For Linux/Mac:
docker run -it --rm -v ${PWD}:/java openjdk:8u131-slim javac /java/Stats.java

For Windows CMD:
docker run -it --rm -v %cd%:/java openjdk:8u131-slim javac /java/Stats.java
-------------------------------------------
For Linux/Mac:
docker run -it --rm -v ${PWD}:/java \
  -m 100m --cpus=1 \
  openjdk:8u131-slim \
  java -cp /java Stats

For Windows CMD:
docker run -it --rm -v %cd%:/java ^
  -m 100m --cpus=1 ^
  openjdk:8u131-slim ^
  java -cp /java Stats
-------------------------------------------
For Linux/Mac:
docker run -it --rm -v ${PWD}:/java \
  -m 100m --cpus=1 \
  openjdk:8u131-slim \
  java -cp /java \
  -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap Stats

For Windows CMD:
docker run -it --rm -v %cd%:/java ^
  -m 100m --cpus=1 ^
  openjdk:8u131-slim ^
  java -cp /java ^
  -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap Stats
-------------------------------------------
For Linux/Mac:
docker run -it --rm -v ${PWD}:/java \
  -m 100m --cpus=1 \
  openjdk:8u191-alpine \
  java -cp /java Stats

For Windows CMD:
docker run -it --rm -v %cd%:/java ^
  -m 100m --cpus=1 ^
  openjdk:8u191-alpine ^
  java -cp /java Stats
-------------------------------------------
For Linux/Mac:
docker run -it --rm -v ${PWD}:/java \
  -m 100m --cpus=1" \
  openjdk:11.0.10-slim \
  java -cp /java Stats

For Windows CMD:
docker run -it --rm -v %cd%:/java ^
  -m 100m --cpus=1 ^
  openjdk:11.0.10-slim ^
  java -cp /java Stats
-------------------------------------------
For Linux/Mac:
docker run -it --rm -v ${PWD}:/java \
  -m 100m --cpus=1 \
  openjdk:11.0.10-slim \
  java -cp /java -XX:-UseContainerSupport Stats

For Windows CMD:
docker run -it --rm -v %cd%:/java ^
  -m 100m --cpus=1 ^
  openjdk:11.0.10-slim ^
  java -cp /java -XX:-UseContainerSupport Stats
-------------------------------------------
For Linux/Mac:
docker run -it --rm -v ${PWD}:/java \
  -m 100m --cpus=1 \
  openjdk:11.0.10-slim \
  java -cp /java -XX:+UnlockExperimentalVMOptions \
  -XX:+UseCGroupMemoryLimitForHeap Stats

For Windows CMD:
docker run -it --rm -v %cd%:/java ^
  -m 100m --cpus=1 ^
  openjdk:11.0.10-slim ^
  java -cp /java -XX:+UnlockExperimentalVMOptions ^
  -XX:+UseCGroupMemoryLimitForHeap Stats
-------------------------------------------
For Linux/Mac:
docker run -it --rm -v ${PWD}:/java \
  -m 100m --cpus=1 \
  openjdk:11.0.10-slim \
  java -cp /java -XX:MaxRAMPercentage=70.0 Stats 

For Windows CMD:
docker run -it -v %cd%:/java ^
  -m 100m --cpus=1 ^
  openjdk:11.0.10-slim ^
  java -cp /java -XX:MaxRAMPercentage=70.0 Stats 
-------------------------------------------
For Linux/Mac:
docker run -it --rm -v ${PWD}:/java \
  -m 1g --cpus=1 \
  openjdk:11.0.10-slim \
  java -cp /java -XX:MaxRAMPercentage=70.0 Stats

For Windows CMD:
docker run -it --rm -v %cd%:/java ^
  -m 1g --cpus=1 ^
  openjdk:11.0.10-slim ^
  java -cp /java -XX:MaxRAMPercentage=70.0 Stats
-------------------------------------------



==============Clip 6. Alternatives for Choosing a Base Image==============
Oracle Container Registry
http://container-registry.oracle.com/

Oracle JDK on Docker Hub
https://hub.docker.com/search?q=Oracle%20JDK%20jre&type=image

Azul Zulu images on Docker Hub
https://hub.docker.com/u/azul

OpenJ9
https://www.eclipse.org/openj9/

AdoptOpenjdk Docker Hub page
https://hub.docker.com/_/adoptopenjdk
