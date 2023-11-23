package com.afpa.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afpa.webapp.model.Employee;
import com.afpa.webapp.repository.EmployeeProxy;

import lombok.Data;

@Data
@Service
public class EmployeeService {

    @Autowired
    private static EmployeeProxy employeeProxy;

    public Employee getEmployee(final int id) {
        return employeeProxy.getEmployee(id);
    }

    public static Iterable<Employee> getEmployees() {
        return employeeProxy.getEmployees();
    }

    public static void deleteEmployee(final int id) {
        employeeProxy.deleteEmployee(id);;
    }

     public static Employee saveEmployee(Employee employee) {
        Employee savedEmployee;

        // Règle de gestion : Le nom de famille doit être mis en majuscule.
        employee.setNom(employee.getNom().toUpperCase());

        if(employee.getId() == null) {
            // Si l'id est nul, alors c'est un nouvel employé.
            savedEmployee = employeeProxy.createEmployee(employee);
        } else {
            savedEmployee = employeeProxy.updateEmployee(employee);
        }
    
        return savedEmployee;
    }
}
