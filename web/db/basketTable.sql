/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Hyungju
 * Created: 31/05/2020
 */

CREATE TABLE BASKET 
(
basketID Int(2),
totalProductQty Int(100),
totalAmount Int(8),
selectedProducts Int(100),
PRIMARY KEY (basketID),
FOREIGN KEY (customerID),
FOREIGN KEY (productID)
);