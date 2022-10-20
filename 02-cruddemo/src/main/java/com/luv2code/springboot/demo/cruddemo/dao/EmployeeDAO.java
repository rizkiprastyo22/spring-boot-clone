package com.luv2code.springboot.demo.cruddemo.dao;

import com.luv2code.springboot.demo.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
}
