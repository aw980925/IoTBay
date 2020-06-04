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

CREATE TABLE LOGHISTORY
(
id              INTEGER NOT NULL PRIMARY KEY 
                    GENERATED ALWAYS AS IDENTITY
                    (START WITH 1, INCREMENT BY 1), 
SignInDate      TIMESTAMP,
startTime       TIMESTAMP,
endTime         TIMESTAMP,
duration        TIMESTAMP
);

CREATE TABLE CATEGORY
(
categoryID      INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, 
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
quantity        INTEGER
);

ALTER TABLE PRODUCT ADD FOREIGN KEY (categoryID) REFERENCES CATEGORY (categoryID);


CREATE TABLE BASKET 
(
basketID        INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                        (START WITH 1, INCREMENT BY 1),
customerID      INTEGER,
productID       INTEGER,
totalProductQty INTEGER,
totalAmount     INTEGER,
selectedProducts INTEGER
);

ALTER TABLE BASKET ADD FOREIGN KEY (customerID) REFERENCES USERS (id);
ALTER TABLE BASKET ADD FOREIGN KEY (productID) REFERENCES PRODUCT (productID);

CREATE TABLE ORDERS
(
orderID         INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                        (START WITH 1, INCREMENT BY 1),
customerID      INTEGER,
orderDate       TIMESTAMP,
orderStatus     VARCHAR(10)
);

ALTER TABLE ORDERS ADD FOREIGN KEY (customerID) REFERENCES USERS (id);


CREATE TABLE PAYMENT
(
paymentID       INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                        (START WITH 1, INCREMENT BY 1),
paymentTime     TIMESTAMP,
amount          DOUBLE,
description     VARCHAR(30),
paymentType     VARCHAR(10),
paymentStatus   VARCHAR(10)
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

CREATE TABLE ORDERLINE
(
orderID         INTEGER REFERENCES ORDERS (orderID),
productID       INTEGER REFERENCES PRODUCT (productID),
paymentID       INTEGER REFERENCES PAYMENT (paymentID),
shipmentID      INTEGER REFERENCES SHIPMENT (shipmentID),    
productQty      INTEGER,
total           INTEGER,
shipmentDate    TIMESTAMP,
PRIMARY KEY (orderID, productID, paymentID, shipmentID)
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


