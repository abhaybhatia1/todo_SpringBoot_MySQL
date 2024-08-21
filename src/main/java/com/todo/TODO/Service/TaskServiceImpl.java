package com.todo.TODO.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.todo.TODO.DTO.TaskDTO;
import com.todo.TODO.Entity.Task;
import com.todo.TODO.Mapper.TaskMapper;
import com.todo.TODO.Repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	private TaskRepository taskRepository ;
	
	
	
	public TaskServiceImpl(TaskRepository taskRepository) {

		this.taskRepository = taskRepository;
	}

	@Override
	public TaskDTO create(TaskDTO taskDTO) {
		Task task = TaskMapper.MapToTask(taskDTO);
		Task savedTask = taskRepository.save(task);
		TaskDTO savedTaskDTO = TaskMapper.MapToTaskDTO(savedTask);
		return savedTaskDTO;
	}

	@Override
	public TaskDTO read(Long Id) {
		Task taskDTO = taskRepository.findById(Id).orElseThrow(()-> new RuntimeException("Task Dosnot exists "));
		return TaskMapper.MapToTaskDTO(taskDTO);
	}

	@Override
	public TaskDTO update(Long Id, String s) {
		// TODO Auto-generated method stub
		Task taskDTO = taskRepository.findById(Id).orElseThrow(()-> new RuntimeException("Task Dosnot exists "));
		
		taskDTO.setTodo(s);
		taskRepository.save(taskDTO);
		return TaskMapper.MapToTaskDTO(taskDTO);
	}

	@Override
	public String delete(Long Id) {
		// TODO Auto-generated method stub
		Task task = taskRepository.findById(Id).orElseThrow(()-> new RuntimeException("Task Doesnot exists"));
		taskRepository.deleteById(Id);
		return "Deleted Task Successfully !!!";
	}

	@Override
	public List<TaskDTO> getAllTasks() {
		List<Task> task = taskRepository.findAll();
		List<TaskDTO> taskDTO= task.stream().map((i)-> TaskMapper.MapToTaskDTO(i)).collect(Collectors.toList());
		
		return taskDTO;
	}

	
}
