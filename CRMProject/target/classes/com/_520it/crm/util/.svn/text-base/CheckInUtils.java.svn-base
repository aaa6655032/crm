package com._520it.crm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CheckInUtils {

	/**
	 * 判断正常的签到时间
	 * @param date
	 * @return
	 */
	public static int checkSignInTime(Date date) {
		Calendar normalSignInTime = Calendar.getInstance(); // 设置当前的正常签到时间
		normalSignInTime.setTime(date);
		normalSignInTime.set(Calendar.HOUR_OF_DAY, 8);
		normalSignInTime.set(Calendar.MINUTE, 30);
		normalSignInTime.set(Calendar.SECOND, 0);
		int result = date.compareTo(normalSignInTime.getTime());
		return result;
	}
	
	/**
	 *  判断正常的签退时间
	 * @param date
	 * @return  
	 */
	public static int checkSignOutTime(Date date) {
		Calendar normalSignOutTime = Calendar.getInstance(); // 设置当前的正常签退时间
		normalSignOutTime.setTime(date);
		normalSignOutTime.set(Calendar.HOUR_OF_DAY, 17);
		normalSignOutTime.set(Calendar.MINUTE, 30);
		normalSignOutTime.set(Calendar.SECOND, 0);
		int result = date.compareTo(normalSignOutTime.getTime());
		return result;
	}
	
	

	
	
	
	
	
	
	
}
