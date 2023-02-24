package com.example.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Employee;

public interface PageEmployeeRepository extends JpaRepository<Employee ,Integer> {


}
