Scheduler Backend
The Scheduler Backend is a Spring Boot-based RESTful API that serves as the backbone for the Scheduler application. It manages tasks, projects, and user authentication, integrating securely with a PostgreSQL database and Keycloak for user management.

Features
Task Management: Create, update, delete, and retrieve tasks.
Project Management: Visualize project evolution using Gantt charts.
User Authentication: Secure login and access control using Keycloak.
Database Integration: Efficient data storage with PostgreSQL.
Docker Support: Containerized application for easy deployment.
Technologies Used
Spring Boot: Backend framework.
PostgreSQL: Relational database management.
Keycloak: Authentication and authorization.
Docker: Containerization.
Postman: API testing.
Java: Programming language.
Prerequisites
Java 17 or higher
PostgreSQL (version 12 or above)
Docker (optional but recommended)
Keycloak Server (configured with realms and clients for the Scheduler app)
Installation
Clone the Repository
bash
Copy code
git clone https://github.com/your-username/scheduler-backend.git
cd scheduler-backend
Set Up the Environment
Create a .env file in the root directory and add your environment variables:
env
Copy code
DB_HOST=localhost
DB_PORT=5432
DB_NAME=scheduler
DB_USER=your-username
DB_PASSWORD=your-password
KEYCLOAK_URL=http://localhost:8080/auth
KEYCLOAK_REALM=your-realm
KEYCLOAK_CLIENT_ID=your-client-id
Start Services with Docker
If using Docker, run the following to start PostgreSQL and Keycloak:

bash
Copy code
docker-compose up -d
Run the Application
Build and run the application:

bash
Copy code
./mvnw spring-boot:run
API Endpoints
Authentication
POST /auth/login: Authenticate a user.
Task Management
GET /tasks: Retrieve all tasks.
POST /tasks: Create a new task.
PUT /tasks/{id}: Update an existing task.
DELETE /tasks/{id}: Delete a task.
Project Management
GET /projects: Retrieve all projects.
POST /projects: Create a new project.
PUT /projects/{id}: Update an existing project.
DELETE /projects/{id}: Delete a project.
Development
Testing
Use Postman or similar tools to test the API endpoints. Import the provided Postman collection:

bash
Copy code
Scheduler-Postman-Collection.json
Building Docker Image
To build a Docker image for the backend:

bash
Copy code
docker build -t scheduler-backend .
Contributing
Fork the repository.
Create a new branch (git checkout -b feature/your-feature).
Commit your changes (git commit -m 'Add some feature').
Push to the branch (git push origin feature/your-feature).
Open a pull request.
