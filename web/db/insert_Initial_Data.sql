
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  yoonkoo
 * Created: 30/05/2020
 */


/*
 ADD Customers
*/

INSERT INTO USERS(fName,lName,password,email,mobileNum,address,usertype,active)
    VALUES('Jane','Doe','BA99342bob','jane.doe@uts.edu.au','01234567','uts1','Customer',false)
,('Helen','Strokes','BA99342bob', 'helen.strokes@uts.edu.au','01234567','uts1','Customer',false)
,('Jim','Carry','BA99342bob','jim.carry@uts.edu.au','01234567','uts1','Customer',false)
,('Steve','Miller','BA99342bob','steve.miller@uts.edu.au','01234567','uts1','Customer',false)
,('John','Smith','BA99342bob','john.smith@uts.edu.au','01234567','uts1','Customer',false)
,('Yoon','Koo','BA99342bob','yoon.koo@uts.edu.au','01234567','uts1','Customer',false)
,('Jasper','Park','BA99342bob', 'jasper.park@uts.edu.au','01234567','uts1','Customer',false)
,('Alex','Wu','BA99342bob','alex.wu@uts.edu.au','01234567','uts1','Customer',false)
,('Aaron','Lee','BA99342bob','aaron.lee@uts.edu.au','01234567','uts1','Customer',false)
,('Hugh','Jeon','BA99342bob','hugh.jeon@uts.edu.au','01234567','uts1','Customer',false)
,('Sasha','Kurt','BA99342bob','jane.doe@uts.edu.au','01234567','uts1','Customer',false)
,('Rob','Aubry','BA99342bob', 'helen.strokes@uts.edu.au','01234567','uts1','Customer',false)
,('Jenna','Dora','BA99342bob','jim.carry@uts.edu.au','01234567','uts1','Customer',false)
,('Peter','Tempel','BA99342bob','steve.miller@uts.edu.au','01234567','uts1','Customer',false)
,('Bobby','Hallock','BA99342bob','john.smith@uts.edu.au','01234567','uts1','Customer',false)
,('Andy','Ruckman','BA99342bob','yoon.koo@uts.edu.au','01234567','uts1','Customer',false)
,('Chris','Dease','BA99342bob', 'jasper.park@uts.edu.au','01234567','uts1','Customer',false)
,('Chen','Zhu','BA99342bob','alex.wu@uts.edu.au','01234567','uts1','Customer',false)
,('Sammy','Packett','BA99342bob','aaron.lee@uts.edu.au','01234567','uts1','Customer',false)
,('Elizabeth','Owen','BA99342bob','hugh.jeon@uts.edu.au','01234567','uts1','Customer',false);
/*
 ADD Staffs
*/

INSERT INTO USERS(fName,lName,password,email,mobileNum,address,usertype,active)
    VALUES('Emily','Doe','BA99342bob','emily.doe@uts.edu.au','01234567','uts2','Staff',false)
,('Jeremy','Strokes','BA99342bob', 'jeremy.strokes@uts.edu.au','01234567','uts2','Staff',false)
,('Cameron','Carry','BA99342bob','cameron.carry@uts.edu.au','01234567','uts2','Staff',false)
,('Jeff','Miller','BA99342bob','jeff.miller@uts.edu.au','01234567','uts2','Staff',false)
,('Millie','Smith','BA99342bob','millie@uts.edu.au','01234567','uts2','Staff',false)
,('Sarah','Davine','BA99342bob','sarah.davine@uts.edu.au','01234567','uts2','Staff',false)
,('Lara','Johns','BA99342bob', 'lara.johns@uts.edu.au','01234567','uts2','Staff',false)
,('Marba','Rob','BA99342bob','marba.rob@uts.edu.au','01234567','uts2','Staff',false)
,('Josh','Carrot','BA99342bob','josh.carrot@uts.edu.au','01234567','uts2','Staff',false)
,('Kate','Haskins','BA99342bob','kate.haskins@uts.edu.au','01234567','uts2','Staff',false);

INSERT INTO CATEGORY
             (categoryName, description)
     VALUES
     ('Camera','Iot camera'),
     ('Light bulb', 'Iot smart light'),
     ('Voice Controller', 'Home voice Controller'),
     ('Home Security','Security IoT device'),
     ('Wi-Fi','Wi-Fi');

INSERT INTO PRODUCT
    (categoryID, productName, productPrice, description, status, quantity, productType)
     
     VALUES
     (1,'Wifi Camera',19.99,'Smart wireless camera with application control','In stock', 200, 'Camera'),
     (1,'Smart web cam',59.99,'Iot web camera for pc','In stock', 10, 'Camera'),
     (2,'Lux smart bulb',29.99,'Wifi connect light bulb','In stock', 30, 'Light bulb'),
     (2,'Bright smart bulb',39.99,'Wifi connect light bulb','In stock', 20,'Light bulb'),
    (3,'Google Home',43,'smart voice home controller','In stock',400,'Voice Controller'),
    (3,'Amazon Echo Plus Voice Controller',100,'smart home security device','In stock',130,'Voice Controller'),
    (4,'Nest Smart Door Bell',70,'smart home security device','In stock',89,'Home Security'),
    (4,'Amazon Smart Door Alarm',50,'smart voice home controller','In stock',400,'Home Security'),
    (5,'Particle Photon Wi-Fi with headers',60,'the particle IoT board','In stock',20,'Wi-Fi'),
    (5,'NetGear Home Mesh Wi-Fi System',350,'IoT device which maintains the whole home mesh Wi-Fi system','In stock',20,'Wi-Fi');
    
;


INSERT INTO ORDERLINE
(productID, customerID, orderQty, price)

    VALUES
    (1,1,20,11),
    (2,1,10,22),
    (3,1,30,33);
    


INSERT INTO CARD (userId,cardNumber,expiresOn,cvvNumber) VALUES
(1,'1000-3480-2347-0422','03/21','123'),
(2,'2434-2346-0239-1112','04/22','547'),
(3,'0434-1231-0846-7777','06/24','537'),
(4,'1984-6563-4848-4847','07/25','432'),
(5,'2984-0363-3946-4117','11/25','234'),
(6,'2343-4344-3842-0432','03/21','123'),
(7,'2544-9956-5439-0954','04/22','547'),
(8,'2342-9584-0456-5437','08/21','537'),
(9,'9876-6343-2348-4627','07/21','324'),
(10,'4554-4123-3456-4667','08/25','993'),
(11,'0999-3120-2117-6432','05/21','423'),
(12,'9894-1226-0993-1232','09/23','347'),
(13,'8755-2344-1221-9903','06/23','137'),
(14,'9532-2423-6466-9937','07/27','343'),
(15,'0032-0363-3946-4117','02/25','532'),
(16,'4325-3480-4347-0022','03/21','933'),
(17,'2644-2346-5339-1232','01/22','427'),
(18,'7894-1231-6446-6637','12/24','653'),
(19,'3462-6433-4438-4664','07/25','773'),
(20,'7556-0142-0396-4153','11/25','094'),




INSERT INTO LOGS(userId,timestamp,description)
    VALUES (1,'2020-02-01 12:03:23','Login'),
(2,'2018-02-17 10:23:43','Logout'),
(3,'2018-02-17 05:50:37','Logout'),
(4,'2019-12-30 20:28:59','Session Error'),
(5,'2020-04-22 00:00:37','Session Expired'),
(6,'2010-11-18 18:49:40','Login'),
(7,'2012-08-01 13:27:57','Logout'),
(8,'2020-06-19 23:43:20','Session Resumed'),
(9,'2020-03-12 10:27:36','Login'),
(10,'2019-10-25 16:10:32','Login'),
(11,'2019-03-05 10:33:03','Login'),
(12,'2019-03-05 15:33:03','Logout'),
(13,'2020-02-01 12:03:23','Login'),
(14,'2018-02-17 10:23:43','Logout'),
(15,'2018-02-17 05:50:37','Logout'),
(16,'2019-12-30 20:28:59','Session Error'),
(17,'2020-04-22 00:00:37','Session Expired'),
(18,'2010-11-18 18:49:40','Login'),
(19,'2012-08-01 13:27:57','Logout'),
(20,'2020-06-19 23:43:20','Session Resumed'),
(21,'2020-03-12 10:27:36','Login'),
(22,'2019-10-25 16:10:32','Login'),
(23,'2019-03-05 10:33:03','Login'),
(24,'2019-03-05 15:33:03','Logout');
