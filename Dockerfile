FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY ./target/*.jar app.jar
COPY player.csv player.csv
CMD ["java", "-jar", "app.jar"]