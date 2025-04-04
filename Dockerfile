# Etapa de construcción
FROM maven:3.8.7-eclipse-temurin-21 AS build

# Instalar Git y clonar el repositorio
RUN apt-get update && apt-get install -y git
RUN git clone https://github.com/miuguelt/proyecto2.git /app

# Construir el proyecto
WORKDIR /app
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:21-jre
COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]