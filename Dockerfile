FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /workspace/app

COPY /build/libs/demo*.jar demo.jar

RUN mkdir -p target/extracted &&  \
    java -Djarmode=layertools -jar demo.jar extract --destination target/extracted

FROM eclipse-temurin:17-jdk-alpine

RUN addgroup -S demo && adduser -S demo -G demo
USER demo

VOLUME /tmp
ARG EXTRACTED=/workspace/app/target/extracted
COPY --from=build ${EXTRACTED}/dependencies/ ./
COPY --from=build ${EXTRACTED}/spring-boot-loader/ ./
COPY --from=build ${EXTRACTED}/snapshot-dependencies/ ./
COPY --from=build ${EXTRACTED}/application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]
