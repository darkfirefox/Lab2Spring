CREATE TABLE Doctor (
                id SERIAL PRIMARY KEY,
                firstName VARCHAR NOT NULL,
                fatherName VARCHAR NOT NULL,
                lastName VARCHAR NOT NULL,
                specification VARCHAR NOT NULL);

CREATE TABLE Patient (
                id SERIAL PRIMARY KEY,
                firstName VARCHAR NOT NULL,
                fatherName VARCHAR NOT NULL,
                lastName VARCHAR NOT NULL,
                phone VARCHAR NOT NULL);

CREATE TABLE Prescription (
                id SERIAL PRIMARY KEY,
                dateTime timestamp NOT NULL,
                description VARCHAR NOT NULL,
                priority VARCHAR NOT NULL,
                idDoctor INTEGER REFERENCES Doctor(id) ON DELETE CASCADE,
		        idPatient INTEGER REFERENCES Patient(id) ON DELETE CASCADE);

CREATE TABLE Log (
                     id SERIAL PRIMARY KEY,
                     className VARCHAR  NOT NULL,
                     typeChange VARCHAR  NOT NULL,
                     value VARCHAR NOT NULL);

CREATE  TABLE Notification (
                id SERIAL PRIMARY  KEY,
                email VARCHAR  NOT NULL,
                condition VARCHAR NOT NULL);
INSERT INTO Notification VALUES (1, 'testTo@yahoo.com', 'DoctorEntity');