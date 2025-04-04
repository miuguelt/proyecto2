# Etapa 1: Build con Maven y JDK 21
FROM maven:3.9.2-eclipse-temurin-21 AS build

# Directorio de trabajo
WORKDIR /app

# Clonamos el repositorio del proyecto
RUN git clone https://github.com/miuguelt/proyecto2.git .

# Compilamos el proyecto y generamos el WAR (omitimos tests para agilizar)
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final con OpenJDK 21
FROM openjdk:21-jdk-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiamos el WAR compilado desde la etapa build
# Se asume que el WAR se genera en target/ y que es el único WAR producido.
COPY --from=build /app/target/*.war app.war

# Exponemos el puerto donde corre la aplicación (ajusta si es necesario)
EXPOSE 8080

# Ejecutamos la aplicación
ENTRYPOINT ["java", "-jar", "app.war"]