# Etapa 1: Construcción del proyecto con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar el archivo pom.xml y descargar dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el resto del código fuente y compilar
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar la app
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiar el jar desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto 8080 (Render redirige automáticamente)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
