package com.nur.dtos;

import java.util.Date;

public class ReserveDTO {
    public String id;
    public Date dateIn;
    public Date dateOut;
    public String details;

    public ReserveDTO() {
    }

    public ReserveDTO(String id, Date dateIn, Date dateOut, String details) {
        this.id = id;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public String getDetails() {
        return details;
    }
}
