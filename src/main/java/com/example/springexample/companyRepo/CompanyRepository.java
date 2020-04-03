package com.example.springexample.companyRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springexample.model.company.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
