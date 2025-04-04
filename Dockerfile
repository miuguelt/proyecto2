# Usamos una imagen base de OpenJDK (puedes ajustar la versión a la que requieras)
FROM openjdk:17-jdk-slim

# Indicamos que el contenedor expondrá el puerto 8080 (puedes modificar si usas otro)
EXPOSE 8080

# Argumento para pasar el nombre del jar generado
ARG JAR_FILE=target/*.jar

# Copiamos el jar dentro del contenedor
COPY ${JAR_FILE} app.jar

# Comando de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]