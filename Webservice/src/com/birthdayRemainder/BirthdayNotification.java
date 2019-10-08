package com.birthdayRemainder;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.BufferedReader;
import java.io.FileReader;



public class BirthdayNotification {

	SystemTray tray = SystemTray.getSystemTray();
	public void displayNotification(String name) throws AWTException{
	try{
		String currentDir = System.getProperty("user.dir");
		String imagePath = currentDir+"\\WebContent\\WEB-INF\\images\\1.jpg";
		
		System.out.println(imagePath);
		Image image = Toolkit.getDefaultToolkit().createImage(imagePath);
		TrayIcon trayIcon =
	            new TrayIcon(image,"sdfnds");
		trayIcon.setImageAutoSize(true);
		trayIcon.setToolTip("System tray icon demo");
		tray.add(trayIcon);
		trayIcon.displayMessage("Birthday Remainder",name, MessageType.INFO);
		}
	catch(Exception ex){
		ex.printStackTrace();
	}
	finally{
		System.exit(1);
	}
	}
	
}
