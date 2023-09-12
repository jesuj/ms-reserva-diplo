package com.nur.model;

import com.nur.core.BusinessRuleValidationException;
import com.nur.core.Entity;
import com.nur.valueObjects.DateValueObject;

import java.util.Date;
import java.util.UUID;

public class Reserve extends Entity {
    public Date dateIn;
    public Date dateOut;

    public StatusReserve status;
    public String details;

    public Date getDateIn() {
        return dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public String getDetails() {
        return details;
    }

    public StatusReserve getStatus() {
        return status;
    }


    public Reserve(Date dateIn, Date dateOut, String details) throws BusinessRuleValidationException {
        new DateValueObject(dateIn,dateOut);
        id = UUID.randomUUID();
        this.dateIn = dateIn;
        this.status = StatusReserve.RESERVE;
        this.dateOut = dateOut;
        this.details = details;
    }

    public Reserve(UUID id,Date dateIn, Date dateOut, String details) throws BusinessRuleValidationException {
        setId(id);
        this.dateIn = dateIn;
        this.status = StatusReserve.RESERVE;
        this.dateOut = dateOut;
        this.details = details;
    }



    public Reserve() {
    }
}
