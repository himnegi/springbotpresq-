package com.employecrud.employetable.repsository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.employecrud.employetable.entity.EmployeEntity;
@Repository

public interface EmployeRepository extends JpaRepository<EmployeEntity, Integer>{

	
	
	
	
	
	
}


