package com.todo.TODO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.TODO.Entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{
	
	
}
