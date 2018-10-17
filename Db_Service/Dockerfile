FROM openjdk:8-jdk-alpine
LABEL maintainer="roshan"

RUN apk --update --no-cache add curl

ADD ./target/db-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/db-service.jar"]

EXPOSE 8082
