# --------------------------------------------------------------
select * from products;
select * from productlines where productLine = 'Classic Cars';
select * from productlines order by 'productLine';
select * from orders;
select * from offices;
select * from orders;
select * from employees order by employeeNumber ASC ;
select * from customers;

select * from information_schema.COLUMNS
where TABLE_SCHEMA = 'classicmodels' and
      TABLE_NAME = 'customers'
order by  ordinal_position;


# CUSTOMER
# UPDATE
update customers
set customerName = ?, contactLastName = ?, contactFirstName = ?, phone = ?, addressLine1 = ?, addressLine2 = ?, city = ?, state = ?, postalCode = ?, country = ?, salesRepEmployeeNumber = ?, creditLimit = ?
where customerNumber = ?;
# INSERT
insert into customers(customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit)
values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
# delete
delete from customers where customerNumber = ?;

# EMPLOYEE
#  INSERT
insert into employees(lastName, firstName, extension, email, officeCode, reportsTo, jobTitle)
values (?, ?, ?, ?, ?, ?, ?);
delete from employees where employeeNumber = ?;
update employees
set lastName = ?, firstName = ?, extension = ?, email = ?, officeCode = ?, reportsTo = ?, jobTitle = ?
where employeeNumber = ?;


# PRODUCT LINES
insert into productlines(productLine, textDescription, htmlDescription, image)
values ('Phone1', 'Very good', null, null);
insert into productlines(productLine, textDescription, htmlDescription, image)
values ('Phone2', 'Very good', null, null);
insert into productlines(productLine, textDescription, htmlDescription, image)
values ('Phone3', 'Very good', null, null);

# ORDERS
INSERT INTO orders(orderNumber, orderDate, requiredDate, shippedDate, status, customerNumber)
VALUES (10427, '2005-05-31', '2005-06-10', '2005-06-11', 'In Process', 145);
INSERT INTO orders(orderNumber, orderDate, requiredDate, shippedDate, status, customerNumber)
VALUES(10453, '2005-05-31', '2005-06-10', '2005-06-11', 'KK', 145);

SHOW PROCEDURE STATUS;

call getOfficeByCountry('USA');
call GetProductlines();
call GetCustomers();
call GetOrderCountByStatus('Shipped', @total);
select @total;


SHOW CHARACTER SET;