FROM openjdk:17

COPY ./nb-main/target/nb-main-0.0.1-SNAPSHOT.jar /app/nb-main-0.0.1-SNAPSHOT.jar

WORKDIR /app/

EXPOSE 8082
EXPOSE 5006

CMD [ "java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5006", "-jar", "/app/nb-main-0.0.1-SNAPSHOT.jar" ]