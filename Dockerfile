# ---------- 1단계: 빌드 ----------
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests -B

# ---------- 2단계: 실행 ----------
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app
COPY --from=build /app/target/aishop-backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
