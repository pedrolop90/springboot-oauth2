ARG BUILD_IMAGE=gradle:6.7.1-jdk8
ARG RUNTIME_IMAGE=openjdk:11-jdk-slim

FROM ${BUILD_IMAGE} as dependencies
ENV APP_HOME=/
WORKDIR $APP_HOME

COPY build.gradle settings.gradle $APP_HOME
ADD src $APP_HOME/src
RUN gradle build 


FROM ${RUNTIME_IMAGE}

EXPOSE 8080

ENV ARTIFACT_NAME=*.jar
COPY --from=dependencies /build/libs/$ARTIFACT_NAME /app/test.jar
CMD ["java", "-jar", "/app/test.jar"]
