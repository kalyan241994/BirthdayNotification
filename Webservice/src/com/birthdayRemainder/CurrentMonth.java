package com.birthdayRemainder;

import java.util.Date;

public class CurrentMonth implements Months {

	@Override
	public String monthName(String date) {
		
		String[] a= date.split("/");
		String[] months = {" ","Jan","Feb","March","Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"};
		int b = Integer.parseInt(a[1]);
		
		return months[b];
	}

}
