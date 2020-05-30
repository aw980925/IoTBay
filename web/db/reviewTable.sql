/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Hyungju
 * Created: 31/05/2020
 */

CREATE TABLE REVIEW
(
reviewID VARCHAR(12),
productRating VARCHAR(5),
reviewTaext VARCHAR(300),
PRIMARY KEY (reivewID),
FOREIGN KEY (customerID),
FOREIGN KEY (productID)
);