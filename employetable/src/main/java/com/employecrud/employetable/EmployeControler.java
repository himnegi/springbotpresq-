package com.employecrud.employetable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employecrud.employetable.entity.EmployeEntity;
import com.employecrud.employetable.repsository.EmployeRepository;

@RestController
@RequestMapping("/db")
public class EmployeControler {

	
	

	@Autowired
	EmployeRepository employeRepository;
	
	@GetMapping("/data")	
	public List<EmployeEntity> getAllEmploye(){
		List<EmployeEntity> allEmployeelist = employeRepository.findAll();
		return allEmployeelist;
		
	}

	@GetMapping("/data/{id}")
	public EmployeEntity getEmployeebyId(@PathVariable(value = "id") Integer employeeId)
      
	{
		EmployeEntity employeeEntity = employeRepository.findById(employeeId).get();
		
		return employeeEntity;	
	}
	
	 @PostMapping("/data")
	 
	    public EmployeEntity createEmployee(@RequestBody EmployeEntity employee) {
	       
	    	 EmployeEntity savedEmployee = employeRepository.save(employee);
	    	 
	    	 return savedEmployee;
	    }
	    
	@PutMapping("/data/{id}")
    public ResponseEntity<EmployeEntity> updateEmployee(@PathVariable(value = "id") Integer employeeId,
         @RequestBody EmployeEntity employeeDetails) {
        EmployeEntity employee = employeRepository.findById(employeeId).get();

        
        employee.setName(employeeDetails.getName());
        employee.setLocation(employeeDetails.getLocation());
        final EmployeEntity updatedEmployee = employeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
	
    @DeleteMapping("/data/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId)
    {
     EmployeEntity employee = employeRepository.findById(employeeId).get();

        employeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
