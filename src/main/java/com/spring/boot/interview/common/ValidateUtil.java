package com.spring.boot.interview.common;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.spring.boot.interview.enums.SexoEnum;

public class ValidateUtil implements Serializable {

	private static final long serialVersionUID = 7261616882217589397L;

	public static boolean isEmptyOrNull(String text) {
		if (text == null || text == "") {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isEmptyOrNull(Object obj) {
		if (obj == null) {
			return true;
		} else {
			return false;
		}
	}

	public static Date stringToDate(String date) {
		Date exit = null;
		try {
			exit = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return exit;
	}

	public static SexoEnum stringToSexoEnum(String sexo) {
		return SexoEnum.get(sexo);
	}

}
