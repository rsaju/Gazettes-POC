FROM openjdk:8-jdk-alpine
LABEL maintainer="aswin"

RUN apk --update --no-cache add curl

ADD ./target/discovery-server.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/discovery-server.jar"]

HEALTHCHECK --interval=10s --timeout=30s --retries=10 CMD curl -f http://192.168.99.101:8761/actuator/health || exit 1

EXPOSE 8761
