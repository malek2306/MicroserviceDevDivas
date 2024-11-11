FROM openjdk:17
EXPOSE 8761
ADD target/Eureka-0.0.1-SNAPSHOT.jar MSP_Eureka-docker.jar
ENTRYPOINT ["java", "-jar","MSP_Eureka-docker.jar"]