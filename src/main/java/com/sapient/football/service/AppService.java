package com.sapient.football.service;

import com.sapient.football.exception.NoDataAvailableException;
import com.sapient.football.model.response.Datum;
import com.sapient.football.model.response.EmployeeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.NoSuchElementException;

@Service
public class AppService implements IService {
    @Autowired
    private RestTemplate template;

    @Override
    public Datum getEmployeeDetails(Integer employeeNumber) {
        ResponseEntity<EmployeeDetail> response = template.getForEntity("http://dummy.restapiexample.com/api/v1/employees", EmployeeDetail.class);
        Datum dataResponse = new Datum();
        try {
            dataResponse = response.getBody().getData().stream().filter(
                    e -> Integer.valueOf(e.getId()) == employeeNumber)
                    .findAny().get();
        }catch (NoSuchElementException e){
            throw new NoDataAvailableException("Invalid Employee Number");
        }
        return dataResponse;

    }

    @Override
    public EmployeeDetail getEmployeeDetails() {
        ResponseEntity<EmployeeDetail> response = template.getForEntity("http://dummy.restapiexample.com/api/v1/employees", EmployeeDetail.class);

        return response.getBody();
    }
}
