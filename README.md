# Scheduler Backend

The **Scheduler Backend** is a Spring Boot-based RESTful API that serves as the backbone for the Scheduler application. It manages tasks, projects, and user authentication, integrating securely with a PostgreSQL database and Keycloak for user management.

## Features

- **Task Management**: Create, update, delete, and retrieve tasks.
- **Project Management**: Visualize project evolution using Gantt charts.
- **User Authentication**: Secure login and access control using Keycloak.
- **Database Integration**: Efficient data storage with PostgreSQL.
- **Docker Support**: Containerized application for easy deployment.

## Technologies Used

- **Spring Boot**: Backend framework.
- **PostgreSQL**: Relational database management.
- **Keycloak**: Authentication and authorization.
- **Docker**: Containerization.
- **Postman**: API testing.
- **Java**: Programming language.

## Prerequisites

- **Java 17** or higher
- **PostgreSQL** (version 12 or above)
- **Docker** (optional but recommended)
- **Keycloak Server** (configured with realms and clients for the Scheduler app)

## Installation

### Clone the Repository
  ```bash
  git clone https://github.com/your-username/scheduler-backend.git
  cd scheduler-backend
