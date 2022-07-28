GETTING STARTED WITH DOCKER FOR JAVA
Hi. Thanks for watching this course. Here you can find some notes and resources related to the content shown in this module.

LINKS
Getting Started with Docker course:
- https://www.pluralsight.com/courses/getting-started-docker

For installing Docker:
- https://docs.docker.com/get-docker/

Play with Docker:
- https://labs.play-with-docker.com/
- https://github.com/play-with-docker/play-with-docker

Docker Hub:
- https://hub.docker.com

Docker run command reference:
- https://docs.docker.com/engine/reference/commandline/run/

COMMANDS
docker run -v ${PWD}:/hello -w /hello openjdk:11.0.10-buster javac Hello.java
docker run -v ${PWD}:/hello -w /hello openjdk:11.0.10-buster java Hello
docker run -v ${PWD}:/hello -w /hello openjdk:11.0.10-jre-buster java Hello
docker run -v ${PWD}:/hello -w /hello --rm openjdk:11.0.10-jre-buster java Hello

For Windows Command Line:
docker run -v %cd%:/hello -w /hello openjdk:11.0.10-buster javac Hello.java
docker run -v %cd%:/hello -w /hello openjdk:11.0.10-buster java Hello
docker run -v %cd%:/hello -w /hello openjdk:11.0.10-jre-buster java Hello
docker run -v %cd%:/hello -w /hello --rm openjdk:11.0.10-jre-buster java Hello

For listing images and containers:
docker image ls
docker container ls -a

For cleaning up:
docker system prune -a
(If you want to also delete volumes, add the -v option)