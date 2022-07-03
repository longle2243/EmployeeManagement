package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeSv;

@Component
public class EmployeeValidator implements Validator {
    @Autowired
    private EmployeeSv employeeService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Employee Employee = (Employee) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (Employee.getUsername().length() < 6 || Employee.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (employeeService.findByUsername(Employee.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (Employee.getPassword().length() < 8 || Employee.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!Employee.getPasswordConfirm().equals(Employee.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}