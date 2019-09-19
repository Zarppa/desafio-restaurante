package com.dbserver.desafioRastaurante.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import com.dbserver.desafioRastaurante.util.CalendarUtil;

public class CalendarUtilTest {

	private Calendar calendar;

	@Before
	public void init() {
		calendar = new GregorianCalendar();
	}

	@Test
	public void truncateHappyPath() {
		Calendar c = calendar;
		c.set(2015, Calendar.MONTH, 01);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		assertEquals(c, CalendarUtil.truncate(calendar));
	}

	@Test(expected = NullPointerException.class)
	public void truncatedDateNull() {
		assertNull(CalendarUtil.truncate(null));
	}

}

