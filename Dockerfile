FROM openjdk:11-jdk-slim

WORKDIR /app

COPY src /app/src

RUN javac src/*.java

CMD ["java", "-cp", "src", "BankApp"]
