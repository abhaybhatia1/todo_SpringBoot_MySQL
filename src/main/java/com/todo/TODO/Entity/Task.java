package com.todo.TODO.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Todos")
public class Task {
	
	
	public Task() {
		super();
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long Id ;
	
	
	public Task(Long id, String todo) {
		super();
		Id = id;
		this.todo = todo;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getTodo() {
		return todo;
	}


	public void setTodo(String todo) {
		this.todo = todo;
	}


	@Column
	private String todo;
	
}
