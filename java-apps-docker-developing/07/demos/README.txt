MANAGING APPLICATION LOGS WITH DOCKER
Hi. Thanks for watching this course. Here you can find some notes and resources related to the content shown in this module.


==============Clip 2. Docker Logging Model==============
OFFICIAL DOCUMENTATION
Customize log driver output
https://docs.docker.com/config/containers/logging/log_tags/

Command reference
https://docs.docker.com/engine/reference/commandline/logs/
https://docs.docker.com/compose/reference/logs/

Fluentd logging driver
https://docs.docker.com/config/containers/logging/fluentd/

Fluentd Config file syntax
https://docs.fluentd.org/configuration/config-file

Fluentd image
https://hub.docker.com/r/fluent/fluentd
https://github.com/fluent/fluentd-docker-image

EXECUTED COMMANDS
docker build -f api.Dockerfile -t my-app-log .
------------------------------------------------
docker run -it --rm -p 8080:8080 --name api my-app-log
------------------------------------------------
docker logs api
------------------------------------------------
docker logs -f api
------------------------------------------------
curl localhost:8080/books/categories
------------------------------------------------
For Linux and Mac:
docker run -it --rm \
  -p 24224:24224 \
  -v ${PWD}:/fluentd/etc/ \
  -e FLUENTD_CONF=fluent.conf \
  fluent/fluentd:v1.12-1

For Windows CMD:
docker run -it --rm ^
  -p 24224:24224 ^
  -v %cd%:/fluentd/etc/ ^
  -e FLUENTD_CONF=fluent.conf ^
  fluent/fluentd:v1.12-1
------------------------------------------------
docker run -it --rm -p 8080:8080 --log-driver=fluentd --log-opt tag="{{.Name}}.{{.ImageName}}" --name api my-app-log
------------------------------------------------
curl localhost:8080/books/9
------------------------------------------------
curl localhost:8080/books/99



==============Clip 3. Solutions for the Multiline Log Problem==============
RELEVANT ARTICLES
For the awslogs driver
https://docs.docker.com/config/containers/logging/awslogs/#awslogs-multiline-pattern

Fluentd multiline parser plugin
https://docs.fluentd.org/parser/multiline

Good articles
https://www.datadoghq.com/blog/multiline-logging-guide/
https://itnext.io/multiline-logs-in-openshift-efk-stack-7a7bda4ed055
https://fabianlee.org/2018/03/09/java-collapsing-multiline-stack-traces-into-a-single-log-event-using-spring-backed-by-logback-or-log4j2/
https://cassiomolin.com/2019/06/30/log-aggregation-with-spring-boot-elastic-stack-and-docker/
https://www.elastic.co/guide/en/beats/filebeat/current/multiline-examples.html



==============Clip 4. Solving the Multiline Log Problem with Fluentd==============
OFFICIAL DOCUMENTATION
https://www.fluentd.org/plugins/all
https://github.com/fluent-plugins-nursery/fluent-plugin-concat
https://github.com/uken/fluent-plugin-elasticsearch

EXECUTED COMMANDS
docker build -f fluentd.Dockerfile -t my-fluentd .
------------------------------------------------
For Linux and Mac:
docker run -it --rm \
  -p 24224:24224 \
  -v ${PWD}:/fluentd/etc/ \
  -e FLUENTD_CONF=fluent-ml.conf my-fluentd

For Windows CMD:
docker run -it --rm ^
  -p 24224:24224 ^
  -v %cd%:/fluentd/etc/ ^
  -e FLUENTD_CONF=fluent-ml.conf my-fluentd
------------------------------------------------
For Linux and Mac:
docker run -it -d \
  -p 8080:8080 \
  --log-driver=fluentd \
  --log-opt tag="{{.Name}}.{{.ImageName}}" \
  --name api my-app-log

For Windows CMD:
docker run -it --rm -d ^
  -p 8080:8080 ^
  --log-driver=fluentd ^
  --log-opt tag="{{.Name}}.{{.ImageName}}" ^
  --name api my-app-log
------------------------------------------------
curl localhost:8080/books/5
------------------------------------------------
curl localhost:8080/books/50



==============Clip 5. Setting up Elasticsearch, Fluentd, and Kibana==============
OFFICIAL DOCUMENTATION


EXECUTED COMMANDS
docker container ls -a
------------------------------------------------
docker stop api
------------------------------------------------
docker-compose up
------------------------------------------------
localhost:8080/books/4
------------------------------------------------
localhost:5601
------------------------------------------------
localhost:8080/books/400
