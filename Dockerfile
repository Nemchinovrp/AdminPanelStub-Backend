# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="nemchinovrp@yandex.ru"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=build/libs/server-product-management-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} server-product.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/server-product.jar"]