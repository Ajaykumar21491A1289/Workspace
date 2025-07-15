package com.jocata.PanService.form;

import com.jocata.PanService.entity.PanDetails;

import java.sql.Timestamp;

public class PanDetailsResForm {

    private PanDetails details;
    private String status;
    private String message;
    private Timestamp timestamp;

    public PanDetailsResForm(PanDetails details, String status, String message, Timestamp timestamp) {
        this.details = details;
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public PanDetails getDetails() {
        return details;
    }

    public void setDetails(PanDetails details) {
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
