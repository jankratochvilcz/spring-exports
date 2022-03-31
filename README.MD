# Todoist to Airtable Exports (Spring Boot)

_A quick and dirty prototype on how integrations would look if we wrote them in Spring boot._

## Local setup

Under `src/main/resources`, create _application.properties with the following contents._

```properties
management.endpoints.web.exposure.include=*
spring.codec.max-in-memory-size=20MB
spring.mustache.prefix=classpath:/templates/
spring.mustache.suffix=.mustache

airtable.token=AIRTABLE TOKEN
airtable.app-id=AIRTABLE BASE ID

todoist.token=TODOIST TOKEN
```

Running it:
1. Install IntelliJ IDEA & [Java JDK 18](https://www.oracle.com/java/technologies/downloads/#jdk18-linux)
2. Open the project
3. Navigate to _src/main/resources/application.properties_ and run the `main` function :-)