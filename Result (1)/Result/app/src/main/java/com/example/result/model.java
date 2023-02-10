package com.example.result;

public class model
{
  String NAME,ROLL_NO,MARKS,SEM,SUBJECT,TOTAL_MARKS,MIN_MARKS,SESSIONAL;

    public model(String NAME, String ROLL_NO, String MARKS,String SEM,String SUBJECT,String TOTAL_MARKS,String MIN_MARKS,String SESSIONAL) {
        this.NAME =NAME ;
        this.ROLL_NO = ROLL_NO;
        this.MARKS = MARKS;
        this.SEM =SEM ;
        this.SUBJECT = SUBJECT;
        this.TOTAL_MARKS = TOTAL_MARKS;
        this.MIN_MARKS = MIN_MARKS;
        this.SESSIONAL = SESSIONAL;

    }

    public String getName() {
        return NAME;
    }

    public void setName(String NAME) {
        this.NAME = NAME;
    }

    public String getContact() { return ROLL_NO; }

    public void setContact(String ROLL_NO) {
        this.ROLL_NO = ROLL_NO; }

    public String getEmail() {
        return MARKS;
    }

    public void setEmail(String MARKS) {
        this.MARKS = MARKS;
    }

    public String getSem() {
        return SEM;
    }

    public void setSem(String SEM) {
        this.SEM = SEM;
    }

    public String getSub() { return SUBJECT; }

    public void setSub(String SUBJECT) { this.SUBJECT = SUBJECT; }

    public String getTotal() {
        return TOTAL_MARKS;
    }

    public void setTotal(String TOTAL_MARKS) {
        this.TOTAL_MARKS = TOTAL_MARKS;
    }

    public String getMin() {
        return MIN_MARKS;
    }

    public void setMin(String MIN_MARKS) {
        this.MIN_MARKS = MIN_MARKS;
    }
    public String getSessional() {
        return SESSIONAL;
    }

    public void setSessional(String SESSIONAL) {
        this.SESSIONAL = SESSIONAL;
    }
}
