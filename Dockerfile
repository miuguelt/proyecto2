# Etapa 1: Build
FROM maven:3.9.2-eclipse-temurin-21 AS build

# Directorio de trabajo
WORKDIR /app

# Clonamos el repositorio del backend desde GitHub
RUN git clone https://github.com/miuguelt/proyecto2.git .

# Compilamos el proyecto y generamos el jar (omitimos tests para agilizar)
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final
FROM openjdk:21-jdk-slim

# Establecemos el directorio de trabajo
WORKDIR /app

# Copiamos el jar compilado desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto en el que corre la aplicación (ajusta si es necesario)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]