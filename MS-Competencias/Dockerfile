FROM openjdk:17
VOLUME /tmp
ARG JAR_FILE
COPY ./build/libs/ms-competencias-0.1.jar app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]