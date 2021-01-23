
-- drop table Orders;
-- drop table Users;
-- drop table AccessRoles;
-- drop table Products;
-- drop table News;


CREATE TABLE Products(
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(65) NOT NULL,
    Price DOUBLE NOT NULL,
    Description VARCHAR(265) DEFAULT NULL
);

CREATE TABLE AccessRoles ( 
    Id INT NOT NULL PRIMARY KEY,
    Role VARCHAR(12) NOT NULL
);

CREATE TABLE Users(
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(65) NOT NULL,
    LoginId VARCHAR(25) NOT NULL,
    Password VARCHAR(25) NOT NULL, 
    AccessRole INT NOT NULL,
    FOREIGN KEY (AccessRole) REFERENCES AccessRoles (Id)
);

CREATE TABLE Orders (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    OrderId INT NOT NULL,        
    UserId INT NOT NULL,
    ProductId INT NOT NULL, 
    FOREIGN KEY (UserId) REFERENCES Users (Id),
    FOREIGN KEY (ProductId) REFERENCES Products (Id)
);

 CREATE TABLE News(
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,      
    CreatedByUserId INT NOT NULL,
    NewsDescription VARCHAR(655) NOT NULL,
    FOREIGN KEY (CreatedByUserId) REFERENCES Users (Id)    
);

INSERT INTO AccessRoles  (Id, Role) VALUES (1, 'CUSTOMER');
INSERT INTO AccessRoles  (Id, Role) VALUES (2, 'ADMIN');