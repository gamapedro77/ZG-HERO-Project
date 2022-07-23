FROM openjdk:17
VOLUME /tmp
COPY ./build/libs/ms-email-0.1.jar app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]