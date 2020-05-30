/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Hyungju
 * Created: 31/05/2020
 */

CREATE TABLE PAYMENT
(
paymentID VARCHAR(12),
paymentDateTime VARCHAR(12),
amount VARCHAR(8),
description VARCHAR(30),
paymentType VARCHAR(10),
paymentStatus VARCHAR(10),
PRIMARY KEY (paymentID)
);