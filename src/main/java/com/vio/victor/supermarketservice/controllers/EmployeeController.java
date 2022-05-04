package com.vio.victor.supermarketservice.controllers;

import com.vio.victor.supermarketservice.models.entities.Employee;
import com.vio.victor.supermarketservice.services.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")

public class EmployeeController extends AbstractController<Employee, EmployeeService>{
}
