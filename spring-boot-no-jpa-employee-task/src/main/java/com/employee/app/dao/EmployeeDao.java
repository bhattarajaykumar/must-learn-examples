package com.employee.app.dao;

import com.employee.app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class EmployeeDao {

    private static final Logger logger = Logger.getLogger(EmployeeDao.class.getName());

    private final Connection dbConnection;

    @Autowired
    public EmployeeDao(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public List<Employee> getAllEmployees(Optional<String> employeeNamePrefix, Optional<String> sortType) {
        logger.info("enter=getAllEmployees()");
        List<Employee> employees = new ArrayList<>();

        try {
            StringBuilder query = new StringBuilder("SELECT id, name FROM employee");

            // Add prefix filter
            if (employeeNamePrefix.isPresent()) {
                query.append(" WHERE name LIKE ?");
            }

            // Add sorting
            if (sortType.isPresent()) {
                query.append(" ORDER BY name ");
                if (sortType.get().equalsIgnoreCase("asc")) {
                    query.append("ASC");
                } else if (sortType.get().equalsIgnoreCase("desc")) {
                    query.append("DESC");
                }
            }

            PreparedStatement statement = dbConnection.prepareStatement(query.toString());

            // Set parameters if prefix is provided
            if (employeeNamePrefix.isPresent()) {
                statement.setString(1, employeeNamePrefix.get() + "%");
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                employees.add(new Employee(id, name));
            }
            logger.info("enter=getAllEmployees() status=success");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("enter=getAllEmployees() status=failed due to "+e.getMessage());
        }

        return employees;
    }
}
