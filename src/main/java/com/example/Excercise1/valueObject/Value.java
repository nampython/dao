package com.example.Excercise1.valueObject;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Value implements Serializable {
    private Object value = null;

    public Value(Object obj) {
        this.value = obj;
    }

    public int toIntValue() throws NumberFormatException {
        if (this.value instanceof Number) {
            return ((Number) this.value).intValue();
        } else {
            return Integer.parseInt(value.toString());
        }
    }

    public int toIntValue(int defaultValue) throws NumberFormatException {
        int returnValue;
        if (this.value == null) {
            returnValue = defaultValue;
        } else {
            returnValue = toIntValue();
        }
        return returnValue;
    }

    public Integer toInteger() throws NumberFormatException {
        if (this.value == null) {
            return null;
        }
        if (this.value instanceof Integer) {
            return (Integer) this.value;
        }
        return Integer.valueOf(this.value.toString());
    }

    public float toFloatValue() throws NumberFormatException {
        if (this.value instanceof Number) {
            return ((Number) this.value).floatValue();
        } else {
            return Float.parseFloat(this.value.toString());
        }
    }

    public Float toFloat() throws NumberFormatException {
        if (this.value == null) {
            return null;
        }
        if (this.value instanceof Float) {
            return (Float) this.value;
        }
        return Float.valueOf(this.value.toString());
    }

    public double toDoubleValue() throws NumberFormatException {
        if (this.value instanceof Number) {
            return ((Number) this.value).doubleValue();
        } else {
            return Double.parseDouble(this.value.toString());
        }
    }

    public Double toDouble() throws NumberFormatException {
        if (this.value == null) return null;

        if (this.value instanceof Double) {
            return (Double) this.value;
        }

        return Double.valueOf(this.value.toString());
    }

    public long toLongValue() throws NumberFormatException {
        if (this.value instanceof Number) {
            return ((Number) this.value).longValue();
        } else {
            return Long.parseLong(this.value.toString());
        }
    }

    public boolean toBooleanValue() throws NumberFormatException {
        if (this.value instanceof Boolean) {
            return (Boolean) this.value;
        } else {
            // value.ToString is 1/0 not  "true"\"false".
        }
        return false;
    }

    public boolean toBooleanValue(boolean defaultValue) throws NumberFormatException {
        boolean booleanValue;
        if (this.value == null) {
            booleanValue = defaultValue;
        } else {
            booleanValue = toBooleanValue();
        }

        return booleanValue;
    }

    public Long toLong() throws NumberFormatException {
        if (this.value == null) return null;

        if (this.value instanceof Long) {
            return (Long) this.value;
        }

        return Long.valueOf(this.value.toString());
    }

    public Date toSqlDate() {
        if (this.value == null) {
            return null;
        }
        if (this.value instanceof Date) {
            return (Date) this.value;
        } else if (this.value instanceof java.util.Date) {
            return new Date(((java.util.Date) this.value).getTime());
        }
        throw new IllegalArgumentException("Not a valid java.sql.Date object. object class=" + this.value.getClass().getName());
    }

    public java.util.Date toUtilDate() {
        if (this.value == null) {
            return null;
        }
        if (this.value instanceof java.util.Date) {
            return (java.util.Date) this.value;
        }
        throw new IllegalArgumentException("Not a valid java.util.Date object. object class=" + this.value.getClass().getName());
    }

    public Timestamp toTimestamp() {
        if (this.value == null) {
            return null;
        }
        if (this.value instanceof Timestamp) {
            return (Timestamp) this.value;
        } else if (this.value instanceof Date) {
            Date date = (Date) this.value;
            return new Timestamp(date.getTime());
        } else if (this.value instanceof java.util.Date) {
            java.util.Date date = (java.util.Date) this.value;
            return new Timestamp(date.getTime());
        }
        throw new IllegalArgumentException("Not a valid Timestamp object. object class=" + this.value.getClass().getName());
    }

    public String toString() {
        if (this.value == null) {
            return null;
        }
        if (this.value instanceof String) {
            return (String) this.value;
        }
        return this.value.toString();
    }

    public Object toObject() {
        return this.value;
    }


}