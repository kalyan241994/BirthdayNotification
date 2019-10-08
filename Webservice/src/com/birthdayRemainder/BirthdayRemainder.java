package com.birthdayRemainder;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthdayRemainder {

	public static void main(String args[]) throws IOException, AWTException {

		SimpleDateFormat date = new SimpleDateFormat("dd/MM/YYYY");
		Date todaysDate = new Date();
		String currentDate = date.format(todaysDate);
		String currentDir = System.getProperty("user.dir");
		BufferedReader buff = new BufferedReader(new FileReader(currentDir + "\\gopi.txt"));

		String line = buff.readLine();
		try{	
			while (line != null) {
	
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
								birth.displayNotification(a[2]);
							}
						}
						catch(Exception ex){
							ex.printStackTrace();
						}
					}
					else{
						
					}
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			buff.close();
		}
		

	}
}
