package com.marlabs.tutorial.springboot;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	//Http Get method to get the employee list in JSON format
    @GetMapping(path="/", produces = "application/json")
    public EmployeePojo getEmployeeList()
    {
        return employeeDao.getAllEmployees();
    }
    
    //Http Post method to add the employee in the employee list
    
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public EmployeePojo addEmployeeList(@RequestBody EmployeePojo  employee)
    {
        /*Integer empId = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
        employee.setEmpId(empId);
         
        employeeDao.addEmployee(employee);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{empId}")
                                    .buildAndExpand(employee.getEmpId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();*/
    	System.out.println(employee.getEmpId());
    	System.out.println(employee.getEmpName());
    	System.out.println(employee.getEmpAge());
    	 return employeeDao.getAllEmployees();
    }
    /*
  //creating a get mapping that retrieves the detail of a specific book  
    @GetMapping("/book/{bookid}")  
    private Books getBooks(@PathVariable("bookid") int bookid)   
    {  
    return booksService.getBooksById(bookid);  
    }  
    //creating a delete mapping that deletes a specified book  
    @DeleteMapping("/book/{bookid}")  
    private void deleteBook(@PathVariable("bookid") int bookid)   
    {  
    booksService.delete(bookid);  
    }  
    //creating post mapping that post the book detail in the database  
    @PostMapping("/books")  
    private int saveBook(@RequestBody Books books)   
    {  
    booksService.saveOrUpdate(books);  
    return books.getBookid();  
    }  
    //creating put mapping that updates the book detail   
    @PutMapping("/books")  
    private Books update(@RequestBody Books books)   
    {  
    booksService.saveOrUpdate(books);  
    return books;  
    }  
    }  
    */

}
