# ---------- Build Stage ----------
FROM eclipse-temurin:21-jdk as builder

WORKDIR /app

COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw clean package -DskipTests

# ---------- Runtime Stage ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

# Non-root user (security best practice)
RUN useradd -ms /bin/bash springuser
USER springuser

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]