-- DROP DATABASE IF EXISTS `sample_305`;
-- 
-- CREATE DATABASE `sample_305`;
-- 
-- USE `sample_305`;

CREATE TABLE Airline (
Id CHAR(2),
Name VARCHAR(100) NOT NULL,
PRIMARY KEY (Id));

CREATE TABLE AdvPurchaseDiscount (
AirlineID CHAR(2),
Days INTEGER NOT NULL,
DiscountRate NUMERIC(10,2) NOT NULL,
PRIMARY KEY (AirlineID, Days),
FOREIGN KEY (AirlineID) REFERENCES Airline(Id)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
CHECK (Days > 0),
CHECK (DiscountRate > 0 AND DiscountRate < 100));

CREATE TABLE Flight (
AirlineID CHAR(2), 
FlightNo INTEGER NOT NULL,
NoOfSeats INTEGER NOT NULL,
DaysOperating CHAR(7) NOT NULL,
MinLengthOfStay INTEGER NOT NULL,
MaxLengthOfStay INTEGER NOT NULL,
PRIMARY KEY (AirlineID, FlightNo),
FOREIGN KEY (AirlineID) REFERENCES Airline(Id)
	ON DELETE NO ACTION
    ON UPDATE CASCADE,
CHECK (NoOfSeats > 0),
CHECK (MinLengthOfStay >= 0),
CHECK (MaxLengthOfStay > MinLengthOfStay));

CREATE TABLE Airport (
Id CHAR(3),
Name VARCHAR(100) NOT NULL,
City VARCHAR(50) NOT NULL,
Country VARCHAR(50) NOT NULL,
PRIMARY KEY (Id));

CREATE TABLE Leg (
AirlineID CHAR(2),
FlightNo INTEGER NOT NULL,
LegNo INTEGER NOT NULL,
DepAirportID CHAR(3) NOT NULL,
ArrAirportID CHAR(3) NOT NULL,
ArrTime DATETIME NOT NULL,
DepTime DATETIME NOT NULL,
PRIMARY KEY (AirlineID, FlightNo, LegNo),
UNIQUE(AirlineID, FlightNo, DepAirportID),
FOREIGN KEY (AirlineID, FlightNo) REFERENCES Flight(AirlineID, FlightNo)
	ON DELETE NO ACTION
    ON UPDATE CASCADE,
FOREIGN KEY (DepAirportID) REFERENCES Airport(Id)
	ON DELETE NO ACTION
    ON UPDATE CASCADE,
FOREIGN KEY (ArrAirportID) REFERENCES Airport(Id)
	ON DELETE NO ACTION
    ON UPDATE CASCADE,
CHECK (LegNo > 0));

CREATE TABLE Fare (
AirlineID CHAR(2) NOT NULL,
FlightNo INTEGER NOT NULL,
FareType VARCHAR(20) NOT NULL,
Class VARCHAR(20) NOT NULL,
Fare NUMERIC(10,2) NOT NULL, 
IsFlexible BOOLEAN DEFAULT 0,
IsDomestic BOOLEAN DEFAULT 0,
PRIMARY KEY (AirlineID, FlightNo, FareType, Class, isFlexible, IsDomestic),
FOREIGN KEY (AirlineID, FlightNo) REFERENCES Flight(AirlineID, FlightNo)
	ON DELETE NO ACTION
    ON UPDATE CASCADE,
CHECK (Fare > 0));

CREATE TABLE Person (
Id INTEGER,
FirstName VARCHAR(50) NOT NULL,
LastName VARCHAR(50) NOT NULL,
Address VARCHAR(100) NOT NULL,
City VARCHAR(50) NOT NULL,
State VARCHAR(50) NOT NULL,
ZipCode INTEGER NOT NULL,
Telephone VARCHAR(20),
Email VARCHAR(50),
PRIMARY KEY (Id),
CHECK (Id > 0),
CHECK (ZipCode > 0));

CREATE TABLE Customer (
Id INTEGER NOT NULL,
AccountNo INTEGER,
CreditCardNo CHAR(16),
CreationDate DateTime NOT NULL,
Rating INTEGER,
PRIMARY KEY (AccountNo),
FOREIGN KEY (Id) REFERENCES Person (Id)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
CHECK (Rating >= 0 AND Rating <= 10));

CREATE TABLE CustomerPreferences(
AccountNo INTEGER NOT NULL,
Preference VARCHAR(50) NOT NULL,
PRIMARY KEY (AccountNo, Preference),
FOREIGN KEY(AccountNo) REFERENCES Customer (AccountNo)
	ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE Employee (
Id INTEGER NOT NULL,
SSN INTEGER,
IsManager BOOLEAN NOT NULL,
StartDate DATE NOT NULL,
HourlyRate NUMERIC(10,2) NOT NULL,
PRIMARY KEY (SSN),
FOREIGN KEY (Id) REFERENCES Person (Id)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
UNIQUE (Id),
CHECK (SSN > 0),
CHECK (HourlyRate > 0));

CREATE TABLE Passenger (
Id INTEGER,
AccountNo INTEGER,
PRIMARY KEY (Id, AccountNo),
FOREIGN KEY (Id) REFERENCES Person(Id)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
FOREIGN KEY (AccountNo) REFERENCES Customer(AccountNo)
	ON DELETE NO ACTION
    ON UPDATE CASCADE);

CREATE TABLE Reservation (
ResrNo INTEGER,
ResrDate DATETIME NOT NULL,
BookingFee NUMERIC(10,2) NOT NULL,
TotalFare NUMERIC(10,2) NOT NULL,
RepSSN INTEGER,
AccountNo INTEGER NOT NULL,
PRIMARY KEY (ResrNo),
FOREIGN KEY (RepSSN) REFERENCES Employee (SSN)
	ON DELETE NO ACTION
    ON UPDATE CASCADE,
FOREIGN KEY (AccountNo) REFERENCES Customer (AccountNo)
	ON DELETE NO ACTION
    ON UPDATE CASCADE,
CHECK (ResrNo > 0),
CHECK (BookingFee >= 0),
CHECK (TotalFare > BookingFee));

CREATE TABLE Includes (
ResrNo INTEGER,
AirlineID CHAR(2),
FlightNo INTEGER,
LegNo INTEGER,
Date DATETIME NOT NULL,
PRIMARY KEY (ResrNo, AirlineID, FlightNo, LegNo),
FOREIGN KEY (ResrNo) REFERENCES Reservation (ResrNo)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
FOREIGN KEY (AirlineID, FlightNo, LegNo) REFERENCES Leg(AirlineID, FlightNo, LegNo)
	ON DELETE NO ACTION
    ON UPDATE CASCADE);

CREATE TABLE ReservationPassenger (
ResrNo INTEGER,
Id INTEGER,
AccountNo INTEGER,
SeatNo CHAR(5) NOT NULL,
Class VARCHAR(20) NOT NULL,
Meal VARCHAR(50),
PRIMARY KEY (ResrNo, Id, AccountNo),
FOREIGN KEY (ResrNo) REFERENCES Reservation (ResrNo)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
FOREIGN KEY (Id, AccountNo) REFERENCES Passenger (Id, AccountNo)
	ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE Auction (
AccountNo INTEGER,
AirlineID CHAR(2),
FlightNo INTEGER,
Class VARCHAR(20),
Date DATETIME,
NYOP NUMERIC(10,2) NOT NULL, -- Name Your Own Price
Accepted BOOLEAN NOT NULL,
PRIMARY KEY (AccountNo, AirlineID, FlightNo, Class, Date),
FOREIGN KEY (AccountNo) REFERENCES Customer(AccountNo)
	ON DELETE NO ACTION
    ON UPDATE CASCADE,
FOREIGN KEY (AirlineID, FlightNo) REFERENCES Flight(AirlineID, FlightNo)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
CHECK (NYOP > 0));

-- Check When Insert
delimiter |

DROP TRIGGER IF EXISTS adv_check |
CREATE TRIGGER adv_check BEFORE INSERT ON AdvPurchaseDiscount
  FOR EACH ROW
  BEGIN
    IF NEW.Days <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Number of Days below or equal to 0';
    END IF;
    IF NEW.DiscountRate <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Discount Rate below or equal to 0';
    ELSEIF NEW.DiscountRate >= 100 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Discount Rate above or equal to 100';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS flight_check |
CREATE TRIGGER flight_check BEFORE INSERT ON Flight
  FOR EACH ROW
  BEGIN
    IF NEW.NoOfSeats < 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Number of Seats below 0';
    END IF;
    IF NEW.MinLengthOfStay < 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Minium length of Stay below 0';
    END IF;
    IF NEW.MaxLengthOfStay <= NEW.MinLengthOfStay THEN
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Max length of Stay should be bigger than A Min length of Stay';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS leg_check |
CREATE TRIGGER leg_check BEFORE INSERT ON Leg
  FOR EACH ROW
  BEGIN
    IF NEW.LegNo <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The Leg Number below or equal to 0';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS fair_check |
CREATE TRIGGER fair_check BEFORE INSERT ON Fare
  FOR EACH ROW
  BEGIN
    IF NEW.Fare <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Cost of Fare below or equal to 0';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS person_check |
CREATE TRIGGER person_check BEFORE INSERT ON Person
  FOR EACH ROW
  BEGIN
    IF NEW.Id <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'An Id below or equal to 0';
    END IF;
    IF NEW.Zipcode <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Zipcode below or equal to 0';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS customer_check |
CREATE TRIGGER customer_check BEFORE INSERT ON Customer
  FOR EACH ROW
  BEGIN
    IF NEW.Rating < 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Rating below 0';
    ELSEIF NEW.Rating > 10 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Rating above 10';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS employee_check |
CREATE TRIGGER employee_check BEFORE INSERT ON Employee
  FOR EACH ROW
  BEGIN
    IF NEW.SSN <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A SSN below or equal to 0';
    END IF;
	IF NEW.HourlyRate <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Hourly Rate below or equal to 0';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS reservation_check |
CREATE TRIGGER reservation_check BEFORE INSERT ON Reservation
  FOR EACH ROW
  BEGIN
    IF NEW.ResrNo <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Reservation Number below or equal to 0';
    END IF;
	IF NEW.BookingFee < 0.00 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Booking Fee below 0';
    END IF;
	IF NEW.TotalFare <= NEW.BookingFee THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Total Fare below or equal to Booking Fee';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS auction_check |
CREATE TRIGGER auction_check BEFORE INSERT ON Auction
  FOR EACH ROW
  BEGIN
    IF NEW.NYOP <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A ßNYOP below or equal to 0';
    END IF;
  END;
|
-- Check when Update
DROP TRIGGER IF EXISTS adv_check_update |
CREATE TRIGGER adv_check_update BEFORE UPDATE ON AdvPurchaseDiscount
  FOR EACH ROW
  BEGIN
    IF NEW.Days <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Number of Days below or equal to 0';
    END IF;
    IF NEW.DiscountRate <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Discount Rate below or equal to 0';
    ELSEIF NEW.DiscountRate >= 100 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Discount Rate above or equal to 100';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS flight_check_update |
CREATE TRIGGER flight_check_update BEFORE UPDATE ON Flight
  FOR EACH ROW
  BEGIN
    IF NEW.NoOfSeats < 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Number of Seats below 0';
    END IF;
    IF NEW.MinLengthOfStay < 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Minium length of Stay below 0';
    END IF;
    IF NEW.MaxLengthOfStay <= NEW.MinLengthOfStay THEN
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Max length of Stay should be bigger than A Min length of Stay';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS leg_check_update |
CREATE TRIGGER leg_check_update BEFORE UPDATE ON Leg
  FOR EACH ROW
  BEGIN
    IF NEW.LegNo <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The Leg Number below or equal to 0';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS fair_check_update |
CREATE TRIGGER fair_check_update BEFORE UPDATE ON Fare
  FOR EACH ROW
  BEGIN
    IF NEW.Fare <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Cost of Fare below or equal to 0';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS person_check_update |
CREATE TRIGGER person_check_update BEFORE UPDATE ON Person
  FOR EACH ROW
  BEGIN
    IF NEW.Id <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'An Id below or equal to 0';
    END IF;
    IF NEW.Zipcode <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Zipcode below or equal to 0';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS customer_check_update |
CREATE TRIGGER customer_check_update BEFORE UPDATE ON Customer
  FOR EACH ROW
  BEGIN
    IF NEW.Rating < 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Rating below 0';
    ELSEIF NEW.Rating > 10 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Rating above 10';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS employee_check_update |
CREATE TRIGGER employee_check_update BEFORE UPDATE ON Employee
  FOR EACH ROW
  BEGIN
    IF NEW.SSN <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A SSN below or equal to 0';
    END IF;
	IF NEW.HourlyRate <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Hourly Rate below or equal to 0';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS reservation_check_update |
CREATE TRIGGER reservation_check_update BEFORE UPDATE ON Reservation
  FOR EACH ROW
  BEGIN
    IF NEW.ResrNo <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Reservation Number below or equal to 0';
    END IF;
	IF NEW.BookingFee < 0.00 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Booking Fee below 0';
    END IF;
	IF NEW.TotalFare <= NEW.BookingFee THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A Total Fare below or equal to Booking Fee';
    END IF;
  END;
|
DROP TRIGGER IF EXISTS auction_check_update |
CREATE TRIGGER auction_check_update BEFORE UPDATE ON Auction
  FOR EACH ROW
  BEGIN
    IF NEW.NYOP <= 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'A ßNYOP below or equal to 0';
    END IF;
  END;
|

delimiter ;

-- Insert Data
INSERT INTO Airline (Id, Name) 
VALUES 
('AA', 'American Airlines'),
('AB', 'Air Berlin'),
('AJ', 'Air Japan'),
('AM', 'Air Madagascar'),
('BA', 'British Airways'),
('DA', 'Delta Airlines'),
('JA', 'JetBlue Airways'),
('LU', 'Lufthansa'),
('SA', 'Southwest Airlines'),
('UA', 'United Airlines');

INSERT INTO Airport (Id, Name, City, Country) 
VALUES 
('TXL', 'Berlin Tegel', 'Berlin', 'Germany'),
('ORD', 'Chicago O\'Hare International',	'Chicago', 'Illinois'),
('ATL', 'Hartsfield-Jackson Atlanta Int', 'Atlanta', 'United States of America'),
('TNR', 'Ivato International', 'Antananarivo', 'Madagascar'),
('JFK', 'John F. Kennedy International', 'New York', 'United States of America'),
('LGA', 'LaGuardia',	'New York',	'United States of America'),
('BOS', 'Logan International',	'Boston', 'United States of America'),
('LHR', 'London Heathrow', 'London', 'United Kingdom'),
('LAX', 'Los Angeles International', 'Los Angeles', 'United States of America'),
('SFO', 'San Francisco International',	'San Francisco', 'United States of America'),
('HND', 'Tokyo International', 'Tokyo', 'Japan');

INSERT INTO Flight (FlightNo, DaysOperating,	NoOfSeats, AirlineID, MinLengthOfStay, MaxLengthOfStay) 
VALUES
('111', '1010100', '100', 'AA', '1', '2'),
('111', '1111111', '150', 'JA', '0', '1'),
('1337', '0000011', '33', 'AM', '0', '5');

INSERT INTO Leg (LegNo, ArrTime, ArrAirportID, DepTime, DepAirportID, FlightNo, AirlineID) 
VALUES
('1', '2011-01-05 09:00:00', 'LGA', '2011-01-05 11:00:00', 'LAX', '111', 'AA'),
('2', '2011-01-05 17:00:00', 'LAX', '2011-01-05 19:00:00', 'HND', '111', 'AA'),
('3', '2011-01-06 07:30:00', 'HND', '2011-01-06 10:00:00', 'LGA', '111',	'AA'),
('1', '2011-01-10 12:00:00', 'SFO', '2011-01-10 14:00:00', 'BOS', '111',	'JA'),
('2', '2011-01-10 19:30:00', 'BOS', '2011-01-10 22:30:00', 'LHR', '111', 'JA'),
('3', '2011-01-11 05:00:00', 'LHR', '2011-01-11 08:00:00', 'SFO', '111', 'JA'),
('1', '2011-01-13 05:00:00', 'JFK', '2011-01-13 07:00:00', 'TNR', '1337', 'AM'),
('2', '2011-01-13 23:00:00', 'TNR', '2011-01-14 03:00:00', 'JFK', '1337', 'AM');

INSERT INTO Person (Id, FirstName, LastName, Address, City, State, ZipCode, Telephone, Email) 
VALUES
('1', 'Jane', 'Smith', '100 Nicolls Rd', 'Stony Brook', 'New York', '17790', '555-555-5555', 'awesomejane@ftw.com'),
('2', 'John', 'Doe', '123 N Fake Street', 'New York', 'New York', '10001', '123-123-1234', 'jdoe@woot.com'),
('3', 'Rick', 'Astley', '1337 Internet Lane', 'Los Angeles', 'California', '90001', '314-159-2653', 'rickroller@rolld.com');

INSERT INTO Customer (Id, AccountNo, CreationDate) -- They created account all by themselves.
VALUES
('1', '1', '2011-01-04 08:00:00'),
('2', '2', '2011-01-04 09:00:00'),
('3', '3', '2011-01-04 10:00:00');

INSERT INTO Passenger (Id, AccountNo) -- They bought tickets all by themselves.
VALUE
('1', '1'),
('2', '2'),
('3', '3');

INSERT INTO Reservation (ResrNo, ResrDate, BookingFee, TotalFare, AccountNo) -- They created their accounts on the same day they reserved
VALUES
('111', '2011-01-04 09:00:00', '120.00', '1200.00', '1'),
('222', '2011-01-04 10:00:00', '50.00', '500.00', '2'),
('333', '2011-01-04 11:00:00', '33.33', '3333.33', '3');

INSERT INTO ReservationPassenger (ResrNo, SeatNo, Meal, Class, Id, AccountNo) 
VALUES
('111', '33F', 'Chips', 'Economy', '1', '1'),
('222', '13A', 'Fish and Chips', 'First', '2', '2'),
('333', '1A', 'Sushi', 'First', '3', '3');

INSERT INTO Includes (Date, LegNo, ResrNo, FlightNo, AirlineID) 
VALUES
('2011-01-05 11:00:00', '1', '111', '111', 'AA'),
('2011-01-05 19:00:00', '2', '111', '111', 'AA'),
('2011-01-14 03:00:00', '1', '222', '111', 'JA'),
('2011-01-13 07:00:00', '1', '333', '1337', 'AM');

INSERT INTO Auction (AccountNo, AirlineID, FlightNo, Class, Date, NYOP, Accepted) 
VALUES
('1', 'AA', '111', 'Economy', '2011-01-04 08:30:00', '400', '1'); -- TODO: Procedure for checking if bid is accepted, by comparing 'NYOP with Fare' when Insert

-- Create View
CREATE VIEW EmplData AS -- For manager to view employees
	SELECT
		E.SSN, CONCAT(P.LastName, ' ', P.FirstName) AS Name, CONCAT(P.Address, ' ', P.City, ' ', P.State, ' ', P.ZipCode) AS Address, 
        P.Telephone, P.Email, E.IsManager, E.StartDate, E.HourlyRate
	FROM
		Person P, Employee E
	WHERE
		P.Id = E.Id
	ORDER BY P.LastName;

CREATE VIEW SalesReport AS -- For manager to view sales report
	SELECT
		Month(ResrDate) AS Month, SUM(TotalFare) AS Revenue
	FROM
		Reservation
	Group By Month(ResrDate);

CREATE VIEW FlightListAll AS -- For manager to view a comprehensive listing of all flights
	SELECT 
		AirlineID, FlightNo, NoOfSeats, DaysOperating, MinLengthOfStay, MaxLengthOfStay
	FROM
		Flight;

CREATE VIEW ResrFlightList AS -- For manager to view reservations by flight number
	SELECT
		I.AirlineID, I.FlightNo, R.ResrNo
	FROM
		Includes I, Reservation R
	WHERE
		I.ResrNo = R.ResrNo
UNION
	SELECT
		I.AirlineID, I.FlightNo, R.ResrNo
	FROM 
		Includes I, Reservation R
	WHERE
		I.ResrNo = R.ResrNo;

CREATE VIEW ResrCustList AS -- For manager to view reservations by customer name
	SELECT
		CONCAT(P.LastName, ', ', P.FirstName) AS Name, R.AccountNo, I.ResrNo
	FROM
		Includes I, Customer C, Reservation R, Person P
	WHERE
		(I.ResrNo = R.ResrNo) AND (R.AccountNo = C.AccountNo) AND (P.Id = C.Id)
	ORDER BY P.LastName;

CREATE VIEW TempIncludes AS -- For RevnCity
	SELECT 
		I.ResrNo, I.AirlineID, I.FlightNo, I.LegNo, I.Date
    FROM 
		Includes I
    LEFT OUTER JOIN Includes I2
		ON I.ResrNo = I2.ResrNo AND I.AirlineID = I2.AirlineID AND I.FlightNo = I2.FlightNo AND I.LegNo < I2.LegNo
	WHERE I2.ResrNo IS NULL AND I2.AirlineID IS NULL AND I2.FlightNo IS NULL;

CREATE VIEW RevnFlight AS -- For manager to view revenue by a flight
	SELECT
		I.AirlineID, I.FlightNo, SUM(R.TotalFare) AS Revenue
	FROM
		Includes I, Reservation R
	WHERE
		I.ResrNo = R.ResrNo 
	GROUP BY
		I.AirlineID, I.FlightNo;

CREATE VIEW RevnCity AS -- For manager to view revenue by a destination city
	SELECT
		A.City, SUM(R.TotalFare) AS Revenue
	FROM
		TempIncludes I, Reservation R, Leg L, Airport A
	WHERE
		(I.LegNo = L.LegNo) AND (L.ArrAirportID = A.Id) AND (I.FlightNo = L.FlightNo) AND (I.AirlineID = L.AirlineID) AND (I.ResrNo = R.ResrNo)
	GROUP BY
		L.ArrAirportID;
 
CREATE VIEW RevnCust AS -- For manager to view revenue by a Customer
	SELECT
		CONCAT(P.LastName, ', ', P.FirstName) AS Name, C.AccountNo, SUM(R.TotalFare) AS Revenue
	FROM
		Includes I, Customer C, Reservation R, Person P
	WHERE
		(I.ResrNo = R.ResrNo) AND (R.AccountNo = C.AccountNo) AND (P.Id = C.Id)
	GROUP BY
		C.AccountNo;
	
CREATE VIEW RevnCustRep AS -- For manager to view revenue by a Customer Representative
	SELECT
		E.SSN, CONCAT(P.LastName, ', ', P.FirstName) AS Name, SUM(R.TotalFare) AS Revenue
	FROM
		Includes I, Employee E, Reservation R, Person P
	WHERE
		(I.ResrNo = R.ResrNo) AND (R.RepSSN = E.SSN) AND (P.Id = E.Id) 
	GROUP BY
		E.SSN;

CREATE VIEW MostActFlight AS -- For manager to view the most active flight
	SELECT
		AirlineID, FlightNo, MaxLengthOfStay
	FROM
		Flight
	WHERE 
		MaxLengthOfStay <= (SELECT MIN(f2.MaxLengthOfStay) FROM Flight f2);

CREATE VIEW CustSeat AS -- For manager to view customers who booked seats on planes
	SELECT 
		CONCAT(P.LastName, ', ', P.FirstName) AS Name, RP.AccountNo, RP.SeatNo, I.FlightNo, I.AirlineID, I.LegNo
	FROM
		Includes I, ReservationPassenger RP, Person P, Customer C, Reservation R
	WHERE
		(I.ResrNo = R.ResrNo) AND (RP.ResrNo = R.ResrNo) AND (R.AccountNo = C.AccountNo) AND (P.Id = C.Id);

CREATE VIEW FlightListAir AS -- For manager to view flight by airports
	SELECT
		A.Id, A.Name AS Airport, L.AirlineID, L.FlightNo
	FROM
		Leg L, Airport A
	WHERE
		L.ArrAirportID = A.Id -- Dup
	ORDER BY A.Name;

CREATE VIEW FlightListOnTime AS -- For manager to view flights by on-Time
	(SELECT
		L.AirlineID, L.FlightNo, L.LegNo, A.Name, L.ArrTime AS Expected, I.Date AS Actual
	FROM
		Includes I, Airport A, Leg L
	WHERE 
		(L.AirlineID = I.AirlineID) AND (L.FlightNo = I.FlightNo) AND (L.ArrAirportID = A.Id) AND (I.Date <= L.ArrTime) AND (I.LegNo = L.LegNo))
UNION
	(SELECT
		L2.AirlineID, L2.FlightNo, L2.LegNo, A2.Name, L2.ArrTime AS Expected, I2.Date AS Acutal
	FROM
		Includes I2, Airport A2, Leg L2
	WHERE 
		(L2.AirlineID = I2.AirlineID) AND (L2.FlightNo = I2.FlightNo) AND (L2.DepAirportID = A2.Id) AND (I2.Date <= L2.DepTime) AND (I2.LegNo = L2.LegNo));

CREATE VIEW FlightListDelayed AS -- For manager to view flights by delayed-Time
	(SELECT
		L.AirlineID, L.FlightNo, L.LegNo, A.Name, L.ArrTime AS Expected, I.Date AS Acutal
	FROM 
		Includes I, Airport A, Leg L
	WHERE 
		(L.AirlineID = I.AirlineID) AND (L.FlightNo = I.FlightNo) AND (L.ArrAirportID = A.Id) AND (I.Date > L.ArrTime) AND (I.LegNo = L.LegNo))
UNION
(SELECT
		L2.AirlineID, L2.FlightNo, L2.LegNo, A2.Name, L2.ArrTime AS Expected, I2.Date AS Acutal
	FROM
		Includes I2, Airport A2, Leg L2
	WHERE 
		(L2.AirlineID = I2.AirlineID) AND (L2.FlightNo = I2.FlightNo) AND (L2.DepAirportID = A2.Id) AND (I2.Date > L2.DepTime) AND (I2.LegNo = L2.LegNo));

CREATE VIEW ResrData AS -- For customer reprensentative to view reservations
	SELECT
		ResrNo, ResrDate, BookingFee, TotalFare, RepSSN, AccountNo
	FROM
		Reservation;

CREATE VIEW CustData AS -- For customer reprensentative to view reservations
	SELECT 
		R.RepSSN, R.AccountNo, CreditCardNo, CreationDate, Rating
	FROM
		Customer, Reservation R;

CREATE VIEW CustMailList AS -- For customer reprensentative to view customer mailing lists
	SELECT 
		CONCAT(P.LastName, ' ', P.FirstName) AS Name, C.AccountNo, CONCAT(P.Address, ' ', P.City, ' ', P.State, ' ', P.ZipCode) AS Address, 
        P.Telephone, P.Email
	FROM
		Person P, Customer C
	WHERE
		P.Id = C.Id;
        
CREATE VIEW FlightSuggest AS -- For customer rep. to suggest & customer to see personalized flight suggest list
	SELECT 
		 C.AccountNo, F.AirlineID, F.FlightNo
	FROM 
		Flight F, Customer C
	WHERE (F.AirlineID, F.FlightNo) IN (
		SELECT 
			L.AirlineID, L.FlightNo
		FROM 
			Reservation R, Includes I, Leg L
		WHERE 
			R.ResrNo = I.ResrNo AND C.AccountNo = R.AccountNo AND I.AirlineID = L.AirlineID AND I.FlightNo = L.FlightNo);

CREATE VIEW ResrType AS -- For customer to see their reservation type
	SELECT * FROM Fare;

CREATE VIEW ResrDataCust AS -- For customer to see their reservations
	SELECT
		R.AccountNo, R.ResrDate, R.BookingFee, R.TotalFare, R.RepSSN
	FROM
		Reservation R, Customer C
	WHERE
		R.AccountNo = C.AccountNo;

CREATE VIEW ItinResr AS -- For customer to see their travel itineraries
	SELECT
		C.AccountNo, R.ResrNo, I.LegNo, L.AirlineID, L.FlightNo, L.ArrTime, L.ArrAirportID, L.DepTime, L.DepAirportID
	FROM
		Leg L, Includes I, Reservation R, Customer C
	WHERE
		(I.AirlineID = L.AirlineID) AND (I.FlightNo = L.FlightNo) AND (I.LegNo = L.LegNo) AND (C.AccountNo = R.AccountNo) AND (I.ResrNo = R.ResrNo)
	ORDER BY R.ResrNo;

CREATE VIEW Bids AS -- For customer to see bids
	SELECT 
		AccountNo, AirlineID, FlightNo, Class, Date, NYOP, Accepted
	FROM
		Auction;

CREATE VIEW BestFlight AS -- For customer to see best-seller list of flights
	SELECT
		F.AirlineID, F.FlightNo
	FROM
		Flight F, RevnFlight RF
	WHERE
		 (RF.AirlineID = F.AirlineID) AND (RF.FlightNo = F.FlightNo) AND (RF.Revenue >= (SELECT MAX(RF1.Revenue) FROM RevnFlight RF1))
	GROUP BY
		F.AirlineID, F.FlightNo;

-- Create Procedures
delimiter |

-- Manager-Level Transactions
DROP PROCEDURE IF EXISTS AddEmpl |
CREATE PROCEDURE AddEmpl (
	IN Id INTEGER,
	IN SSN INTEGER,
	IN IsManager BOOLEAN,
    IN StartDate DATE,
    IN HourlyRate NUMERIC(10,2)
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		INSERT INTO Employee (Id, SSN, IsManager, StartDate, HourlyRate)
        VALUES(Id, SSN, IsManager, StartDate, HourlyRate);
    COMMIT;		
END;
|

DROP PROCEDURE IF EXISTS EditEmpl |
CREATE PROCEDURE EditEmpl (
	IN KeySSN INTEGER,
	IN SSN INTEGER,
	IN IsManager BOOLEAN,
    IN StartDate DATE,
    IN HourlyRate NUMERIC(10,2)
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		UPDATE Employee 
        SET Employee.SSN = SSN, -- Can SSN be changed by manager?
				Employee.IsManager = IsManager, 
                Employee.StartDate = StartDate, 
                Employee.HourlyRate = HourlyRate 
        WHERE Employee.SSN = KeySSN;
    COMMIT;
END;
|

DROP PROCEDURE IF EXISTS DeleteEmpl |
CREATE PROCEDURE DeleteEmpl (
	IN KeySSN INTEGER
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		DELETE FROM Employee
        WHERE Employee.SSN = KeySSN;
    COMMIT;
END;
|

DROP PROCEDURE IF EXISTS ObtainSR | -- Obtain sales report
CREATE PROCEDURE ObtainSR ()
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT * FROM SalesReport;
    COMMIT;
END;
|

DROP PROCEDURE IF EXISTS ProduceAF | -- Produce all flights list
CREATE PROCEDURE ProduceAF ()
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT * FROM FlightListAll;
    COMMIT;
END;
|

DROP PROCEDURE IF EXISTS ProduceRF | -- Produce revenue by flight
CREATE PROCEDURE ProduceRF ()
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT * FROM RevnFlight;
    COMMIT;
END;
|

DROP PROCEDURE IF EXISTS ProduceRCity | -- Produce revenue by city
CREATE PROCEDURE ProduceRCity ()
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT * FROM RevnCity;
    COMMIT;
END;
|

DROP PROCEDURE IF EXISTS ProduceRCust | -- Produce revenue by customer
CREATE PROCEDURE ProduceRCust ()
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT * FROM RevnCust;
    COMMIT;
END;
|

DROP PROCEDURE IF EXISTS DetermineCR | -- Determine customer representative that generated most revenue
CREATE PROCEDURE DetermineCR ()
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT 
			RCR.SSN, RCR.Name, RCR.Revenue 
		FROM 
			RevnCustRep RCR
		WHERE
			Revenue >= (SELECT MAX(RCR1.Revenue) FROM RevnCustRep RCR1);
    COMMIT;
END;
|

DROP PROCEDURE IF EXISTS DetermineC | -- Determine customer that generated most revenue
CREATE PROCEDURE DetermineC ()
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT 
			RC.AccountNo, RC.Name, RC.Revenue 
		FROM 
			RevnCust RC
		WHERE
			Revenue >= (SELECT MAX(RC1.Revenue) FROM RevnCust RC1);
    COMMIT;
END;
|

DROP PROCEDURE IF EXISTS ProduceAFA | -- Produce most active flights
CREATE PROCEDURE ProduceAFA ()
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT * FROM MostActFlight;
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS ProduceCustSeat | -- Produce customers that have seats on a given flight
CREATE PROCEDURE ProduceCustSeat (
	IN AirlineID CHAR(2),
    IN FlightNo INTEGER
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT 
			CS.Name, CS.AccountNo , CS.LegNo
		FROM
			CustSeat CS
		WHERE
			CS.AirlineID = AirlineID AND CS.FlightNo = FlightNo;
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS ProduceFAP | -- Produce flights for a given airport
CREATE PROCEDURE ProduceFAP (
	IN Id CHAR(3)
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT 
			FL.Id, FL.Airport, FL.FlightNo
		FROM
			FlightListAir FL
		WHERE
			FL.Id = Id;
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS ProduceFAP | -- Produce flights for a given airport
CREATE PROCEDURE ProduceFAP (
	IN Id CHAR(3)
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT 
			FL.Id, FL.Airport, FL.FlightNo
		FROM
			FlightListAir FL
		WHERE
			FL.Id = Id;
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS ProduceFOnTime | -- Produce flights on time
CREATE PROCEDURE ProduceFOnTime ()
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT * FROM FlightListOnTime;
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS ProduceFDelayed | -- Produce flights delayed
CREATE PROCEDURE ProduceFDelayed ()
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT * FROM FlightListDelayed;
	COMMIT;
END;
|

-- Customer-Representative-Level Transactions
DROP PROCEDURE IF EXISTS RecordResr | -- Record Reservation TODO: Customer Preferences & Reservation Passenger => Cus.Rep does this?
CREATE PROCEDURE RecordResr (
	IN ResrNo INTEGER,
    IN ResrDate DATETIME,
    IN BookingFee NUMERIC(10,2),
    IN TotalFare NUMERIC(10,2),
    IN RepSSN INTEGER,
    IN AccountNo INTEGER
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		INSERT INTO Reservation (ResrNo, ResrDate, BookingFee, TotalFare, RepSSN, AccountNo)
        VALUES(ResrNo, ResrDate, BookingFee, TotalFare, RepSSN, AccountNo);
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS AddCust | -- Add Customer Info
CREATE PROCEDURE AddCust (
	IN Id INTEGER,
    IN AccountNo INTEGER,
    IN CreditCardNo CHAR(16),
    IN CreationDate DateTime,
    IN Rating INTEGER
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		INSERT INTO Customer (Id, AccountNo, CreditCardNo, CreationDate, Rating)
        VALUES (Id, AccountNo, CreditCardNo, CreationDate, Rating);
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS EditCust | -- Edit Customer Info
CREATE PROCEDURE EditCust (
	IN KeyAccountNo INTEGER,
    IN AccountNo DATETIME,
    IN CreditCardNo CHAR(16),
    IN CreationDate DateTime,
    IN Rating INTEGER
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		UPDATE Customer 
        SET Customer.AccountNo = AccountNo, 
				Customer.CreditCardNo = CreditCardNo, 
                Customer.CreationDate = CreationDate, 
                Customer.Rating = Rating
		WHERE Customer.AccountNo = KeyAccountNo;
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS DeleteCust | -- Delete Customer Info
CREATE PROCEDURE DeleteCust (
	IN KeyAccountNo INTEGER
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		DELETE FROM Customer 
		WHERE Customer.AccountNo = KeyAccountNo;
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS ProduceMail | -- Produce customer mailing list
CREATE PROCEDURE ProduceMail ()
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT * FROM CustMailList 
		WHERE Customer.AccountNo = KeyAccountNo;
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS ProduceFSug | -- Produce customer flight suggest list (based on past)
CREATE PROCEDURE ProduceFSug (
	IN KeyAccountNo INTEGER
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT 
			AirlineID, FlightNo 
		FROM 
			FlightSuggest 
		WHERE FlightSuggest.AccountNo = KeyAccountNo;
	COMMIT;
END;
|

-- Customer-Level Transactions
DROP PROCEDURE IF EXISTS MakeResrT | -- Make reservations TODO: Touch DB directly
CREATE PROCEDURE MakeResrT (
	IN AirlineID CHAR(2),
    IN FlightNo INTEGER,
	IN FareType VARCHAR(20),
    IN Class VARCHAR(20),
    IN IsDomestic BOOLEAN,
    IN IsFlexible BOOLEAN
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		INSERT ResrType (AirlineID, FlightNo, FareType, Class, Fare, IsDomestic, IsFlexible) -- Touch View
		VALUES (AirlineID, FlightNo, FareType, Class, '?', IsDomestic, IsFlexible);
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS RetrieveCurResr | -- Retrieve current reservations
CREATE PROCEDURE RetrieveCurResr (
	IN AccountNo INTEGER
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT * FROM Reservation WHERE Reservation.AccountNo = AccountNo;
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS RetrieveTItin | -- Retrieve travel itinerary for a given reservation
CREATE PROCEDURE RetrieveTItin (
	IN KeyResrNo INTEGER
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT * FROM ItinResr WHERE ItinResr.ResrNo = KeyResrNo;
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS RetrieveCurBid | -- Retrieve customer's current bid on a given auction
CREATE PROCEDURE RetrieveCurBid (
	IN AccountNo INTEGER,
	IN AirlineID CHAR(2),
	IN FlightNo INTEGER,
	IN Class VARCHAR(20),
	IN Date DATETIME
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT NYOP, Accepted FROM Bids WHERE Bids.AccountNo = AccountNo AND Bids.AirlineID = AirlineID AND Bids.FlightNo = FlightNo AND Bids.Class = Class AND Bids.Date = Date;
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS RetrieveBidHis | -- Retrieve bid history for a given auction
CREATE PROCEDURE RetrieveBidHis (
	IN AccountNo INTEGER,
	IN AirlineID CHAR(2),
	IN FlightNo INTEGER,
	IN Class VARCHAR(20),
	IN Date DATETIME
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT * FROM Bids WHERE Bids.AccountNo = AccountNo AND Bids.AirlineID = AirlineID AND Bids.FlightNo = FlightNo AND Bids.Class = Class AND Bids.Date = Date;
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS RetrieveAllResr | -- Retrieve all history for a reservation that a customer made
CREATE PROCEDURE RetrieveAllResr (
	IN KeyAccountNo INTEGER
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT * FROM ResrData WHERE ResrData.AccountNo = KeyAccountNo;
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS RetrieveBestF | -- Retrieve all history for a reservation that a customer made
CREATE PROCEDURE RetrieveBestF ()
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT * FROM BesrFlight;
	COMMIT;
END;
|

DROP PROCEDURE IF EXISTS RetrieveFSuggest | -- Retrieve all history for a reservation that a customer made
CREATE PROCEDURE RetrieveFSuggest (
	IN KeyAccountNo INTEGER
)
SQL SECURITY INVOKER
BEGIN
	START TRANSACTION;
		SELECT * FROM FlightSuggest WHERE FlightSuggest.AccountNo = KeyAccountNo;
	COMMIT;
END;
|

delimiter ;

-- Call Procedures with Typical Values
CALL howoo.AddCust (1, 4, '5262147830293048', '2011-01-03 03:30:30', 0);