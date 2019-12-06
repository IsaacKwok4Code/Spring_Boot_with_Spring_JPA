package com.yin4learn.springboot.jpa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yin4learn.springboot.jpa.demo.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
