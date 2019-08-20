Get all students:
GET http://localhost:8080/Student-Management-System/api/students

Get student by id:
GET http://localhost:8080/Student-Management-System/api/students/:studentId

Create student
POST http://localhost:8080/Student-Management-System/api/students
Content-Type: application/json
{
"firstName": "Tony","lastName": "Reeds","emailAddress": "tony.reeds@yahoo.com"
}

Update student
PUT http://localhost:8080/Student-Management-System/api/students
Content-Type: application/json
{"id": 10,
"firstName": "Tony","lastName": "Reeds","emailAddress": "tony.reeds@yahoo.com"
}

Delete student
DELETE http://localhost:8080/Student-Management-System/api/students/:studentId