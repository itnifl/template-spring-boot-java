# Spring Boot starter for Java 11

To start MYSqL in Docker:
## MySQL in Docker
`application.yml` already contains connection information to this DB.
```shell script
docker-compose up -d
```

Code is written in Visual Studio Code and can be run from Visual Studio Code (for instance: Run -> Run without debugging). It can then be tested via a browser or Rest Client.
After starting, the following urls are available:
- localhost:8080/news
- localhost:8080/products
- localhost:8080/orders

The database layer is not properly implemented, but is scaffolded. Data will therefore not persist.
uthorization is implemented, but users are hardcoded. Should be fetched from the database 
    b/p: user/userpass
    b/p: admin/adminpass
Tests should have been written first, but because of time pressure - functionality was focused on first.
Time consumed on coding was 5 hours (none of the technology was known beforehand).

Task 1: Roles ADMIN and CUSTOMER are implemented in database and in code
    a. Correct access rights are defined as in the requirements.
    
Task 2: Backend handles products as required, but the database layer is not finnished.

Task 3: Shopping cart functionality is not implemented in the code, but could be a controller that reads from the Orders table (see already created OrdersController, but this specific functionality is not there as of now). 

Task 4: Database model is roughly depicted in databaseSchema.sql. It still handles multiple orders (see table Orders.OrderId).

Task 5: Not implemented, but is related to the orders controller.




