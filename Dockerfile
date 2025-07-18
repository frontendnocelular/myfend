# Usa uma imagem com Java 17 e Gradle para buildar seu projeto
FROM gradle:8.0-jdk17 AS build

WORKDIR /app

# Copia todo o seu código para a imagem
COPY . .

# Compila o projeto para gerar o arquivo myfend.jar
RUN gradle build --no-daemon

# Agora uma imagem menor só pra rodar o jar
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copia o jar gerado para essa imagem
COPY --from=build /app/build/libs/myfend.jar ./myfend.jar

# Diz que a aplicação vai usar a porta 4567
EXPOSE 4567

# Comando para rodar o backend
CMD ["java", "-jar", "myfend.jar"]
