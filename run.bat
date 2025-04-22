@echo off
REM Build and run the Spring Boot application
mvn clean package -DskipTests
IF ERRORLEVEL 1 (
   echo Build failed
   exit /b %ERRORLEVEL%
)
java -jar target\codexclidemo-0.0.1-SNAPSHOT.jar