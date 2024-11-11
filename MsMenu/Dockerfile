FROM openjdk:17
EXPOSE 8061
ADD target/Menu-0.0.1-SNAPSHOT.jar MenuMSP-docker.jar
ENTRYPOINT ["java", "-jar","MenuMSP-docker.jar"]