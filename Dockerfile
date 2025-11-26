# Etapa 1: build usando la imagen oficial de Gradle
FROM gradle:9.1 AS build

# La imagen de Gradle usa por defecto /home/gradle/project como WORKDIR
WORKDIR /home/gradle/project

# Copiamos archivos de configuración de Gradle
COPY build.gradle settings.gradle ./
COPY gradle ./gradle

# Copiamos el código fuente
COPY src ./src

# Construimos el jar de Spring Boot
RUN gradle clean bootJar --no-daemon

# Etapa 2: runtime con un JRE ligero
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiamos el jar generado desde la etapa de build
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
