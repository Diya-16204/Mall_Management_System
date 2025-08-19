CREATE DATABASE PROJECT2
USE PROJECT2

CREATE TABLE Mall (
  MallID INT PRIMARY KEY,
  Name VARCHAR(255),
  Location VARCHAR(255),
  TotalParkingSlots INT,
  ContactNumber VARCHAR(255),
  OperatingHours VARCHAR(255)
);

CREATE TABLE Shop_Owners (
  OwnerID INT PRIMARY KEY,
  Name VARCHAR(255),
  ContactNumber VARCHAR(255),
  Email VARCHAR(255),
  Address VARCHAR(255)
);

CREATE TABLE Shops (
  ShopID INT PRIMARY KEY,
  Name VARCHAR(255),
  Category VARCHAR(255),
  FloorNumber INT,
  RentAmount DECIMAL,
  ContactNumber VARCHAR(255),
  OpeningHours VARCHAR(255),
  ClosingHours VARCHAR(255),
  MallID INT,
  OwnerID INT,
  FOREIGN KEY (MallID) REFERENCES Mall(MallID) ON DELETE CASCADE,
  FOREIGN KEY (OwnerID) REFERENCES Shop_Owners(OwnerID) ON DELETE CASCADE
);

CREATE TABLE Suppliers (
  SupplierID INT PRIMARY KEY,
  Name VARCHAR(255),
  ContactNumber VARCHAR(255),
  Email VARCHAR(255),
  Address VARCHAR(255)
);

CREATE TABLE Items (
  ItemID INT PRIMARY KEY,
  ProductName VARCHAR(255),
  Category VARCHAR(255),
  SupplierID INT,
  FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID)
);

CREATE TABLE Inventory (
  ShopID INT,
  ItemID INT,
  QuantityAvailable INT,
  ReorderLevel INT,
  Price DECIMAL,
  PRIMARY KEY (ShopID, ItemID),
  FOREIGN KEY (ShopID) REFERENCES Shops(ShopID) ON DELETE CASCADE,
  FOREIGN KEY (ItemID) REFERENCES Items(ItemID)
);

CREATE TABLE Customers (
  CustomerID INT PRIMARY KEY,
  Name VARCHAR(255),
  ContactNumber VARCHAR(255),
  Email VARCHAR(255),
  MembershipStatus VARCHAR(255)
);
CREATE TABLE Employees (
  EmployeeID INT PRIMARY KEY,
  ShopID INT,
  Name VARCHAR(255),
  Role VARCHAR(255),
  Salary DECIMAL,
  ContactNumber VARCHAR(255),
  FOREIGN KEY (ShopID) REFERENCES Shops(ShopID) ON DELETE CASCADE
);

CREATE TABLE Transactions (
  TransactionID INT PRIMARY KEY,
  CustomerID INT,
  ShopID INT,
  Amount DECIMAL,
  PaymentMethod VARCHAR(255),
  DateTime DATETIME,
  DiscountApplied DECIMAL,
  FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID) ON DELETE CASCADE,
  FOREIGN KEY (ShopID) REFERENCES Shops(ShopID)
);

INSERT INTO Mall VALUES
(1, 'City Center', 'Downtown', 500, '1234567890', '10:00 AM - 10:00 PM'),
(2, 'Sky Mall', 'Uptown', 300, '9876543210', '09:00 AM - 09:00 PM'),
(3, 'Mega Mall', 'Suburb', 400, '5556667777', '10:00 AM - 11:00 PM'),
(4, 'Urban Plaza', 'City Edge', 250, '2223334444', '11:00 AM - 09:00 PM'),
(5, 'Sunshine Galleria', 'Midtown', 350, '9998887777', '10:30 AM - 10:30 PM');

INSERT INTO Shop_Owners VALUES
(101, 'Amit Sharma', '7896541230', 'amit@shop.com', 'Delhi'),
(102, 'Priya Mehta', '7893214560', 'priya@shop.com', 'Mumbai'),
(103, 'Rahul Khanna', '7891236540', 'rahul@shop.com', 'Bangalore'),
(104, 'Neha Gupta', '9988776655', 'neha@shop.com', 'Hyderabad'),
(105, 'Arjun Rao', '8765432190', 'arjun@shop.com', 'Chennai');

INSERT INTO Shops VALUES
(201, 'Fashion Hub', 'Clothing', 1, 50000, '1112223333', '10:00 AM', '10:00 PM', 1, 101),
(202, 'Tech Zone', 'Electronics', 2, 75000, '2223334444', '11:00 AM', '09:00 PM', 1, 102),
(203, 'Daily Needs', 'Grocery', 1, 30000, '3334445555', '09:00 AM', '10:00 PM', 2, 103),
(204, 'Book World', 'Books', 3, 40000, '4445556666', '10:30 AM', '09:30 PM', 3, 104),
(205, 'Foodies', 'Food Court', 0, 80000, '5556667777', '11:00 AM', '11:00 PM', 4, 105);

INSERT INTO Suppliers VALUES
(301, 'ABC Distributors', '9001112233', 'abc@supplies.com', 'Delhi'),
(302, 'FreshMart', '9002223344', 'fresh@supplies.com', 'Mumbai'),
(303, 'GadgetSupreme', '9003334455', 'gadgets@supplies.com', 'Pune'),
(304, 'PaperTrail', '9004445566', 'books@supplies.com', 'Bangalore'),
(305, 'SpiceCo', '9005556677', 'food@supplies.com', 'Chennai');

INSERT INTO Items VALUES
(401, 'T-Shirt', 'Clothing', 301),
(402, 'LED TV', 'Electronics', 303),
(403, 'Rice Bag', 'Grocery', 302),
(404, 'Notebook', 'Books', 304),
(405, 'Burger Combo', 'Food', 305);

INSERT INTO Inventory VALUES
(201, 401, 50, 10, 499.00),
(202, 402, 10, 2, 24999.00),
(203, 403, 100, 20, 899.00),
(204, 404, 200, 50, 59.00),
(205, 405, 80, 15, 199.00);

INSERT INTO Customers VALUES
(501, 'Ravi Kumar', '8080808080', 'ravi@gmail.com', 'Gold'),
(502, 'Sneha Roy', '9090909090', 'sneha@gmail.com', 'Silver'),
(503, 'Arvind Patel', '7070707070', 'arvind@gmail.com', 'Platinum'),
(504, 'Divya Singh', '6060606060', 'divya@gmail.com', 'Gold'),
(505, 'Nikhil Jain', '5050505050', 'nikhil@gmail.com', 'Regular');

INSERT INTO Employees VALUES
(601, 201, 'Suresh Kumar', 'Manager', 35000, '9991112222'),
(602, 202, 'Anita Mehra', 'Sales Executive', 25000, '8882223333'),
(603, 203, 'Rohit Verma', 'Cashier', 20000, '7773334444'),
(604, 204, 'Sunita Das', 'Helper', 15000, '6664445555'),
(605, 205, 'Naveen Reddy', 'Chef', 30000, '5555555555');

INSERT INTO Transactions VALUES
(701, 501, 201, 998.00, 'Card', '2024-04-01 14:23:00', 10.00),
(702, 502, 202, 24999.00, 'UPI', '2024-04-02 16:45:00', 0.00),
(703, 503, 203, 1798.00, 'Cash', '2024-04-03 11:20:00', 20.00),
(704, 504, 204, 295.00, 'Card', '2024-04-03 17:00:00', 5.00),
(705, 505, 205, 398.00, 'Wallet', '2024-04-04 13:10:00', 0.00);