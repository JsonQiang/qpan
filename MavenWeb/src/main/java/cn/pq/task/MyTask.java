package cn.pq.task;

import org.springframework.stereotype.Component;

import cn.pq.task.abs.SynAbstractScheduleTask;

@Component
public class MyTask  extends SynAbstractScheduleTask{

	@Override
	public void ExecuteProxy() throws Exception {
		System.out.println("wake up!");
	}

}
