package com.taskmanagement.restservice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.dao.TaskDaoImpl;
import com.taskmanagement.model.Task;




@RestController
@RequestMapping("/taskmanagementservice")
public class TaskManagementRestfulService {

	@Autowired
	private TaskDaoImpl taskDaoImpl;
	
	
	@PostMapping(value = "/addtask", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Task addTask(@Valid @RequestBody Task task) {

		return taskDaoImpl.addTask(task);
	}

	@PutMapping(value = "/updatetask", produces = MediaType.APPLICATION_JSON_VALUE)
	public Task updateTask(@Valid @RequestBody Task task) {
		
		return taskDaoImpl.updateTask(task);
	}

	@GetMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Task> getTasks() {
		
		List<Task> taskList = new ArrayList<Task>();
		taskList = taskDaoImpl.getTasks();
		return taskList;
	}
}
