FROM openjdk:15-jdk
RUN microdnf install git
ENV REPOSITORY=null
ENV FOLDER=null

RUN useradd www


WORKDIR /app
COPY . /app/

RUN chown www /app
RUN chmod +x /app/init.sh
RUN chown www /app/init.sh
EXPOSE 8484
USER www
ENTRYPOINT [ "/app/init.sh" ]