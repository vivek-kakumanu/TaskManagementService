package com.taskmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.taskmanagement.dao.TaskDaoImpl;
import com.taskmanagement.model.ParentTask;
import com.taskmanagement.model.Task;
import com.taskmanagement.restservice.TaskManagementRestfulService;


@SpringBootTest
class TaskManagementServiceApplicationTests {

	@InjectMocks
	TaskManagementRestfulService taskService;
     
    @Mock
    TaskDaoImpl taskDao;
     
    @Test
    public void testAddTask() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        Task task = new Task( new ParentTask("parentTask"),"taskname",20,new Date(), new Date(), false);
        when(taskDao.addTask(task)).thenReturn(task);
         
        
        try {
        	Task task1 = taskDao.addTask(task);
        	assertEquals(task, task1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("The exception is : " + e);
			e.printStackTrace();
		}
        
    }

}
