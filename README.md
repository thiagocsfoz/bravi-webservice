# Todo List API


# Requeriments:
- JAVA 8
- Maven
- Docker

# Start Webservice

Start without docker
```bash
mvn spring-boot:run
```

Start with docker
```bash
mvn clean package
```

```bash
docker build -t springio/gs-spring-boot-docker .
```

```bash
run -p 8080:8080 springio/gs-spring-boot-docker .
```

Access http://localhost:8080/h2 for database and put in JDBC URL
```bash
jdbc:h2:file:~/src/main/resources/datasource/h2.db
```