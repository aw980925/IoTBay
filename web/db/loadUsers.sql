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