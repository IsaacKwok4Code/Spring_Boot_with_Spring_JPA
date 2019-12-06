package com.yin4learn.springboot.jpa.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yin4learn.springboot.jpa.demo.entity.Employee;
import com.yin4learn.springboot.jpa.demo.dao.EmployeeRespository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRespository employeeRespository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRespository theEmployeeRespository) {
		employeeRespository = theEmployeeRespository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRespository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRespository.findById(theId);
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRespository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRespository.deleteById(theId);
	}

}
