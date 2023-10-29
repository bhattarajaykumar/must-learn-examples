package com.employee.app.controller;

import com.employee.app.dao.EmployeeDao;
import com.employee.app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/v1/rest/employee")
public class EmployeeController {

    private static final Logger logger = Logger.getLogger(EmployeeController.class.getName());

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeController(EmployeeDao employeeDAO) {
        this.employeeDao = employeeDAO;
    }

    @GetMapping("/getEmployeeDetails")
    @ResponseBody
    public ResponseEntity<List<Employee>> getEmployeeDetails(@RequestParam(value = "employeeNamePrefix", required = false) Optional<String> employeeNamePrefix,
                                                             @RequestParam(value = "sortType", required = false) Optional<String> sortType) {
        logger.info("enter=getEmployeeDetails()");
        List<Employee> empLIst = employeeDao.getAllEmployees(employeeNamePrefix, sortType);
        logger.info("exit=getEmployeeDetails()");
        return ResponseEntity.ok(empLIst);
    }

}
