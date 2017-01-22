package cn.pq.task.abs;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public abstract class SynAbstractScheduleTask extends QuartzJobBean{

	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

			try {
				this.ExecuteProxy();
			} catch (Exception e) {
				JobExecutionException je = new JobExecutionException(e);
				throw je;
			}
		
	}

	public abstract void ExecuteProxy() throws Exception;
}
