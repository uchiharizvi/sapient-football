package com.sapient.football;

import com.sapient.football.model.response.Datum;
import com.sapient.football.model.response.EmployeeDetail;
import com.sapient.football.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {
    
    @Autowired
    private IService service;

    @GetMapping("v1/getEmployeeDetails/{employeeNumber}")
    public Datum getSpecificEmployeeDetails(@PathVariable("employeeNumber") Integer employeeNumber){

        return service.getEmployeeDetails(employeeNumber);
    }

    @GetMapping("v1/getEmployeeDetails/all")
    public EmployeeDetail getAllEmployeeDetails(){

        return service.getEmployeeDetails();
    }
}
