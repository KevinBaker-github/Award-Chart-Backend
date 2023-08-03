FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/Reward-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app

# cp target/Reward-0.0.1-SNAPSHOT.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]