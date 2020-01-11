FROM openjdk:8-jdk-slim
ENV TZ=Europe/Rome

WORKDIR /srv/app/
COPY ./target/worksocialmedia.jar ./app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
