package com.example.student_mgmt;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RequestMapping("/students")
public class studentController {
	private studenServices studenServices;
	public studentController(studenServices studenServices) {
		// TODO Auto-generated constructor stub
		this.studenServices=studenServices;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody student student) {
		
		studenServices.save(student);
	}
	@GetMapping("/{id}")
	public Optional<student> get(@PathVariable Integer id) {
		return studenServices.find(id); 
	}
	@GetMapping
	public List<student> findAll(){
		return studenServices.findAll();
	}

	@PutMapping("/{id}")
	public void update(@PathVariable Integer id,@RequestBody student s) {
		studenServices.update(id, s);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		studenServices.delete(id); 
	}
	
}
