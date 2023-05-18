FROM openjdk:19
COPY target/spring-boot-bachelor-docker.jar spring-boot-bachelor-docker.jar
ENTRYPOINT ["java","-jar","/spring-boot-bachelor-docker.jar"]