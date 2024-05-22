# Use the official OpenJDK image from the Docker Hub
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the source code to the container
COPY src /app/src

# Compile the Java source code
RUN javac src/*.java

# Command to run the application
CMD ["java", "-cp", "src", "BankApp"]
