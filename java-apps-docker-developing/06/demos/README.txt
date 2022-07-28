CONFIGURING JAVA APPLICATIONS IN CONTAINERS
Hi. Thanks for watching this course. Here you can find some notes and resources related to the content shown in this module.


==============Clip 2. Using Environment Variables==============
OFFICIAL DOCUMENTATION
ENV instruction
https://docs.docker.com/engine/reference/builder/#env

Setting env variables with the docker run command
https://docs.docker.com/engine/reference/commandline/run/#set-environment-variables--e---env---env-file

Setting env variables with Docker Compose
https://docs.docker.com/compose/compose-file/compose-file-v3/#environment
https://docs.docker.com/compose/compose-file/compose-file-v3/#env_file

EXECUTED COMMANDS
./mvnw package
--------------------------------------------------
java -jar target/api.jar
--------------------------------------------------
curl localhost:8080/env
--------------------------------------------------
cp api.Dockerfile api-env.Dockerfile
--------------------------------------------------
docker build -f api-env.Dockerfile -t api-app-dev .
--------------------------------------------------
docker run -it --rm -p 8081:8081 api-app-dev
--------------------------------------------------
curl localhost:8081/env
--------------------------------------------------
For Linux and Mac:
docker run -it --rm \
  -e SPRING_PROFILES_ACTIVE=test \
  -p 8082:8082 \
  api-app-dev

For Windows CMD:
docker run -it --rm ^
  -e SPRING_PROFILES_ACTIVE=test ^
  -p 8082:8082 ^
  api-app-dev
--------------------------------------------------
For Linux and Mac:
docker run -it --rm \
  -p 8082:8082 \
  api-app-dev --spring.profiles.active=test

For Windows CMD:
docker run -it --rm ^
  -p 8082:8082 ^
  api-app-dev --spring.profiles.active=test
--------------------------------------------------
For Linux and Mac:
docker run -it --rm \
  -p 8082:8082 \
  api-app-dev -Dspring.profiles.active=test

For Windows CMD:
docker run -it --rm ^
  -p 8082:8082 ^
  api-app-dev -Dspring.profiles.active=test



==============Clip 3. Understanding ENTRYPOINT and CMD==============
OFFICIAL DOCUMENTATION
CMD (default command or options)
https://docs.docker.com/engine/reference/run/#cmd-default-command-or-options

ENTRYPOINT (default command to execute at runtime)
https://docs.docker.com/engine/reference/run/#entrypoint-default-command-to-execute-at-runtime

EXECUTED COMMANDS
cp api.Dockerfile api-shell.Dockerfile
--------------------------------------------------
docker build -f api-shell.Dockerfile -t api-app-shell . 
--------------------------------------------------
For Linux and Mac:
docker run --rm -it -e JAVA_OPTS=-Dspring.profiles.active=test \
  -p 8082:8082 api-app-shell
  
For Windows CMD:
docker run --rm -it -e JAVA_OPTS=-Dspring.profiles.active=test ^
  -p 8082:8082 api-app-shell
--------------------------------------------------
For Linux and Mac:
docker run --rm -it -e JAVA_OPTS=-Dspring.profiles.active=test \
  -p 8082:8082 api-app-shell --environment.label=HI
  
For Windows CMD:
docker run --rm -it -e JAVA_OPTS=-Dspring.profiles.active=test ^
  -p 8082:8082 api-app-shell --environment.label=HI
--------------------------------------------------
curl localhost:8082/env
--------------------------------------------------
For Linux and Mac:
docker run --rm -it -e JAVA_OPTS=-Dspring.profiles.active=test \
  -p 8082:8082 api-app-shell --environment.label=HI \
  --spring.main.banner-mode=console
  
For Windows CMD:
docker run --rm -it -e JAVA_OPTS=-Dspring.profiles.active=test ^
  -p 8082:8082 api-app-shell --environment.label=HI ^
  --spring.main.banner-mode=console



==============Clip 4. Mounting External Properties Files==============
EXECUTED COMMANDS
docker build -f api.Dockerfile -t api-app-external .
--------------------------------------------------
For Linux and Mac:
docker run -it --rm \
  -p 8083:8083 \
  -e spring_config_additional-location=/config/ext_application.properties \
  -v ${PWD}/ext_application.properties:/config/ext_application.properties \
  api-app-external
  
For Windows CMD:
docker run -it --rm ^
  -p 8083:8083 ^
  -e spring_config_additional-location=/config/ext_application.properties ^
  -v %cd%/ext_application.properties:/config/ext_application.properties ^
  api-app-external
--------------------------------------------------
curl localhost:8083/env



==============Clip 5. Overriding Docker Compose Configuration Files==============
OFFICIAL DOCUMENTATION
https://docs.docker.com/compose/reference/#use--f-to-specify-name-and-path-of-one-or-more-compose-files


EXECUTED COMMANDS
docker build -f api.Dockerfile -t api-app .
--------------------------------------------------
docker-compose -f docker-compose.yml -f docker-compose-dev.yml config
--------------------------------------------------
docker-compose -f docker-compose.yml -f docker-compose-test.yml config
--------------------------------------------------
docker-compose -f docker-compose.yml -f docker-compose-dev.yml up
--------------------------------------------------
docker-compose -f docker-compose.yml -f docker-compose-test.yml up
--------------------------------------------------
docker-compose -f docker-compose.yml -f docker-compose-dev.yml up
--------------------------------------------------
docker-compose -f docker-compose.yml -f docker-compose-test.yml -p api-test up
--------------------------------------------------
curl localhost:8081/env
--------------------------------------------------
curl localhost:8082/env
--------------------------------------------------
docker-compose down
--------------------------------------------------
docker-compose down
--------------------------------------------------
docker-compose -f docker-compose.yml -f docker-compose-test.yml -p api-test down
