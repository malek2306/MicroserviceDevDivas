FROM openjdk:17
EXPOSE 8095
ADD target/APIGateway2-0.0.1-SNAPSHOT.jar gateway2.jar
ENTRYPOINT ["java", "-jar", "gateway2.jar"]