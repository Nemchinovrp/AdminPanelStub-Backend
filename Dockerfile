FROM openjdk:8-jdk-alpine

LABEL maintainer="nemchinovrp@yandex.ru"

EXPOSE 8080

ARG JAR_FILE=build/libs/server-product-management-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} server-product.jar

ENTRYPOINT ["java","-jar","/server-product.jar"]