package com.nur.factories.reserve;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Reserve;
import com.nur.model.StatusReserve;

import java.util.Date;

public interface IReserveFactory {
    Reserve createReserve(Date dateIn, Date dateOut, String details) throws BusinessRuleValidationException;
}
