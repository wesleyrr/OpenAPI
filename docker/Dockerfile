FROM maven:3.8.2-jdk-11-openj9

ARG ARTIFACT_NAME=bff-openapi.jar

USER root
RUN groupadd app && useradd -d /home/app -s /bin/nologin -g app app
WORKDIR /home/app
COPY target/bff-openapi.jar bff-openapi.jar
RUN ln -fs /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime && chown -R app:app /home/app
EXPOSE 8080

USER app
ENTRYPOINT java -jar bff-openapi.jar
