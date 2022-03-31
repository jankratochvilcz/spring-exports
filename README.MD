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