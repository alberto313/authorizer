# AUTHORIZER CODE CHALLENGE

This challenge was made under microservice architecture with 2 endpoints exposed.
To run this project you must need to have a maven installation and java 1.8 or higher.
To run project from inside you must need to run following command
	<code>mvn clean spring-boot:run</code>
To build project you must need to run following command
	<code>mvn clean compile</code> -> This is to compile project and last changes take effect.
	<code>mvn clean package -DskipTest -Pdist</code> -> This command generate a jar file inside target folder
After run package command, if you want to run in CLI, you need to run below command:
	<code>java -jar authorizer-service-1.0.0.jar</code>


This project use Drools project to handle business logic rules parameterized in a .drl file located in resource folder from project. You can add more rules if necessary to validate more business rules.