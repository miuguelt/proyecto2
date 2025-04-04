# Usa una imagen base con JDK 21 (compatible con Spring Boot)
FROM openjdk:21-jdk-slim

# Configura el directorio de trabajo
WORKDIR /app

# Copia el código fuente completo (incluyendo Maven y recursos)
COPY . .

# Instala dependencias y compila el proyecto con Maven
RUN ./mvnw clean package -DskipTests

# Copia el archivo .war generado a la carpeta de despliegue
COPY target/*.war /app/app.war

# Exponer el puerto de Tomcat (8080)
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "app.war"]