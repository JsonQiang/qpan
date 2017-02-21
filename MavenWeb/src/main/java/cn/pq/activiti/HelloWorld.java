package cn.pq.activiti;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloWorld {
	public static void main(String[] args) {
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("===========================");
		System.out.println(ac.getBean("processEngine"));
		RepositoryService repositoryService = (RepositoryService)ac.getBean("repositoryService");
		RuntimeService runtimeService = (RuntimeService)ac.getBean("runtimeService");
		TaskService taskService = (TaskService)ac.getBean("taskService");
		Deployment deploy = repositoryService.createDeployment().addClasspathResource("diagram/leaveProcess.bpmn").deploy();
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();
		runtimeService.startProcessInstanceById(processDefinition.getId());
		Task task = taskService.createTaskQuery().processDefinitionId(processDefinition.getId()).taskAssignee("张三").singleResult();
		taskService.complete(task.getId());
		Task task2 = taskService.createTaskQuery().deploymentId(deploy.getId()).singleResult();
		System.out.println(task2.getAssignee());
	}
}
