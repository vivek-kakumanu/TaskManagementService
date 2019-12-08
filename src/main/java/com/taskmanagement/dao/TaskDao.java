package com.taskmanagement.dao;

import java.util.List;

import com.taskmanagement.model.Task;

public interface TaskDao {
	
	// Method to add task
	public Task addTask(Task task);
	
	// Method to update task
	public Task updateTask(Task task);
	
	// Method to get tasks list from the database
	public List<Task> getTasks();
	
	// Method to get task
	public Task getTask(int id);

}
