# Etapa de build
FROM gradle:8.7-jdk17 AS builder
WORKDIR /app

COPY . .

# Dá permissão pro Gradle Wrapper
RUN chmod +x gradlew

# Compila o jar sem rodar testes
RUN ./gradlew bootJar --no-daemon -x test

# Etapa de runtime
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Define a variável PORT pro Render
ENV PORT=8080

# Copia o jar gerado na etapa anterior
COPY --from=builder /app/build/libs/*.jar app.jar

# Expõe a porta pro Render
EXPOSE 8080

# Sobe a aplicação na porta do Render
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]