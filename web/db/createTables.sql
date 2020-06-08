/*DROP TABLE USERS;
DROP TABLE LOGHISTORY;
DROP TABLE PRODUCT;
DROP TABLE CATEGORY;
DROP TABLE BASKET;
DROP TABLE ORDERS;
DROP TABLE ORDERLINE;
DROP TABLE PAMENT;
DROP TABLE PAYMENT;
DROP TABLE SHIPMENT; */


CREATE TABLE USERS (
id              INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                    (START WITH 1, INCREMENT BY 1), 
fName           VARCHAR(10),
lName           VARCHAR(10),
password        VARCHAR(20),
email           VARCHAR(50) NOT NULL,
mobileNum       VARCHAR(20),
address         VARCHAR(50),
usertype        VARCHAR(10),
active          BOOLEAN
);


CREATE TABLE LOGS (
logId INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 100, INCREMENT BY 1), 
userId INT,
timestamp Timestamp,
description VARCHAR(50)
);


CREATE TABLE CATEGORY
(
categoryID      INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
categoryName    VARCHAR(10),
description     VARCHAR(100)
);

CREATE TABLE PRODUCT
(
productID       INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                    (START WITH 1, INCREMENT BY 1), 
categoryID      INTEGER,
productName     VARCHAR(20),
productPrice    DOUBLE,
description     VARCHAR(300),
status          VARCHAR(10),
quantity        INTEGER,
productType     VARCHAR(20)
);

ALTER TABLE PRODUCT ADD FOREIGN KEY (categoryID) REFERENCES CATEGORY (categoryID);


CREATE TABLE ORDERLINE
(
productID          INTEGER REFERENCES PRODUCT (productID),
customerID         INTEGER REFERENCES USERS (id),
orderQty           INTEGER,
price           DOUBLE,
PRIMARY KEY (productID, customerID)
);

CREATE TABLE CARD
(
userId Integer,
cardNumber       VARCHAR(20),
expiresOn       VARCHAR(10),
cvvNumber       VARCHAR(10)
);


CREATE TABLE ORDERS
(
orderID         INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                        (START WITH 1, INCREMENT BY 1),
customerID      INTEGER,
orderTotal      DOUBLE,
orderDate       TIMESTAMP,
orderStatus     VARCHAR(10)
);

ALTER TABLE ORDERS ADD FOREIGN KEY (customerID) REFERENCES USERS (id);


CREATE TABLE PAYMENT
(
paymentID       INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                        (START WITH 1, INCREMENT BY 1),
userId Integer,
--paymentTime     TIMESTAMP,
--amount          DOUBLE,
--description     VARCHAR(40),
--paymentType     VARCHAR(10),--PayPal/CreditCard
cardNumber       VARCHAR(20),
expiresOn       VARCHAR(10),
cvvNumber       VARCHAR(10)
--paymentStatus   VARCHAR(10)
);

CREATE TABLE SHIPMENT
(
shipmentID      INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                        (START WITH 1, INCREMENT BY 1),
courier         VARCHAR(30),
trackingCode    VARCHAR(10),
shipmentAddress VARCHAR(100)
);


CREATE TABLE REVIEW
(
reviewID      INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                        (START WITH 1, INCREMENT BY 1),
customerID      INTEGER,
productID       INTEGER,
productRating INTEGER,
reviewText    VARCHAR(300)
);

ALTER TABLE REVIEW ADD FOREIGN KEY (customerID) REFERENCES USERS (id);
ALTER TABLE REVIEW ADD FOREIGN KEY (productID) REFERENCES PRODUCT (productID);


