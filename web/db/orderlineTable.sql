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
productQty Int(100),
total Int(100),
shipmentDate Timestamp(8),
FOREIGN KEY (orderID),
FOREIGN KEY (productID),
FOREIGN KEY (paymentID),
FOREIGN KEY (shipmentID)
);