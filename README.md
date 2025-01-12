
                                        # **Waste Management API**

---

## **Overview**

The **Waste Management API** is a Spring Boot application designed to manage waste categories, disposal guidelines, and recycling tips. It provides a robust RESTful API for performing CRUD operations on these entities. This application is containerized using Docker for ease of deployment and scalability.

---

## **Features**

- Manage **Waste Categories**: Add, update, delete, and retrieve waste categories.
- Manage **Disposal Guidelines**: Define guidelines for proper waste disposal.
- Manage **Recycling Tips**: Share tips to encourage sustainable recycling practices.
- Integrated with an H2 in-memory database for fast prototyping and testing.
- Containerized using Docker for seamless deployment.

---

## **Prerequisites**

To run this application, ensure you have the following installed:
- **Java 17**
- **Maven**
- **Docker** (optional for containerized deployment)

---

## **Setup and Installation**

### **1. Clone the Repository**
```bash
git clone git@github.com:Koena-Developments/WasteManagement_RestfulAPI.git
cd WasteManagementAPI
2. Build the Application
Use Maven to build the project and package it into a JAR file:

bash

mvn clean package
3. Run the Application
Locally
Start the application:

bash

mvn spring-boot:run
Access the API at http://localhost:8080.

Using Docker
Build the Docker image:
bash

docker build -t waste-management .
Run the Docker container:
bash

docker run -p 8080:8080 waste-management
Access the API at http://localhost:8080.

How to Use the Application
Access the H2 Console
The application uses an in-memory H2 database. To access the H2 console:

Navigate to: http://localhost:8080/h2-console.
Use the following credentials:
JDBC URL: jdbc:h2:mem:testdb
Username: thabang
Password: 9906165353086Tm#
Testing the API
You can use tools like Postman, cURL, or any REST client to interact with the API.

API Endpoints
Waste Categories

Get All Waste Categories
GET /api/waste-categories

Get Waste Category by ID
GET /api/waste-categories/{id}

Create Waste Category
POST /api/waste-categories
Body:
json
{
    "name": "Plastic",
    "description": "Non-biodegradable waste"
}
Update Waste Category
PUT /api/waste-categories/{id}
Body:
json
{
    "name": "Updated Name",
    "description": "Updated Description"
}
Delete Waste Category
DELETE /api/waste-categories/{id}

Disposal Guidelines
Get All Disposal Guidelines
GET /api/disposal-guidelines

Get Disposal Guideline by ID
GET /api/disposal-guidelines/{id}

Create Disposal Guideline
POST /api/disposal-guidelines
Body:
json
{
    "wasteCategory": "Plastic",
    "guideline": "Recycle in blue bins"
}

Update Disposal Guideline
PUT /api/disposal-guidelines/{id}
Body:
json
{
    "wasteCategory": "Glass",
    "guideline": "Recycle in designated bins"
}

Delete Disposal Guideline
DELETE /api/disposal-guidelines/{id}

Recycling Tips
Get All Recycling Tips
GET /api/recycling-tips

Get Recycling Tip by ID
GET /api/recycling-tips/{id}

Create Recycling Tip
POST /api/recycling-tips
Body:
json
{
    "tip": "Reuse jars as containers"
}

Update Recycling Tip
PUT /api/recycling-tips/{id}
Body:
json

{
    "tip": "Recycle old newspapers"
}
Delete Recycling Tip
DELETE /api/recycling-tips/{id}

Error Handling
The API provides detailed error messages in JSON format:

400 Bad Request: Validation errors (e.g., missing required fields).

404 Not Found: Resource not found.

500 Internal Server Error: Unexpected server errors.

Development Workflow

Technologies Used
Spring Boot: Backend framework for REST API development.
Hibernate/JPA: ORM for database interaction.
H2 Database: In-memory database for testing and prototyping.
Docker: Containerization for deployment.
Contact
For any questions or feedback, feel free to reach out:

Name: Thabang Motswenyane
Email: thabangmotswenyane511@gmail.com
