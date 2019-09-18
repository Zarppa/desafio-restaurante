package com.dbserver.desafioRastaurante.util;

import java.util.Calendar;

public class CalendarUtil {
	
	public static Calendar truncate(Calendar instance) {
        Calendar cal = instance;
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (Calendar) cal.clone();
    }
	
}
