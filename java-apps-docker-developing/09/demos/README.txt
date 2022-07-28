DEBUGGING JAVA APPLICATIONS RUNNING IN CONTAINERS
Hi. Thanks for watching this course. Here you can find some notes and resources related to the content shown in this module.


==============Clip 2. Remote Debugging Concepts==============
Agent for enabling remote debugging
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005

Environment variables for Tomcat
JPDA_TRANSPORT – the transport mode
JPDA_ADDRESS – the port for the debugging server
JPDA_SUSPEND – the suspend value (“n” by default)
JPDA_OPTS – completely replaces all of the above with a custom string



==============Clip 3. Configuring Remote Debugging for Containers in IntelliJ==============
https://www.jetbrains.com/help/idea/debug-a-java-application-using-a-dockerfile.html
https://www.jetbrains.com/help/idea/run-and-debug-a-spring-boot-application-using-docker-compose.html



==============Clip 4. Configuring Remote Debugging for Containers in Visual Studio Code==============
Debugging documentation
- https://code.visualstudio.com/docs/containers/debug-common
- https://code.visualstudio.com/docs/containers/docker-compose#_debug
- https://code.visualstudio.com/docs/editor/debugging#_launch-configurations
- https://code.visualstudio.com/docs/containers/reference#_run-task-reference

Debug extension
- https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-debug
- https://github.com/microsoft/vscode-java-debug/blob/master/Configuration.md
