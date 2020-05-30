/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Hyungju
 * Created: 31/05/2020
 */

CREATE TABLE ORDERLINE
(
productQty VARCHAR(100),
total VARCHAR(100),
shipmentDate VARCHAR(8),
FOREIGN KEY (orderID),
FOREIGN KEY (productID),
FOREIGN KEY (paymentID),
FOREIGN KEY (shipmentID)
);