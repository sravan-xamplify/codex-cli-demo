#!/usr/bin/env bash
# Build and run the Spring Boot application
mvn clean package -DskipTests || { echo "Build failed"; exit 1; }
exec java -jar target/codexclidemo-0.0.1-SNAPSHOT.jar