package com.afpa.webapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.afpa.webapp.CustomProperties;
import com.afpa.webapp.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmployeeProxy {
    @Autowired
    private CustomProperties props;

    public Iterable<Employee> getEmployees(int id) {
        String baseApiUrl = props.getApiUrl();
        String getEmployeesUrl = baseApiUrl + "/employees";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Employee>> response = restTemplate.exchange(
                getEmployeesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Employee>>() {}
                );

        log.debug("Get Employees call " + response.getStatusCode().toString());
        
        return response.getBody();
    }

    public Employee createEmployee(Employee e) {
        String baseApiUrl = props.getApiUrl();
        String createEmployeeUrl = baseApiUrl + "/employee";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request = new HttpEntity<Employee>(e);
        ResponseEntity<Employee> response = restTemplate.exchange(
            createEmployeeUrl,
            HttpMethod.POST,
            request,
            Employee.class);

        log.debug("Create Employee call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public void deleteEmployee(int id) {
    }

    public Employee updateEmployee(Employee employee) {
        return null;
    }

    public Iterable<Employee> getEmployees() {
        return null;
    }

    public Employee getEmployee(int id) {
        return null;
    }

}
