

INSERT INTO USERS(fName,lName,password,email,mobileNum,address,usertype,active)
    VALUES
 ('test','test', 'test1T','test@iotbay.com','012344567','test','Customer',false),
 ('Jane','Doe','BA99342bob','jane.doe@uts.edu.au','01234567','uts1','Customer',false)
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
             (categoryName, description)
     VALUES
     ('Camera','Iot camera'),
     ('Light bulb', 'Iot smart light');

INSERT INTO PRODUCT
    (categoryID, productName, productPrice, description, status, quantity, productType)
     
     VALUES
     (1,'Wifi Camera',19.99,'Smart wireless camera with application control','In stock', 200, 'Camera'),
     (1,'Smart web cam',59.99,'Iot web camera for pc','In stock', 10, 'Camera'),
     (2,'Lux smart bulb',29.99,'Wifi connect light bulb','In stock', 30, 'Light bulb'),
     (2,'Bright smart bulb',39.99,'Wifi connect light bulb','In stock', 20,'Light bulb')
;


INSERT INTO ORDERLINE
(productID, customerID, orderQty, price)

    VALUES
    (1,1,20,11),
    (2,1,10,22),
    (3,1,30,33)
;


INSERT INTO CARD (userId,cardNumber,expiresOn,cvvNumber) VALUES
(1,'1000-3480-2347-0422','03/21','123'),
(2,'2434-2346-0239-1112','04/22','547'),
(3,'0434-1231-0846-7777','06/24','537'),
(4,'1984-6563-4848-4847','07/25','324'),
(5,'2984-0363-3946-4117','08/25','234');



INSERT INTO LOGS(userId,timestamp,description)
    VALUES (1,'2020-02-01 12:03:23','Login'),
(1,'2018-02-17 10:23:43','Logout'),
(1,'2018-02-17 05:50:37','Logout'),
(1,'2019-12-30 20:28:59','Session Error'),
(1,'2020-04-22 00:00:37','Session Expired'),
(1,'2010-11-18 18:49:40','Login'),
(1,'2012-08-01 13:27:57','Logout'),
(7,'2020-06-19 23:43:20','Session Resumed'),
(8,'2020-03-12 10:27:36','Login'),
(9,'2019-10-25 16:10:32','Login'),
(14,'2019-03-05 10:33:03','Login'),
(14,'2019-03-05 15:33:03','Logout');
