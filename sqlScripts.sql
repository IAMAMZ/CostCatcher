USE Miranlakmaqarach;

SET SQL_SAFE_UPDATES=0;

CREATE TABLE Payee (
    payeeId INT PRIMARY KEY AUTO_INCREMENT,
    payeeName VARCHAR(255),
    contactNumber VARCHAR(15),
    email VARCHAR(255),
    streetAddress VARCHAR(255),
    postalCode VARCHAR(10),
    country VARCHAR(255)
);

CREATE TABLE Expense (
    expenseId INT PRIMARY KEY AUTO_INCREMENT,
    expenseName VARCHAR(255),
    dueDate DATE,
    creationDate DATE,
    paid BOOLEAN,
    amountDue DOUBLE,
    isRecurring BOOLEAN,
    recurrencePeriodDays INT,
    payeeId INT,
    FOREIGN KEY (payeeId) REFERENCES Payee(payeeId)
);
INSERT INTO Payee (payeeName, contactNumber, email, streetAddress, postalCode, country) VALUES 
('Payee 1', '123456789', 'payee1@example.com', '123 Street, City', '12345', 'Country A'),
('Payee 2', '234567890', 'payee2@example.com', '456 Avenue, City', '23456', 'Country B'),
('Payee 10', '102938475', 'payee10@example.com', '789 Boulevard, City', '45678', 'Country J');

INSERT INTO Expense (expenseName, dueDate, creationDate, paid, amountDue, isRecurring, recurrencePeriodDays, payeeId) VALUES 
('Rent', '2023-11-01', '2023-10-01', FALSE, 1500, TRUE, 30, 1),
('Electric Bill', '2023-11-15', '2023-10-15', FALSE, 120, TRUE, 30, 2),
('Grocery', '2023-11-03', '2023-10-01', TRUE, 200, FALSE, NULL, 3),
('Car Payment', '2023-11-05', '2023-10-01', TRUE, 350, TRUE, 30, 1);

select * from Expense LEFT JOIN Payee on Expense.payeeId = Payee.PayeeId;

select * from Expense right JOIN Payee on Expense.payeeId = Payee.PayeeId;

DELETE FROM Payee WHERE country is Null;

select * from Expense;
SELECT * FROM Payee;

INSERT INTO Expense  (expenseName, dueDate, creationDate, paid, amountDue, isRecurring, recurrencePeriodDays, payeeId)VALUES ("Service fee",'2023-09-05','2023,-8-05',FALSE,400,TRUE,30,1);

select * from Payee;

SELECT
    CONSTRAINT_NAME 
FROM
    information_schema.KEY_COLUMN_USAGE
WHERE
    TABLE_NAME = 'Expense' AND
    COLUMN_NAME = 'payeeId' AND
    REFERENCED_TABLE_NAME = 'Payee';
    
    
    
ALTER TABLE Expense
DROP FOREIGN KEY expense_ibfk_1;

-- Now, add a new foreign key constraint with ON DELETE CASCADE

ALTER TABLE Expense
ADD CONSTRAINT fk_payee
FOREIGN KEY (payeeId) REFERENCES Payee(payeeId)
ON DELETE CASCADE;