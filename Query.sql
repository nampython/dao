# --------------------------------------------------------------
select *
from products;
select *
from productlines
where productLine = 'Classic Cars';
select *
from productlines
order by 'productLine';
select *
from orders;
select *
from offices;
select *
from orders;
select *
from employees
order by employeeNumber ASC;
select *
from customers;
select *
from offices;

select *
from information_schema.COLUMNS
where TABLE_SCHEMA = 'classicmodels'
  and TABLE_NAME = 'customers'
order by ordinal_position


# CUSTOMER
# UPDATE
update customers
set customerName           = ?,
    contactLastName        = ?,
    contactFirstName       = ?,
    phone                  = ?,
    addressLine1           = ?,
    addressLine2           = ?,
    city                   = ?,
    state                  = ?,
    postalCode             = ?,
    country                = ?,
    salesRepEmployeeNumber = ?,
    creditLimit            = ?
where customerNumber = ?;
# INSERT
insert into customers(customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state,
                      postalCode, country, salesRepEmployeeNumber, creditLimit)
values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
# delete
delete
from customers
where customerNumber = ?;

# EMPLOYEE
#  INSERT
insert into employees(lastName, firstName, extension, email, officeCode, reportsTo, jobTitle)
values (?, ?, ?, ?, ?, ?, ?);
delete
from employees
where employeeNumber = ?;
update employees
set lastName   = ?,
    firstName  = ?,
    extension  = ?,
    email      = ?,
    officeCode = ?,
    reportsTo  = ?,
    jobTitle   = ?
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
VALUES (10453, '2005-05-31', '2005-06-10', '2005-06-11', 'KK', 145);

SHOW PROCEDURE STATUS;

call getOfficeByCountry('USA');
call GetProductlines();
call GetCustomers();
call GetOrderCountByStatus('Shipped', @total);
select @total;


SHOW CHARACTER SET;

# find employee with customer and payments
SELECT concat(lastName, ' ', firstName) as fullname,
       customerName,
       checkNumber,
       amount
FROM employees
         LEFT JOIN customers ON
    employeeNumber = salesRepEmployeeNumber
         LEFT JOIN payments ON
    payments.customerNumber = customers.customerNumber
ORDER BY customerName,
         checkNumber;

#  find employees who do not in charge of any customers:
select employeeNumber, lastName, firstName, customerName
from customers c
         right join employees e on c.salesRepEmployeeNumber = e.employeeNumber
where customerName is null;

# get the total amount of all orders by status,
select status, sum(quantityOrdered * priceEach)
from orders
         inner join orderdetails using (orderNumber)
group by status;

# the order numbers and the total amount of each order.
select orderNumber, sum(quantityOrdered * orderdetails.priceEach) as total
from orders
         inner join orderdetails using (orderNumber)
group by orderNumber;

#  gets the total sales for each year.
select year(orderDate) as year, sum(quantityOrdered * priceEach) as total
from orders
         inner join orderdetails using (orderNumber)
where status = ?
group by year
having year = ?;

# find all orders that already shipped and have a total amount greater than 1500
SELECT a.ordernumber,
       status,
       SUM(priceeach * quantityOrdered) total
FROM orderdetails a
         INNER JOIN orders b
                    ON b.ordernumber = a.ordernumber
GROUP BY ordernumber,
         status
HAVING status = 'Shipped'
   AND total > 1500;


CREATE TABLE sales
SELECT productLine,
       YEAR(orderDate)                  orderYear,
       SUM(quantityOrdered * priceEach) orderValue
FROM orderDetails
         INNER JOIN
     orders USING (orderNumber)
         INNER JOIN
     products USING (productCode)
GROUP BY productLine,
         YEAR(orderDate);


select productLine, sum(orderValue)
from sales
group by productLine
union all
select null, sum(orderValue)
from sales;

SELECT productLine,
       SUM(orderValue) totalOrderValue
FROM sales
GROUP BY productline
WITH ROLLUP;

#  find the customer who has the highest payment.
select customerNumber, amount
from payments
where amount = (select max(amount) from payments);

select *
from payments
order by amount desc
limit 1;

# find the customers those payments are greater than the average payment
select *
from payments
where amount > (select avg(amount) from payments);

# find the customer who have not placed any orders
select orders.customerNumber, customerName
from orders
         right join customers c on orders.customerNumber = c.customerNumber
where orders.customerNumber is null;

select customerName
from customers
where customerNumber not in (select customerNumber
                             from orders);

# finds the maximum, minimum, and average number of items in sale orders:
select min(items), max(items), floor(avg(items))
from (select orderNumber, count(orderNumber) as items
      from orderdetails
      group by orderNumber) as lineitems;

#  gets the top five products by sales revenue in 2003 from the orders and orderdetails, products table
select productName, total
from (select productCode, sum(quantityOrdered * priceEach) as total
      from orders o1
               inner join orderdetails o2 using (orderNumber)
      where year(shippedDate) = 2003
      group by orderNumber
      order by total DESC
      limit 5
    ) as topFiveProduct
inner join products using(productCode);