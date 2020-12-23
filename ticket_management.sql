CREATE DATABASE ticket_management

GO

USE ticket_management

GO

CREATE TABLE station
(
	id INT PRIMARY KEY IDENTITY(1,1),
	name NVARCHAR(255)
)

GO 

CREATE TABLE ticket
(
	id INT PRIMARY KEY IDENTITY(1,1),
	passenger NVARCHAR(50),
	phone VARCHAR(50),
	fromS INT FOREIGN KEY REFERENCES station("id"),
	toS INT FOREIGN KEY REFERENCES station("id"),
	type INT,
	startDate DATE,
	endDate DATE,
	adult int,
	child int,	
)

GO

INSERT INTO station VALUES (N'Hà Nội'),
						   (N'Đà Nẵng'),
						   (N'Tuyên Quang'),
						   (N'Ninh Bình'),	
						   (N'Bắc Giang')

GO

INSERT INTO ticket VALUES 
	(N'Phạm Hải Nam',	'012801014',	1,	3,	1,	'2020-09-09',	'2020-09-11',	4,	1),
	(N'Đỗ Minh Tân',	'095353451',	2,	4,	2,	'2020-09-09',	'2020-09-11',	3,	5),
	(N'Phan Minh Vũ',	'037852458',	1,	4,	1,	'2020-09-09',	'2020-09-11',	2,	2),
	(N'Trịnh Việt Hưng',	'0841964017',	1,	2,	2,	'2020-09-09',	'2020-09-11',	3,	3)

GO

CREATE PROC getAllStation
AS
BEGIN
	SELECT * FROM station
END

GO

CREATE PROC getStaionById
	@id INT
AS

BEGIN
	SELECT * FROM station  WHERE id = @id
END

GO



CREATE PROC getAllTicket
AS
BEGIN
	SELECT * FROM ticket
END

GO

CREATE PROC getTicketById
	@id INT
AS

BEGIN
	SELECT * FROM ticket  WHERE id = @id
END

GO

CREATE PROC removeTicketById
	@id INT
AS
BEGIN 
	DELETE FROM ticket WHERE id = @id
END

GO

ALTER PROC addTicket
	@passenger NVARCHAR(50),
	@phone VARCHAR(50),
	@fromS INT,
	@toS INT,
	@type INT,
	@startDate DATE,
	@endDate DATE,
	@adult int,
	@child int
AS
BEGIN 
	INSERT INTO ticket(passenger,phone, fromS, toS,type,startDate,endDate,adult,child) VALUES (@passenger, @phone, @fromS, @toS, @type,
							   @startDate, @endDate, @adult, @child)
END

GO

addTicket N'Phạm Hải Nam',	'012801014',	1,	3,	1,	'2020-09-09',	'2020-09-11',	4,	1
