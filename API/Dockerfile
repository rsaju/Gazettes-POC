FROM openjdk:8-jdk-alpine
LABEL maintainer="Aswin & roshan"

RUN apk --update --no-cache add curl

ADD ./target/API.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/API.jar"]

EXPOSE 8081