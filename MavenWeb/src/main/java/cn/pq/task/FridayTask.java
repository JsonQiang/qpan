package cn.pq.task;

import cn.pq.task.abs.SynAbstractScheduleTask;

public class FridayTask extends SynAbstractScheduleTask {

	@Override
	public void ExecuteProxy() throws Exception {
		System.err.println("放假啦!");
	}

}
