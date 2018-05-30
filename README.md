## Backbase Assignment
##### Armando Reyna Altamirano

###The Requirement

####Overview

Create a Java web application based on the standard servlet spec
The web application should provide a REST api to create a list of ING ATMs in a given Dutch city and return a well formed JSON response
The web application should invoke an external service to gather a super set of the data:  https://www.ing.nl/api/locator/atms/
Create a page that shows the list of ING ATMs
Use Spring and Maven. If you do not have experience in these frameworks, please feel free to use an alternative.

####Bonus features

Use of Apache Camel to route the web service call
Secure the page with Spring security
Unit tests using jUnit

###The Solution
The solution is built with the following technologies:
- Spring Boot
- Spring Security
- Apache Camel
- h2database
- JUnit + Mockito
- JSP's
- Angular JS
- Bootstrap
- Github
- Jenkins

####Explanation

1. The solution uses org.apache.camel.builder.RouteBuilder & org.apache.camel.component.http4.HttpMethods to consume the REST API
2. Once the atm's API is consumed: https://www.ing.nl/api/locator/atms/ the camel services passes the outputs to an internal REST Service '/api/v1/atm' POST
3. This service processes the info and stores it into the database
4. An other service has been created to get the ATM's list
5. This service is paginated
6. A page with the list of ATM's is available
7. The application requires authentication made with spring security, please use the following credentials to login:
`user: bobby`
`password: password`
8. Tha application has been deployed using Github + Jenkins

### Demo
http://backbase.airsoftware.solutions

`user: bobby`
`password: password`

### Build the Project
All configurations can be edited within the *application.yml* file
No external configuration is needed, even the database is created automatically.

### Build the Project
```
mvn clean install
```

### Output
war file
