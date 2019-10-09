package com.schedulerClasses;

/****************************************************
 * 													
 * 	Aurthor Name S.Gopihand 
 * 
 *  Changes are there
 *  
 *  Birthday notification schedular												
 * 	
 * */




import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.birthdayRemainder.BirthdayRemainder;

public class SimpleTriggerExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		try{
			SchedulerFactory sf = new StdSchedulerFactory();
			
			Scheduler schedular = sf.getScheduler();
			
			JobDetail job = JobBuilder.newJob(BirthdayRemainder.class).withIdentity("dammy","group1").build();
			
			Date startTime = DateBuilder.nextGivenSecondDate(null,10);
			
			SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("FourTimesTrigger","group1").startAt(startTime)
									.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).withRepeatCount(4)).build();
				schedular.start();
				schedular.scheduleJob(job,trigger);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
