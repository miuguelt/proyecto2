# Usa una imagen base con JDK 21 (compatible con Spring Boot)
FROM openjdk:21-jdk-slim

# Configura el directorio de trabajo
WORKDIR /app

# Copia el código fuente y el archivo pom.xml
COPY . .

# Compila el proyecto con Maven (genera el .war)
RUN ./mvnw clean package -DskipTests

# Copia el archivo .war generado
COPY target/*.war app.war

# Expone el puerto de Tomcat (8080)
EXPOSE 8080

# Ejecuta la aplicación
CMD ["java", "-jar", "app.war"]