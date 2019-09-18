package com.dbserver.desafioRastaurante.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
	
	public static Calendar truncate(Calendar instance) {
        Calendar cal = instance;
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (Calendar) cal.clone();
    }
	
	public static Integer getSemanaDoAno(Date instance) {        
        
		String input = "20130507";
		String format = "dd/MM/yyyy hh:mm";

		SimpleDateFormat df = new SimpleDateFormat(format);
		Date date = df.parse(input);

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		
		
		return instance.get(Calendar.WEEK_OF_YEAR);
        
    }

}
