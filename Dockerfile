FROM openjdk:26-slim
WORKDIR /app
COPY target/* app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
