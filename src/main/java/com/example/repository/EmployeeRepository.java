package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Employee;

/**
 * employeesテーブルを操作するリポジトリ.
 * 
 * @author igamasayuki
 * 
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {



	
	public Page<Employee> findAll(Pageable pageable);
	public List<Employee> findByName(String name);
	public Employee getById(Integer id);


}
