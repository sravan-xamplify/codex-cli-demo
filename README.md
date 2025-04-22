 # codexCliDemo

 This is a Spring Boot 3.4 application using Java 21 and Maven. It provides a simple REST endpoint.

 ## Prerequisites
 - Java 21
 - Maven 3.x

 ## Building
 ```bash
 mvn clean package -DskipTests
 ```

 ## Running

 ### Option 1: Jar
 ```bash
 java -jar target/codexclidemo-0.0.1-SNAPSHOT.jar
 ```

 ### Option 2: Maven
 ```bash
 mvn spring-boot:run
 ```

 After startup, open your browser at:
 - http://localhost:8080/
 - http://localhost:8080/welcome

 Both endpoints will return:
 ```
 Welcome to the new era
 ```
## Scripts

Alternatively, you can use the provided scripts to build and run without manually entering commands:

- On Unix/macOS:
  ```bash
  ./run.sh
  ```
- On Windows:
  ```bat
  run.bat
  ```