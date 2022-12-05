package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Employee;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.impl.EmployeeServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/save")
    public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody Employee employee) {
        EmployeeEntity employeeEntity = employeeServiceImpl.saveEmployee(employee);
        return ResponseEntity.ok(employeeEntity);
    }

    @GetMapping("/get/table/{tableName}/column/{column}/email/{email}")
    public List<Map<String, Object>> getDetails(@PathVariable("tableName") String tableName, @PathVariable("column") String column, @PathVariable("email") String email) {
        String sql = "select * from " + tableName + " where " + column + " = " + email;
        String sql1 = "select * from %s where %s = '%s'";
        String formatter = String.format(sql1, tableName, column, email);
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        List<Map<String, Object>> maps1 = jdbcTemplate.queryForList(formatter);
        String updateQuery = "update %s set first_Name='Kunwar' where %s = '%s'";
        String formatter1 = String.format(updateQuery, tableName, column, email);
        int update = jdbcTemplate.update(formatter1);
        return maps1;
    }

    public String prepareColumnValueForDatabaseCall(String value) {
        return value;
    }

}
