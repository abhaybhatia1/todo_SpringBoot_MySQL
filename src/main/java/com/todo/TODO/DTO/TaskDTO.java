package com.todo.TODO.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class TaskDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long Id ;
	
	@Column
	private String todo;

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

	public TaskDTO(Long id, String todo) {
		super();
		Id = id;
		this.todo = todo;
	}
	
	
}
