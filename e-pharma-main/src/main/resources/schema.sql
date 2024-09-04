# noinspection SqlNoDataSourceInspectionForFile

create database epharma;
show databases;
use epharma;

CREATE TABLE users(
userId INT PRIMARY KEY,
username VARCHAR(30),
password VARCHAR(80),
role VARCHAR(30));

CREATE TABLE stock(
stockId INT PRIMARY KEY,
medicineId INT,
batchNo varchar(70),
expiryDate DATE,
quantity INT,
price DECIMAL(10, 2),
checkInDate DATE,
entryBy int,
systemDateTime DATETIME);

CREATE TABLE sales(
salesId INT PRIMARY KEY,
medicineId INT,
batchNo varchar(70),
expiryDate DATE,
quantity INT,
price DECIMAL(10, 2),
checkOutDate DATE,
billId INT,
entryBy int,
systemDateTime DATETIME);

CREATE TABLE bills(
billId INT PRIMARY KEY,
billingDate DATE,
customerName VARCHAR(250),
customerMobile VARCHAR(15),
entryBy int,
systemDateTime DATETIME);

CREATE TABLE medicines(
medicineId INT PRIMARY KEY,
medicineName VARCHAR(50),
medicineDescription VARCHAR(50));

CREATE TABLE salesAudit (
  auditId INT PRIMARY KEY AUTO_INCREMENT,
  salesId INT,
  medicineId INT,
  batchNo varchar(70),
  expiryDate DATE,
  quantity INT,
  price DECIMAL(10, 2),
  checkOutDate DATE,
  billId INT,
  entryBy int,
  systemDateTime DATETIME,
  auditType VARCHAR(10),
  auditDateTime DATETIME,
  auditBy int
);

CREATE TABLE stockAudit (
  auditId INT PRIMARY KEY AUTO_INCREMENT,
  stockId INT,
  medicineId INT,
  batchNo varchar(70),
  expiryDate DATE,
  quantity INT,
  price DECIMAL(10, 2),
  checkInDate DATE,
  entryBy int,
  systemDateTime DATETIME,
  auditType VARCHAR(10),
  auditDateTime DATETIME,
  auditBy int

);


INSERT INTO `users` (`userId`, `username`, `userPassword`, `userRole`) VALUES
(1, 'user', '$2a$10$6mNJafxCS/PaX4v./qNbx.TRbuLlKzS8Z3s7BobMk/R2urx6iBOVy', 'USER');

INSERT INTO `users` (`userId`, `username`, `userPassword`, `userRole`) VALUES
(2, 'admin', '$2a$10$1qmMoJhxrssdkTe0HcKbKOILn9SJwfaq4OrF7eXe13SrRQ4qxUFnu', 'ADMIN');

--------Reports----------

-----------------------------------Avl Stock---------------------------------------
SELECT m.medicineName, SUM(s.quantity) - COALESCE(t.totalSales, 0) as availableStock
FROM stock s
JOIN medicines m ON s.medicineId = m.medicineId
LEFT JOIN (
    SELECT medicineId, SUM(quantity) as totalSales
    FROM sales
    GROUP BY medicineId
) t ON m.medicineId = t.medicineId
GROUP BY m.medicineName;

-------------------------Avl Stock in batchNo and expiryDate--------------------------
SELECT m.medicineName, m.medicineId,
       s.batchNo,
       s.expiryDate,
       s.quantity - COALESCE(sa.soldQuantity, 0) AS avlStock
FROM stock s
         INNER JOIN medicines m ON s.medicineId = m.medicineId
         LEFT JOIN (
    SELECT medicineId, batchNo, expiryDate, SUM(quantity) AS soldQuantity
    FROM sales
    GROUP BY medicineId, batchNo, expiryDate
) sa
                   ON s.medicineId = sa.medicineId
                       AND s.batchNo = sa.batchNo
                       AND s.expiryDate = sa.expiryDate
