# NBA Zone API
> **Note:** This repository serves as a backend portfolio project created for an internship. It demonstrates my skill in Java, Spring Boot, REST API design, and Docker.

A simple REST API to manage and retrieve NBA player data. This project is built using Spring Boot and Docker.

The primary data source for this project comes from Kaggle:
[NBA Players Data](https://www.kaggle.com/datasets/justinas/nba-players-data)

---

## Main Features

* **REST API**: Provides HTTP endpoints (GET, POST, PUT, DELETE) to manage player data.
* **Database Initialization**: Automatically imports NBA player data from a `.csv` file (the Kaggle dataset) into a PostgreSQL database on the first run.
* **Containerized**: Fully configured to run using Docker and Docker Compose, simplifying development setup and deployment.
* **Layered Architecture**: Uses a standard Spring Boot architecture (Controller, Service, Repository) for a clear separation of concerns.

---

## Technology Used

* **Backend**: Java 17
* **Framework**: Spring Boot
    * Spring Web (REST API)
    * Spring Data JPA (Database Access)
* **Database**: PostgreSQL
* **Build Tool**: Apache Maven
* **Containerization**: Docker & Docker Compose

---

## Project Structure

Here is the main directory structure for the `nba-zone` project:
```
nba-zone/
├── db-init/
│   ├── all_seasons.csv               # Source data from Kaggle
│   └── initiate.sql                  # SQL script to create the table
├── src/main/java/com/nba/nba_zone/
│   ├── controller/
│   │   └── PlayerController.java     # REST API Endpoints
│   ├── player/
│   │   └── Player.java               # JPA Entity (Data Model)
│   ├── repository/
│   │   └── PlayerRepository.java     # Spring Data JPA Interface
│   ├── service/
│   │   └── PlayerService.java        # Business Logic
│   └── NbaZoneApplication.java       # Main Spring application file
├── src/main/resources/
│   └── application.properties        # Application configuration
├── docker-compose.yml                # Defines the application and database services
├── dockerfile                        # Instructions for building the application's Docker image
└── pom.xml                           # Maven dependencies and configuration
```
---

## Prerequisites

To run this project, you need:

1.  **Docker**: [Install Docker](https://docs.docker.com/get-docker/)
2.  **Docker Compose**: This is typically included with Docker Desktop.

---

## Installation and Running

This project is designed to be run easily using Docker Compose.

1.  **Clone the Repository**
    ```bash
    git clone "https://github.com/OcinJr/porto-backend.git"
    cd porto-backend/nba-zone
    ```

2.  **Run with Docker Compose**
    Open a terminal in the `nba-zone` directory (where the `docker-compose.yml` file is located) and run the following command:

    ```bash
    docker-compose up --build
    ```

    This command will:
    * Build the Docker image for the Spring Boot application (`dockerfile`).
    * Create a container for the Spring Boot application.
    * Create a container for the PostgreSQL database.
    * Run the `initiate.sql` script and import data from `all_seasons.csv` into the database.

The application will be running at `http://localhost:8080`.

---
## Triubleshooting

Solutions to some common errors:

**Error 1: Docker Desktop is not running**
```
ERROR: error during connect: Head "http://%2F%2F.%2Fpipe%2FdockerDesktopLinuxEngine/_ping": open //./pipe/dockerDesktopLinuxEngine: The system cannot find the file specified.
```
Solution: Start or restart your Docker Desktop application.


**Error 2: Maven build failure (exit code 1)**
```
ERROR: failed to build: failed to solve: process "/bin/sh -c mvn clean package -DskipTests" did not complete successfully: exit code: 1
```

Solution: This often means there are no Java files to compile (e.g., cloned an empty project). Make sure the `.java` source files are present in the `src/main/java` directory.

**Error 3: Port 8080 is already in use**
```
Web server failed to start. Port 8080 was already in use.
```

Solution: Another service on your computer is using port 8080. You can find and stop it using these commands in your terminal:
1. Find the process ID (PID):
```bash
netstat -ano | findstr :8080
```

2. Stop the process (replace [PID] with the number you found):
```bash
taskkill /PID [PID] /F
```

---

## Usage Example

Once the application is running at http://localhost:8080, you can access the API endpoints.
The base path for the API is `/nba/player`.

You can use `curl` or a tool like Postman:

**Example: Get all player data**
```bash
curl http://localhost:8080/nba_data/players
```

**Get Players by Query (Team, Name, or Country)**

```bash
# By Team
curl "http://localhost:8080/nba/player?team=LAL"
```

```bash
# By Name
curl "http://localhost:8080/nba/player?name=LeBron James"
```

```bash
# By Country
curl "http://localhost:8080/nba/player?country=USA"
```
