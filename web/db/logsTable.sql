/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  yoonkoo
 * Created: 03/06/2020
 */


CREATE TABLE LOGS (
logId INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 100, INCREMENT BY 1), 
userId INT,
timestamp Timestamp,
description VARCHAR(50)
);
