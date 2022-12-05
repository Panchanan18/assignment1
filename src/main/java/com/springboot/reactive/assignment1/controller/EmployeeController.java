package com.springboot.reactive.assignment1.controller;

import com.springboot.reactive.assignment1.entity.EmpSkill;
import com.springboot.reactive.assignment1.entity.EmployeeRequest;
import com.springboot.reactive.assignment1.entity.EmployeeResponse;
import com.springboot.reactive.assignment1.entity.ExpRequest;
import com.springboot.reactive.assignment1.service.EmployeeServices;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping("/createEmployee")
    public Mono<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest){

        return this.employeeServices.createEmployee(employeeRequest);
    }

    @GetMapping("/findEmpSkillSet")
    public Flux<EmployeeRequest> findGreaterThanJavaExp(@RequestBody ExpRequest expRequest){
        return this.employeeServices.findGreaterThanJavaExp(expRequest);
    }
    @GetMapping("/findEmpSkillSet/{javaExp}")
    public Flux<EmployeeRequest> findEmpWithExp(@PathVariable("javaExp") double javaExp){
        return this.employeeServices.findEmpWithExp(javaExp);
    }
}
