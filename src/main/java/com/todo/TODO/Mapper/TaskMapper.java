package com.todo.TODO.Mapper;

import com.todo.TODO.DTO.TaskDTO;
import com.todo.TODO.Entity.Task;

public class TaskMapper {
	public static Task MapToTask(TaskDTO taskDTO) {
		Task task = new Task(
				taskDTO.getId(),
				taskDTO.getTodo()
				);
		
		return task;
		
	}
	
	public static TaskDTO MapToTaskDTO(Task task) {
		TaskDTO taskDTO = new TaskDTO(
				task.getId(),
				task.getTodo()
				);
		
		return taskDTO;
		
	}
}
