package com.example.Excercise1.utils;

import java.math.BigDecimal;
import java.sql.Date;

public class ErrorCodeMap {
    /**
     * Generic 'success' code. (0 - 199)
     */
    public static final int SUCCESS = 100;
    public static final String SUCCESS_MSG = "Successful";

    public static final int NEW_RECORD = 101;
    public static final String NEW_RECORD_MSG = "New Record";

    public static final int UPDATED_RECORD = 102;
    public static final String UPDATED_RECORD_MSG = "Updated Record";

    public static final int DELETED_RECORD = 103;
    public static final String DELETED_RECORD_MSG = "Deleted Record";

    public static final int TRANSITION = 104;

    public static final int DELETED_NEW_RECORD = 105;
    public static final String DELETED_NEW_RECORD_MSG = "Deleted New Record";

    public static final int DAO_INIT = 106;
    public static final String DAO_INIT_MSG = "DAO Initialization";

    public static final int RECORD_FOUND = 0;
    public static final String RECORD_FOUND_MSG = "Select Successful";

    public static final int RECORD_NOT_FOUND = 3;
    public static final String RECORD_NOT_FOUND_MSG = "Select Unsuccessful";

    public static final int DATA_LOCKED = 4;
    public static final String DATA_LOCKED_MSG = "Data locked";

    // offices
    public static final String OFFICE_TABLE = "offices";
    public static final String OFFICE_OFFICE_CODE = "officeCode";
    public static final String OFFICE_CITY = "city";
    public static final String OFFICE_PHONE = "phone";
    public static final String OFFICE_ADDRESS_LINE1 = "addressLine1";
    public static final String OFFICE_ADDRESS_LINE2 = "addressLine2";
    public static final String OFFICE_STATE = "state";
    public static final String OFFICE_COUNTRY = "country";
    public static final String OFFICE_POSTAL_CODE = "postalCode";
    public static final String OFFICE_TERRITORY = "territory";

    // customers
    public static final String CUSTOMERS_TABLE = "customers";
    public static final String CUSTOMERS_CUSTOMER_NUMBER = "customerNumber";
    public static final String CUSTOMERS_CUSTOMER_NAME = "customerName";
    public static final String CUSTOMERS_CONTACT_LAST_NAME = "contactLastName";
    public static final String CUSTOMERS_CONTACT_FIRST_NAME = "contactFirstName";
    public static final String CUSTOMERS_PHONE = "phone";
    public static final String CUSTOMERS_ADDRESS_LINE1 = "addressLine1";
    public static final String CUSTOMERS_ADDRESS_LINE2 = "addressLine2";
    public static final String CUSTOMERS_CITY = "city";
    public static final String CUSTOMERS_STATE = "state";
    public static final String CUSTOMERS_POSTAL_CODE = "postalCode";
    public static final String CUSTOMERS_COUNTRY = "country";
    public static final String CUSTOMERS_SALES_REP_EMPLOYEE_NUMBER = "salesRepEmployeeNumber";
    public static final String CUSTOMERS_CREDIT_LIMIT = "creditLimit";

    // employees
    public static final  String EMPLOYEES_TABLE = "employees";
    public static final  String EMPLOYEES_EMPLOYEENUMBER = "employeeNumber ";
    public static final  String EMPLOYEES_LASTNAME = "lastName";
    public static final  String EMPLOYEES_FIRSTNAME = "firstName";
    public static final  String EMPLOYEES_EXTENSION = "extension";
    public static final  String EMPLOYEES_EMAIL = "email";
    public static final  String EMPLOYEES_OFFICECODE = "officeCode";
    public static final  String EMPLOYEES_REPORTSTO = "reportsTo";
    public static final  String EMPLOYEES_JOBTITLE = "jobTitle";

    // order details
    public static final String ORDER_DETAILS_TABLE = "orderdetails";
    public static final String ORDER_DETAILS_ORDERNUMBER = "orderNumber";
    public static final String ORDER_DETAILS_PRODUCTCODE = "productCode";
    public static final String ORDER_DETAILS_QUANTITYORDERED = "quantityOrdered";
    public static final String ORDER_DETAILS_PRICEEACH = "priceEach";
    public static final String ORDER_DETAILS_ORDERLINENUMBER = "orderLineNumber";

    // orders
    public static String ORDERS_TABLE = "orders";
    public static String ORDERS_ORDERNUMBER = "orderNumber";
    public static String ORDERS_ORDERDATE = "orderDate";
    public static String ORDERS_REQUIREDDATE = "requiredDate";
    public static String ORDERS_SHIPPEDDATE = "shippedDate";
    public static String ORDERS_STATUS = "status";
    public static String ORDERS_COMMENTS = "comments";
    public static String ORDERS_CUSTOMERNUMBER = "customerNumber";

    // payments
    public static final String PAYMENTS_TABLE = "payments";
    public static final String PAYMENTS_CUSTOMERNUMBER = "customerNumber";
    public static final String PAYMENTS_CHECKNUMBER = "checkNumber";
    public static final String PAYMENTS_PAYMENTDATE = "paymentDate";
    public static final String PAYMENTS_AMOUNT = "amount";

    // productlines
    public static final String PRODUCTLINES_TABLE = "productlines";
    public static final String PRODUCTLINES_PRODUCTLINE = "productLine";
    public static final String PRODUCTLINES_TEXTDESCRIPTION = "textDescription";
    public static final String PRODUCTLINES_HTMLDESCRIPTION = "htmlDescription";
    public static final String PRODUCTLINES_IMAGE = "image";

    // products
    public static final String PRODUCTS_TABLE = "products";
    public static final String PRODUCTS_PRODUCTCODE = "productCode";
    public static final String PRODUCTS_PRODUCTNAME = "productName";
    public static final String PRODUCTS_PRODUCTLINE = "productLine";
    public static final String PRODUCTS_PRODUCTSCALE = "productScale";
    public static final String PRODUCTS_PRODUCTVENDOR = "productVendor";
    public static final String PRODUCTS_PRODUCTDESCRIPTION = "productDescription";
    public static final String PRODUCTS_QUANTITYINSTOCK = "quantityInStock";
    public static final String PRODUCTS_BUYPRICE = "buyPrice";
    public static final String PRODUCTS_MSRP = "msrp";
}
