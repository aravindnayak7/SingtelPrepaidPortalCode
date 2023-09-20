# SingtelPrepaidPortalCode
This project aims to create a user-friendly portal for Singtel's prepaid customers, allowing them to manage their plans, top-up, and customize their mobile services easily. This repository contains the code and documentation for the implementation of the portal, including the API contracts, sample data, and usage instructions.


# Singtel Prepaid Customer Portal

Singtel Prepaid Customer Portal is a full-stack application that allows customers to manage their prepaid plans and add-on features. This application provides various features and endpoints to interact with prepaid plans, such as searching for available plans, topping up with selected plans, searching for add-on features, topping up add-ons with existing plans, and removing add-on features.

## Table of Contents
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Sample Requests](#sample-requests)
- [Testing](#testing)
- [Code Coverage](#code-coverage)
- [Frontend](#frontend)
- [Additional Features](#additional-features)
- [Contributing](#contributing)


## Technologies Used
- Java 17
- Spring Boot 3
- Maven
- Angular (for the frontend)
- MySQL 
- Mockito (for testing)
- Jacoco (for code coverage)

## Getting Started
1. Clone the repository to your local machine.

    ```bash
    git clone https://github.com/yourusername/singtel-prepaid-portal.git
    ```

2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

3. Build and run the Spring Boot application.

    ```bash
    mvn spring-boot:run
    ```

   The backend application will start on http://localhost:8085.

4. To run the frontend application, navigate to the frontend directory and follow the instructions in the frontend README.

## API Endpoints
The backend provides the following API endpoints:

- Add a New Prepaid Plan
  - POST /api/v1/addplan
- Update an Existing Prepaid Plan
  - PUT /api/v1/updateplan/{planId}
- Get Details of a Prepaid Plan
  - GET /api/v1/getplan/{planId}
- Get a List of All Available Prepaid Plans
  - GET /api/v1/getAllPlans
- Delete a Prepaid Plan
  - DELETE /api/v1/delete/{planId}
- Get Prepaid Plans by Name
  - GET /api/v1/getplannames/{planName}

## Sample Requests
Here are some sample requests to interact with the API:

### Add a New Prepaid Plan
Request:

POST http://localhost:8085/api/v1/addplan

Request Body:

```json
{
    "planName": "Singtel-Basic",
    "planCost": 20,
    "planDetails": "110 SMS, 510 calls, 2 GB",
    "planDescription": "This is the basic prepaid plan offered by Singtel."
}
Get Details of a Prepaid Plan
Request:

GET http://localhost:8085/api/v1/getplan/2

Get a List of All Available Prepaid Plans
Request:

GET http://localhost:8085/api/v1/getAllPlans

Delete a Prepaid Plan
Request:

DELETE http://localhost:8085/api/v1/delete/57

Get Prepaid Plans by Name
Request:

GET http://localhost:8085/api/v1/getplannames/Singtel-Advance

## Testing
The application includes unit tests and integration tests. To run the tests, use the following command:

bash
Copy code
mvn test


## Code Coverage

Code coverage reports can be generated using the Jacoco plugin. After running the tests, you can find the coverage report in the target/site/jacoco/index.html file. The goal is to achieve at least 80% code coverage.

## Frontend
The frontend of this application is built using Angular. You can find the frontend code and instructions for running it in the frontend directory of this repository.

## Additional Features
Cron Job Scheduling
The application includes additional features such as:

Scheduled tasks for sending notifications to users.
Exception handling for handling plan not found and plan already exists scenarios.

Cross-origin resource sharing (CORS) configuration to allow requests from http://localhost:4200 (frontend).