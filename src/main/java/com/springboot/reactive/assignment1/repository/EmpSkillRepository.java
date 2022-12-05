package com.springboot.reactive.assignment1.repository;

import com.springboot.reactive.assignment1.entity.EmpSkill;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmpSkillRepository extends ReactiveCassandraRepository<EmpSkill, Integer> {

    @AllowFiltering
    Flux<EmpSkill>  findByjavaExpGreaterThan(double javaExp);
    @AllowFiltering
    Flux<EmpSkill>  findByspringExpGreaterThan(double javaExp);
//    @AllowFiltering
//    @Query("select emp from emp_skill emp  where emp.java_exp > ?1 AND emp.spring_exp > ?2")
//    Flux<EmpSkill> findByjavaExpAndspringExpGreaterThan(double javaExp, double springExp);



}
