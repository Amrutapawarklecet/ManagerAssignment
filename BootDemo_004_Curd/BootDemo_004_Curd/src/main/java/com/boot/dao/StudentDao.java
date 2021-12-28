package com.boot.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.entity.Student;

public interface StudentDao extends CrudRepository<Student, Integer>{

}
