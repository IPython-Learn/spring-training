package com.innominds.jdbc.model;

import java.io.Serializable;

public class TargetTable implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2713615683740014497L;

    private int id;

    private int maxmumValue;

    private int sumofRow;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getMaxmumValue() {
        return maxmumValue;
    }

    public void setMaxmumValue( int maxmumValue ) {
        this.maxmumValue = maxmumValue;
    }

    public int getSumofRow() {
        return sumofRow;
    }

    public void setSumofRow( int sumofRow ) {
        this.sumofRow = sumofRow;
    }

    @Override
    public String toString() {
        return "TargetTable [id=" + id + ", maxmumValue=" + maxmumValue + ", sumofRow=" + sumofRow + "]";
    }

}
