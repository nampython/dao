package com.example.Excercise1.data;

import com.example.Excercise1.mars.ValueObject;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class ProductsEntity implements ValueObject {
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private short quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal msrp;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public short getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getMsrp() {
        return msrp;
    }

    public void setMsrp(BigDecimal msrp) {
        this.msrp = msrp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return quantityInStock == that.quantityInStock && Objects.equals(productCode, that.productCode) && Objects.equals(productName, that.productName) && Objects.equals(productLine, that.productLine) && Objects.equals(productScale, that.productScale) && Objects.equals(productVendor, that.productVendor) && Objects.equals(productDescription, that.productDescription) && Objects.equals(buyPrice, that.buyPrice) && Objects.equals(msrp, that.msrp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, msrp);
    }

    @Override
    public void parseSql(ResultSet var1) throws SQLException {

    }

    @Override
    public void setResultCode(int var1) {

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public String getExecuteSql() {
        return null;
    }

    @Override
    public String getSelectSql() {
        return null;
    }

    @Override
    public List getParams() {
        return null;
    }

    @Override
    public List getPkParams() {
        return null;
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public int getResultCode() {
        return 0;
    }

    @Override
    public String getDeleteSql() {
        return null;
    }

    @Override
    public String getInsertSql() {
        return null;
    }

    @Override
    public String getUpdateSql() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public void setModified(boolean var1) {

    }
}
