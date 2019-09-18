package com.dbserver.desafioRastaurante.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Integer getSemanaDoAno(Date instance) {

		if (Validator.has(instance)) {
			SimpleDateFormat simpleDateformat = new SimpleDateFormat("dd/MM/yyyy");
			simpleDateformat.format(instance);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(instance);
			return calendar.get(Calendar.WEEK_OF_YEAR);
		}
		return null;
	}
}
