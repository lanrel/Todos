package com.todowebservice.demo.StaticData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Service;

import com.todowebservice.demo.models.Todo;

@Service
public class TodoHardcodedService {
	
	private static List<Todo> todos = new ArrayList();
	private static int idCounter = 0;
	
	static{
		todos.add(new Todo(++idCounter, "Lanre", "Learn Java", 
				new Date(), false ));
		todos.add(new Todo(++idCounter, "Lanre", "Learn React", 
				new Date(), false ));
		todos.add(new Todo(++idCounter, "Lanre", "Learn Sql", 
				new Date(), false ));
		todos.add(new Todo(++idCounter, "Lanre", "Learn HTML", 
				new Date(), false ));
		todos.add(new Todo(++idCounter, "Lanre", "Learn CSS", 
				new Date(), false ));
		todos.add(new Todo(++idCounter, "Lanre", "Learn AWS", 
				new Date(), false ));
	}
	
	//Create findAll Method to find all the to-do-s for a user
	public List<Todo> findAll(){
		return todos;
	}
	
	//Method to delete a to-do for a user
	public Todo deleteById(long id){
		Todo todo = findById(id);
		if(todo==null) return null;
		
		if(todos.remove(todo)) {
			return todo;
		}
		return null;
		
	}

	public Todo findById(long id) {
		for(Todo todo: todos)
			if(todo.getId() == id) {
				return todo;
			}
		return null;
	}

}
