# TEST_assignment_3

### TASK 1: ACQUIRE THE SYSTEM
The system is developed with Spring Boot and PostgreSQL. To run PostgreSQL in a docker container run this script: [docker-compose]([src/main/resources/db/migration/V3__AlterCustomersAddMobileColumn.sql](docker-compose-db.yml))

### TASK 2: IMPLEMENT REQUIREMENTS 

#### R1: It must be possible to create customers, employees and bookings.

Features are tested both in service layer and data layer and are listed below

#### R2: A customer may have a phone number (this change requires a database migration script).

   - [DB Migration File](src/main/resources/db/migration/V3__AlterCustomersAddMobileColumn.sql)   


#### R3: When booking an appointment with a customer, an SMS must be sent

#### Data layer
Data layer is tested in one file as the scope is very little
   - [Persistance Unit Test](src/test/java/cph/testass3/unitTest/RepositoryTest.java)   


#### Service layer
Customer Service Implementation Test :
- [Customer Service Integration Test](src/test/java/cph/testass3/unitTest/CustomerServiceImplTest.java)

Employee Service Implementation Test :
- [Employee Service Integration Test](src/test/java/cph/testass3/unitTest/EmployeeServiceImplTest.java)


Booking Service Implementation Test : 
- [Booking Service Integration Test](src/test/java/cph/testass3/unitTest/BookingServiceImplTest.java)
