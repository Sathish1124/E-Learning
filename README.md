**E-Learning Platform RESTful API**

This is a basic E-Learning Platform RESTful API built with Spring Boot and uses an in-memory database. The API provides endpoints for managing courses, modules, student enrollments, progress tracking, quiz submissions, and assignment submissions.

**Endpoints**
1. Access All Available Courses:

    GET /api/courses

2. Create a New Course

    POST /api/courses


3. Add a New Module to a Course      

    POST /api/courses/{courseId}/modules
  
    Add a new module to a specific course identified by {courseId}.

4. Enroll a Student in a Course

    POST /api/enrollments


5. Track a Student's Progress

    GET /api/progress
   
6.Track a Student's Progress
 
    Get  /api/{studentId}/progress"

    Requires Student ID.
    
7. Submit Quiz Answers

    POST /api/quizzes

    Submit quiz answers. Requires Student ID and submitted answers in the request body.

8. Submit an Assignment

    POST /api/assignments

    Submit an assignment. Requires Student ID and assignment data in the request body.



**Running the Application:**

Clone the repository:

Build and run the application:

The API will be available at http://localhost:8080.



**Testing the API:**

You can use tools like Insomnia or Postman to test the API endpoints.

**Example Requests**:


**GET /api/courses**

GET http://localhost:8080/api/courses


**POST /api/courses**

POST http://localhost:8080/api/courses

{
  "courseName": "New Course"
}


**POST /api/courses/{courseId}/modules**

POST http://localhost:8080/api/courses/1/modules

{
"moduleTitle": "Module Name"	
}


**POST /api/enrollments**

POST http://localhost:8080/api/enrollments

{
	"studentName":"Student Name"
}


**GET /api/progress**


GET http://localhost:8080/api/progress


**Get  /api/{studentId}/progress**

http://localhost:8080/api/1/progress


**POST /api/quizzes**

POST http://localhost:8080/api/2/quizzes

{
	"question":"questions",
	"answer":4
}

**POST /api/assignments**

POST http://localhost:8080/api/1/assignments

{
	"title":"title name",
	"assignment":"Answers"
}


Notes:
I've not yet added the exceptional handlings to the service layer, so test the api's accordingly.
