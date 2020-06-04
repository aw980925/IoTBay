DROP TABLE USERS;
DROP TABLE LOGHISTORY;
DROP TABLE PRODUCT;
DROP TABLE CATEGORY;
DROP TABLE BASKET;
DROP TABLE ORDERS;
DROP TABLE ORDERLINE;
DROP TABLE PAMENT;
DROP TABLE PAYMENT;
DROP TABLE SHIPMENT;


CREATE TABLE USERS (
"id"            INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                    (START WITH 1, INCREMENT BY 1) ON DELETE CASCADE, 
"fName"         VARCHAR(10),
"lName"         VARCHAR(10),
"password"      VARCHAR(20),
"email"         VARCHAR(50) NOT NULL,
"mobileNum"     VARCHAR(20),
"address"       VARCHAR(50),
"usertype"      VARCHAR(10),
"active"        BOOLEAN
);

CREATE TABLE LOGHISTORY
(
"id"            INTEGER NOT NULL PRIMARY KEY,
"SignInDate"    DATE,
"startTime"     TIME,
"endTime"       TIME,
"duration"      TIME
);

CREATE TABLE PRODUCT
(
"productID"     INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                    (START WITH 1, INCREMENT BY 1), 
"categoryID"    INTEGER REFERENCES CATEGORY (categoryID);
"productName"   VARCHAR(20),
"productPrice"  Double(7),
"description"   VARCHAR(300),
"status"        VARCHAR(1),
"quantity"      INTEGER(5),
/* FOREIGN KEY (supplierID), */
FOREIGN KEY (categoryID) REFERENCES CATEGORY (categoryID)
);

CREATE TABLE CATEGORY
(
"categoryID"    INTEGER NOT NULL PRIMARY KEY,
"categoryName"  VARCHAR(10),
"description"   VARCHAR(100)
);

CREATE TABLE BASKET 
(
"basketID"      INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                        (START WITH 1, INCREMENT BY 1),
"totalProductQty" INTEGER(100),
"totalAmount"     INTEGER(8),
"selectedProducts"INTEGER(100),
FOREIGN KEY (customerID) REFERENCES USERS (id),
FOREIGN KEY (productID) REFERENCES PRODUCT (productID)
);

CREATE TABLE ORDERS
(
"orderID"       INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                        (START WITH 1, INCREMENT BY 1),
"orderDate"     DATE(8),
"orderStatus"   VARCHAR(10),
FOREIGN KEY (customerID) REFERENCES USERS (id)
);

CREATE TABLE ORDERLINE
(
"orderID"       INTEGER REFERENCES ORDERS (orderID),
"productID"     INTEGER REFERENCES PRODUCT (productID),
"paymentID"     INTEGER REFERENCES PAYMENT (paymentID),
"shipmentID"    INTEGER REFERENCES SHIPMENT (shipmentID),    
"productQty"    INTEGER(100),
"total"         INTEGER(100),
"shipmentDate"  TIMESTAMP,
PRIMARY KEY (orderID, productID, paymentID, shipmentID)
);

CREATE TABLE PAYMENT
(
"paymentID"     INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                        (START WITH 1, INCREMENT BY 1),
"paymentTime"   TIMESTAMP,
"amount"        DOUBLE,
"description"   VARCHAR(30),
"paymentType"   VARCHAR(10),
"paymentStatus" VARCHAR(10),
);

CREATE TABLE REVIEW
(
"reviewID"      INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                        (START WITH 1, INCREMENT BY 1),
"productRating" INTEGER(5),
"reviewText"    VARCHAR(300),
FOREIGN KEY (customerID) REFERENCES USERS (id),
FOREIGN KEY (productID) REFERENCES PRODUCT (productID)
);

CREATE TABLE SHIPMENT
(
"shipmentID"      INTEGER NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                        (START WITH 1, INCREMENT BY 1),
"courier"         VARCHAR(30),
"trackingCode"    VARCHAR(10),
"shipmentAddress" VARCHAR(100)
);