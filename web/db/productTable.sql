/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Hyungju
 * Created: 31/05/2020
 */

CREATE TABLE PRODUCT
(
productID VARCHAR(8),
productName VARCHAR(20),
productPrice VARCHAR(7),
productDescription VARCHAR(300),
productStatus VARCHAR(1),
productQuantity VARCHAR(5),
PRIMARY KEY (productID),
FOREIGN KEY (supplierID),
FOREIGN KEY (categoryID)
);