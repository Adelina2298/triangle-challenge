# triangle-challenge

Challenge
-
Given the sides of a triangle, determine its type.

A triangle can be equilateral, isosceles or scalene.

*eg:*

*equilateral: a = 3, b = 3, c = 3*

*isosceles: a = 3, b = 3, c = 4* 

*scalene: a = 3, b = 4, c = 5*

*not a valid triangle: a = 3, b = 5, c = 8*

Prerequisites
-
- Java 8+
- Maven

Build
-
`mvn clean install`

`java -jar target/triangle-1.0-SNAPSHOT.jar`

Swagger URL
-
For testing go to `http://localhost:9001/triangle-challenge/swagger-ui.html`