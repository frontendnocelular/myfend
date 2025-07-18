# Fase 1: Usa uma imagem com Gradle para construir o projeto
FROM gradle:8.3-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle clean build --no-daemon

# Fase 2: Usa uma imagem mais leve para rodar só o Java
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/myfend.jar ./myfend.jar

EXPOSE 4567
CMD ["java", "-jar", "myfend.jar"]
