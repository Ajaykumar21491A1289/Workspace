package com.jocata.AdharCard.form;

import com.jocata.AdharCard.entity.PayLoad;

import java.sql.Timestamp;

public class AadharCardResForm {

    private PayLoad details;
    private String status;
    private String message;
    private Timestamp timestamp;

    public AadharCardResForm(PayLoad details, String status, String message, Timestamp timestamp) {
        this.details = details;
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public PayLoad getDetails() {
        return details;
    }

    public void setDetails(PayLoad details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


}
