/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Hyungju
 * Created: 31/05/2020
 */

CREATE TABLE SHIPMENT
(
shipmentID Int(10),
shipmentCourier VARCHAR(30),
trackingCode VARCHAR(10),
shipmentAddress VARCHAR(100),
PRIMARY KEY (shipmentID)
);