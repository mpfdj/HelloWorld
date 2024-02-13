FROM eclipse-temurin:latest
MAINTAINER Miel de Jaeger. Image is based on OpenJDK 21
ENV LANGUAGE='en_US:en'
EXPOSE 8080
COPY target/HelloWorldAPI-1.0.0.jar /app.jar
CMD ["java", "-jar", "/app.jar"]