package com.todowebservice.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.todowebservice.demo.StaticData.TodoHardcodedService;
import com.todowebservice.demo.models.Todo;

//Controller
@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class TodoController {
	
	@Autowired
	private TodoHardcodedService todoService;
	
	//HelloWorld API
	@GetMapping(value = "/helloworld")
	@ResponseBody
	public String Helloworld() {
		System.out.println("This is first method");
		return "This is first Home view";
	}
	
	//API for calling all the To-do-s of a particular user
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return todoService.findAll();
	}
	
	//API for Deleting a to-do from the list of to do of a user
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
		
		Todo todo = todoService.deleteById(id);
		
		if(todo != null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	//API for updating a to-do from the lists of to-do-s of a user
		@GetMapping("/users/{username}/todos/{id}")
		public Todo getTodo(@PathVariable String username, @PathVariable long id){
			return todoService.findById(id);
		}
}
