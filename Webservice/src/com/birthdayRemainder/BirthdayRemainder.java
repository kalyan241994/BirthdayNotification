package com.birthdayRemainder;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class BirthdayRemainder implements Job {

	public void execute(JobExecutionContext context) {

		int linecounter = 0;
		int currentcounter=1;
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/YYYY");
		Date todaysDate = new Date();
		String currentDate = date.format(todaysDate);
		String currentDir = System.getProperty("user.dir");
		BufferedReader buff = null;
		try {
			buff = new BufferedReader(new FileReader(currentDir + "\\gopi.txt"));
			String line = buff.readLine();
			while (line != null) {
				linecounter++;
				line = buff.readLine();
				
				if (line == null) {
					break;
				}
				String[] a = line.split(" ");
				if (a[0] != null) {
	
					String mothName = new CurrentMonth().monthName(a[0]);
					if ((currentDate.equals(a[0])) && a[1].equalsIgnoreCase(mothName)) {
	
						System.out.println("Happy birthday " + a[2]);
						try{
							if(SystemTray.isSupported()){
								BirthdayNotification birth = new BirthdayNotification();
//								W2sms w2sms = new W2sms();
//								String message=w2sms.ConnectW2sms(a[3],a[2]);
//								System.out.println(message);
								birth.displayNotification(a[2]);
							}
						}
						catch(Exception ex){
							ex.printStackTrace();
						}
					}
					else{
						currentcounter++;
					}
				}
			}
			if(linecounter == currentcounter)
			{
				System.out.println("Today there is no birthday babies-)");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();

	}
		finally {
			try {
				buff.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
