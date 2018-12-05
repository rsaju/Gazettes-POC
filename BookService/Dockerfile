FROM openjdk:8-jdk-alpine
LABEL maintainer="Aswin & roshan"

RUN apk --update --no-cache add curl

ADD ./target/BookService.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/BookService.jar"]

EXPOSE 8083