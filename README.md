# Spring Boot starter for Java 11

## MySQL in Docker
`application.yml` already contains connection information to this DB.
```shell script
docker-compose up -d
```

- Code is written in Visual Studio Code and can be run from Visual Studio Code (for instance: Run -> Run without debugging).It can then be tested via a browser or Rest Client.
- The database layer is not properly implemented, but is scaffolded. Data will therefore not persist.
- Authorization is implemented, but users are hardcoded. Should be fetched from the database 
    b/p: user/userpass
    b/p: admin/adminpass
- Tests should have beeen written first, but because of time pressure - functionality was focused on first.
- Time consumed on coding was 5 hours (none of the technology was known before).

Task 1: Roles ADMIN and CUSTOMER are implemented in database and in code
    a. Correct access rights are defined as in the requirement.
Task 2: Backend handles products are required in the code, but the database layer is not finnished.
Task 3: Shopping cart functionality is not implemented in the code, but could be a controller that reads from the Orders table (see already createdOrdersController, bbut this specific functionality is not there). 
Task 4: Database model is roughly depicted, but handles multiple orders (see table Orders.OrderId).
Task 5: Not implemented, but is related to the orders controller.

