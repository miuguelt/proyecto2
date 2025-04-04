# Etapa 1: Build
FROM maven:3.8.4-openjdk-17 AS build

# Directorio de trabajo
WORKDIR /app

# Clonamos el repositorio desde GitHub (asegúrate de que la URL sea accesible)
RUN git clone https://github.com/miuguelt/proyecto2.git .

# Compilamos el proyecto y generamos el jar (se omiten los tests para agilizar el proceso)
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final
FROM openjdk:17-jdk-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiamos el jar compilado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto en el que corre la aplicación (ajusta según sea necesario)
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
