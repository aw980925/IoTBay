

INSERT INTO USERS(fName,lName,password,email,mobileNum,address,usertype,active)
    VALUES('Jane','Doe','BA99342bob','jane.doe@uts.edu.au','01234567','uts1','Customer',false)
,('Helen','Strokes','BA99342bob', 'helen.strokes@uts.edu.au','01234567','uts1','Customer',false)
,('Jim','Carry','BA99342bob','jim.carry@uts.edu.au','01234567','uts1','Customer',false)
,('Steve','Miller','BA99342bob','steve.miller@uts.edu.au','01234567','uts1','Customer',false)
,('John','Smith','BA99342bob','john.smith@uts.edu.au','01234567','uts1','Customer',false);
/*
 ADD Staffs
*/

INSERT INTO USERS(fName,lName,password,email,mobileNum,address,usertype,active)
    VALUES('Emily','Doe','BA99342bob','emily.doe@uts.edu.au','01234567','uts2','Staff',false)
,('Jeremy','Strokes','BA99342bob', 'jeremy.strokes@uts.edu.au','01234567','uts2','Staff',false)
,('Cameron','Carry','BA99342bob','cameron.carry@uts.edu.au','01234567','uts2','Staff',false)
,('Jeff','Miller','BA99342bob','jeff.miller@uts.edu.au','01234567','uts2','Staff',false)
,('Millie','Smith','BA99342bob','millie.smith@uts.edu.au','01234567','uts2','Staff',false);


INSERT INTO CATEGORY
             (categoryID, categoryName, description)
     VALUES
     (1,'Camera','Iot camera'),
     (2,'Light bulb', 'Iot smart light');

INSERT INTO PRODUCT
    (categoryID, productName, productPrice, description, status, quantity)
     
     VALUES
     (1,'Wifi Camera',19.99,'Smart wireless camera with application control','In stock', 200),
     (1,'Smart web cam',59.99,'Iot web camera for pc','In stock', 10),
     (2,'Lux smart bulb',29.99,'Wifi connect light bulb','In stock', 30),
     (2,'Bright smart bulb',39.99,'Wifi connect light bulb','In stock', 20)
;

/* INSERT INTO SHIPMENT 
    (shipmentID, shipmentCourier, trackingCode, shipmentAddress)

    VALUES
    ('12345671','Toll express','1000000111',,'Toll1'),
    ('12345672','Startrack','111111111',,'Startrack')
; */


INSERT INTO BASKET 
(basketID, customerID, productID, qty)

    VALUES
    ('01','10000001','10000001','1'),
    ('01','10000001','10000002','2'),
    ('01','10000001','10000003','1')
;