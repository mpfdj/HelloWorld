# Set JAVA_HOME in maven
mvnw.cmd
set JAVA_HOME=%PROGRAMFILES%\Java\jdk-21.0.1

# Run app
./mvnw.cmd spring-boot:run -DskipTests

# Build artifact
.\mvnw.cmd clean package -DskipTests

# Show dependencies
.\mvnw.cmd dependency:tree

# Endpoints
http://localhost:8080/hello
http://localhost:8080/hello?name=miel
http://localhost:8080/ping

# Docker
# https://docs.docker.com/engine/reference/commandline/image_tag/
docker image build --no-cache --file Dockerfile --tag miel1980/helloworld-api:1.0.0 .
docker container run --rm --privileged -p 8080:8080 miel1980/helloworld-api:1.0.0



# What is the difference between a Filter and an Interceptor
https://stackoverflow.com/questions/35856454/difference-between-interceptor-and-filter-in-spring-mvc


# Run hashicorp http-echo
docker container run --rm --privileged -p 5678:5678 -text="hello world" hashicorp/http-echo:latest


https://stackoverflow.com/questions/56139706/speeding-up-apt-get-update-to-speed-up-docker-image-builds