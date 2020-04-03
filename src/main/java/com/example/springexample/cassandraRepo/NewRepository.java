package com.example.springexample.cassandraRepo;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.springexample.model.employee.Employee;

public interface NewRepository  extends CassandraRepository<Employee, Integer> {

}
