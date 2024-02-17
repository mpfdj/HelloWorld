FROM eclipse-temurin:latest
MAINTAINER Miel de Jaeger. Image is based on OpenJDK 21
ENV LANGUAGE='en_US:en'
ENV DEBIAN_FRONTEND=noninteractive

#RUN apt-get update
#RUN apt-get install -y vim
#RUN apt-get install -y net-tools
#RUN apt-get install -y iproute2
#RUN apt-get install -y iputils-ping
#RUN apt-get install -y wget

EXPOSE 8080
COPY target/HelloWorldAPI-1.0.0.jar /app.jar
CMD ["java", "-jar", "/app.jar"]