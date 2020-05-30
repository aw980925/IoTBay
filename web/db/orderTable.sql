/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Hyungju
 * Created: 31/05/2020
 */

CREATE TABLE ORDER
(
orderID Int(10),
orderDate Date(8),
orderStatus VARCHAR(10),
PRIMARY KEY (orderID),
FOREIGN KEY (customerID),
);