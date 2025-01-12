# Use an official Java runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven-built JAR file into the container
COPY target/waste-management-api-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Set the command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
