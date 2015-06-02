package com.innominds.jdbc.model;

import java.io.Serializable;

public class ExamResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 215464919575956683L;
    private int id;
    private int subject1;
    private int subject2;
    private int subject3;
    private int subject4;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getSubject1() {
        return subject1;
    }

    public void setSubject1( int subject1 ) {
        this.subject1 = subject1;
    }

    public int getSubject2() {
        return subject2;
    }

    public void setSubject2( int subject2 ) {
        this.subject2 = subject2;
    }

    public int getSubject3() {
        return subject3;
    }

    public void setSubject3( int subject3 ) {
        this.subject3 = subject3;
    }

    public int getSubject4() {
        return subject4;
    }

    public void setSubject4( int subject4 ) {
        this.subject4 = subject4;
    }

    @Override
    public String toString() {
        return "ExamResult [id=" + id + ", subject1=" + subject1 + ", subject2=" + subject2 + ", subject3=" + subject3 + ", subject4=" + subject4
                + "]";
    }

}
