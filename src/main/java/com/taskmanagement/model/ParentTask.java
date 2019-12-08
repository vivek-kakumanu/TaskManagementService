package com.taskmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parent_table")
public class ParentTask {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "parent_Id")
	private Long parentId;
	
	@Column(name = "parent_task")
	private String parentTask;
	
	@OneToOne(mappedBy="parentTask")
    Task task = new Task();
	
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getParentTask() {
		return parentTask;
	}
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	public ParentTask(String parentTask) {
		super();
		this.parentTask = parentTask;
	}
	public ParentTask() {
		super();
		// TODO Auto-generated constructor stub
	}
}
