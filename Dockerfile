FROM openjdk:8-jdk-alpine
ADD target/net.appspped-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","-Dspring-boot.run.profiles=maria","/app.jar"]
#ENTRYPOINT ["mvn", "spring-boot:run", "-Dspring-boot.run.profiles=maria"]
