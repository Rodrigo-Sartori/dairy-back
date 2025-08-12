# Etapa 1: Build
FROM gradle:8.8-jdk17 AS build
WORKDIR /app

# Copia apenas os arquivos necessários para build
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
COPY src ./src

# Gera o jar
RUN ./gradlew bootJar --no-daemon -x test

# Etapa 2: Imagem final
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia o jar da etapa de build
COPY --from=build /app/build/libs/*.jar app.jar

ENV PORT=8080
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
