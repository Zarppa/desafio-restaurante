package com.dbserver.desafioRastaurante.Util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {
	
	@Before
	public void init() {
	}

	@Test
	public void has_stringNull(){
		String str = null;
		assertFalse(Validator.has(str));
	}
	
	@Test
	public void has_stringEmpty(){
		String str = "";
		assertFalse(Validator.has(str));
	}
	
	@Test
	public void has_validString(){
		String str = "teste";
		assertTrue(Validator.has(str));
	}
	
	@Test
	public void has_shortNull(){
		Short srt = null;
		assertFalse(Validator.has(srt));
	}
	
	@Test
	public void has_shortZero(){
		Short srt = Short.valueOf("0");
		assertFalse(Validator.has(srt));
	}
	
	@Test
	public void has_negativeShort(){
		Short srt = Short.valueOf("-1");
		assertFalse(Validator.has(srt));
	}
	
	@Test
	public void has_validShort(){
		Short srt = Short.valueOf("2");
		assertTrue(Validator.has(srt));
	}
	
	@Test
	public void has_validInteger(){
		Integer value = Integer.valueOf(2);
		assertTrue(Validator.has(value));
	}
	
	@Test
	public void has_integerNull(){
		Integer value = null;
		assertFalse(Validator.has(value));
	}
	
	@Test
	public void has_booleanNull(){
		Boolean value = null;
		assertFalse(Validator.has(value));
	}
	
	@Test
	public void has_validBoolean(){
		Boolean value = Boolean.TRUE;
		assertTrue(Validator.has(value));
	}
	
	@Test
	public void has_listaNull(){
		List<String> value = null;
		assertFalse(Validator.has(value));
	}
	
	@Test
	public void has_listaEmpty(){
		List<String> value = new ArrayList<String>();
		assertFalse(Validator.has(value));
	}
	
	@Test
	public void has_listaValida(){
		List<String> value = new ArrayList<String>();
		value.add("teste");
		assertTrue(Validator.has(value));
	}
	
	
}
