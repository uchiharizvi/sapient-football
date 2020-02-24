package com.sapient.football.service;

import com.sapient.football.model.response.Datum;
import com.sapient.football.model.response.EmployeeDetail;

public interface IService {

    Datum getEmployeeDetails(Integer jsonRequest);
    EmployeeDetail getEmployeeDetails();
}
