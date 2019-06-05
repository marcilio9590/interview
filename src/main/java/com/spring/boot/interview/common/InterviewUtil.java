package com.spring.boot.interview.common;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.spring.boot.interview.enums.GenderEnum;
import com.spring.boot.interview.enums.StateEnum;

public class InterviewUtil implements Serializable {

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
			if (!isEmptyOrNull(date))
				exit = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return exit;
	}

	public static GenderEnum stringToSexoEnum(String sexo) {
		return GenderEnum.get(sexo);
	}

	public static boolean isStateValid(String state) {
		if (InterviewUtil.isEmptyOrNull(state) || InterviewUtil.isEmptyOrNull(StateEnum.get(state))) {
			return false;
		} else {
			return true;
		}
	}

	public static String dateToString(Date source) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(source);
	}

}
