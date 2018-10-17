FROM openjdk:8-jdk-alpine
LABEL maintainer="roshan"

RUN apk --update --no-cache add curl

ADD ./target/configserver.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/configserver.jar"]

HEALTHCHECK --interval=10s --timeout=30s --retries=10 CMD curl -f http://192.168.99.101:8888/actuator/health || exit 1

EXPOSE 8888
