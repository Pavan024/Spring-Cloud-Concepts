package com.springcloud.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;

@EnableTask
public class Test implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("welcome to " + args[0]);
	}

	@BeforeTask
	public void onTaskStartup(TaskExecution taskExecution) {
		System.out.println("TaskName : " + taskExecution.getTaskName() + "Execution Id : "
				+ taskExecution.getExecutionId() + "started...");

	}

	@AfterTask
	public void onTaskEnd(TaskExecution taskExecution) {
		System.out.println("TaskName : " + taskExecution.getTaskName() + "Execution Id : "
				+ taskExecution.getExecutionId() + "completed...");

	}

	@FailedTask
	public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
		System.out.println("TaskName : " + taskExecution.getTaskName() + "Execution Id : "
				+ taskExecution.getExecutionId() + "failed...");

	}

}
