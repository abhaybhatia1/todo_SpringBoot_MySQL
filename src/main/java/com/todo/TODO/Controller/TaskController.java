package com.todo.TODO.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todo.TODO.DTO.TaskDTO;
import com.todo.TODO.Service.TaskService;

@RestController
@RequestMapping("/")
public class TaskController {
	
	private TaskService taskService;

	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}
	
	
	
	@PostMapping
	public ResponseEntity<TaskDTO> post(@RequestBody TaskDTO taskDTO){
		TaskDTO savedDTO = taskService.create(taskDTO);
		return new ResponseEntity<>(savedDTO,HttpStatus.CREATED);
	}
	
	
	@GetMapping("{Id}")
	public ResponseEntity<TaskDTO> getById(@PathVariable("Id") Long Id){
		TaskDTO taskDTO = taskService.read(Id);
		return ResponseEntity.ok(taskDTO);
	}
	
	@DeleteMapping("{Id}")
	public String deleteTask(@PathVariable("Id") Long Id) {
		String s = taskService.delete(Id);
		return s;
	}
	
	@GetMapping
	public ResponseEntity<List<TaskDTO>> getAll(){
		List<TaskDTO> tasks = taskService.getAllTasks();
		return ResponseEntity.ok(tasks);
	} 
	
	@PutMapping("{Id}")
	public ResponseEntity<TaskDTO> updateTask(@PathVariable("Id") Long Id,@RequestBody Map<String,String> s){
		TaskDTO taskDTO = taskService.update(Id, s.get("newTodo"));
		return ResponseEntity.ok(taskDTO);
	}
}
