

CREATE TABLE USERS (
id INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
fName VARCHAR(10),
lName VARCHAR(10),
password VARCHAR(20),
email VARCHAR(50) NOT NULL,
mobileNum VARCHAR(20),
address VARCHAR(50),
usertype VARCHAR(10),
active boolean
);
