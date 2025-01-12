Waste Management API
Project Overview
The Waste Management API is a RESTful web application designed to manage data related to waste categories, disposal guidelines, and recycling tips. This application is built using Spring Boot and features a modular, scalable design.

Features
CRUD Operations:
Manage waste categories.
Manage disposal guidelines.
Manage recycling tips.
Validation:
Ensure data integrity with input validation using @NotBlank, @Size, etc.
Error Handling:
User-friendly error messages with structured responses.
Database Integration:
Uses an H2 in-memory database for development and testing.
Tech Stack
Backend: Spring Boot, Java
Database: H2 (in-memory)
Testing: JUnit 5, Mockito
Build Tool: Maven
Getting Started
Prerequisites
Make sure you have the following installed:

Java 17+
Maven 3.6+
An IDE (e.g., IntelliJ IDEA, Eclipse)
Installation and Setup
Clone the Repository:

bash
Copy code
git clone git@github.com:Koena-Developments/WasteManagement_RestfulAPI.git
cd waste-management
Build the Project:

bash
Copy code
mvn clean install
Run the Application:

bash
Copy code
mvn spring-boot:run
Access the API:

Base URL: http://localhost:8080
Example Endpoints:
GET /api/waste-categories
POST /api/disposal-guidelines
API Documentation
Waste Categories
Method	Endpoint	Description	Example Request Body
GET	/api/waste-categories	Get all waste categories	{}
GET	/api/waste-categories/{id}	Get a waste category by ID	{}
POST	/api/waste-categories	Create a new waste category	{"name": "Plastic", "description": "Non-biodegradable"}
PUT	/api/waste-categories/{id}	Update a waste category	{"name": "Glass", "description": "Recyclable"}
DELETE	/api/waste-categories/{id}	Delete a waste category	{}
Disposal Guidelines
Method	Endpoint	Description	Example Request Body
GET	/api/disposal-guidelines	Get all disposal guidelines	{}
GET	/api/disposal-guidelines/{id}	Get a guideline by ID	{}
POST	/api/disposal-guidelines	Create a new guideline	{"wasteCategory": "Plastic", "guideline": "Recycle in blue bins"}
PUT	/api/disposal-guidelines/{id}	Update a guideline	{"wasteCategory": "Glass", "guideline": "Recycle in green bins"}
DELETE	/api/disposal-guidelines/{id}	Delete a guideline	{}
Recycling Tips
Method	Endpoint	Description	Example Request Body
GET	/api/recycling-tips	Get all recycling tips	{}
GET	/api/recycling-tips/{id}	Get a tip by ID	{}
POST	/api/recycling-tips	Create a new recycling tip	{"tip": "Reuse jars as containers"}
PUT	/api/recycling-tips/{id}	Update a recycling tip	{"tip": "Recycle old newspapers"}
DELETE	/api/recycling-tips/{id}	Delete a recycling tip	{}
Validation

WasteCategory:
name: Must not be blank, max 100 characters.

description: Optional, max 255 characters.

DisposalGuideline:

wasteCategory: Must not be blank.

guideline: Must not be blank.

RecyclingTip:
tip: Must not be blank.
Error Handling

404 Not Found:
Returned if a requested resource does not exist.

400 Bad Request:
Returned if input validation fails.
Example Response:
json

Copy code
{
    "name": "Name is required"
}

Testing
Unit Tests:
Services are tested using JUnit and Mockito.
Integration Tests:
Controllers are tested using MockMvc.
Run all tests:

bash
Copy code
mvn test

Future Improvements
Add authentication and authorization.
Implement Swagger/OpenAPI documentation.
Deploy the application using Docker or a cloud platform.

Contributors
Thabang Motswenyane
