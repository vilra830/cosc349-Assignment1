CREATE TABLE bookings (
	bookingNumber VARCHAR(7) ,
	checkin DATE,
	checkout DATE,
	guestName VARCHAR (50) NOT NULL,
	PRIMARY KEY (bookingNumber,checkin,checkout)
	);

CREATE TABLE campsites (
    campNumber VARCHAR (3),
    siteType   VARCHAR (30),
    description VARCHAR (100),
    pricePerNight VARCHAR (100),
    PRIMARY KEY(campNumber)
    );

INSERT INTO campsites VALUES('501' ,'Tent' , 'Sleeps 2' , '$45.00');
INSERT INTO campsites VALUES('102' ,'Tent' , 'Sleeps 3' , '$60.00');
INSERT INTO campsites VALUES('103' ,'Cabin' , 'Sleeps 5' , '$150.00');
INSERT INTO campsites VALUES('104' ,'Cabin' , 'Sleeps 8' , '$200.00');
INSERT INTO campsites VALUES('105' ,'RV' , 'Sleeps 3' , '$100.00');
INSERT INTO campsites VALUES('107' ,'RV' , 'Sleeps 5' , '$210.00');







