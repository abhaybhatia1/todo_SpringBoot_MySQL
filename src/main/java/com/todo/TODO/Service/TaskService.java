package com.todo.TODO.Service;

import java.util.List;

import com.todo.TODO.DTO.TaskDTO;

public interface TaskService {
	TaskDTO create(TaskDTO taskDTO);
	
	TaskDTO read(Long Id);
	
	TaskDTO update(Long Id,String s);
	
	String delete(Long Id);
	
	List<TaskDTO> getAllTasks();
}
