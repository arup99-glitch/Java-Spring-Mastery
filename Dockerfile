# Use the official Amazon Corretto 21 image as the base
FROM amazoncorretto:17-alpine

# Set the working directory
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/spring-mastery-0.0.1-SNAPSHOT.jar app.jar


# Expose the port your application will run on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
