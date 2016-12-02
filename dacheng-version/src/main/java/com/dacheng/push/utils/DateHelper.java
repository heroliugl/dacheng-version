package com.dacheng.push.utils;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class DateHelper {

	private static final Calendar min = new GregorianCalendar(1970,Calendar.JANUARY,1,0,0,0);

	private static final Calendar max = new GregorianCalendar(9999,Calendar.DECEMBER,31,23,59,59);

	private static Calendar currentTime;

	public static void setCurrentDateTime(Calendar currentDateTime) {
		currentTime = currentDateTime;
	}

	public static Calendar getCurrentDateTime()	{
		if (currentTime != null) {
            return currentTime;
        }
	    return Calendar.getInstance();
	}

	public static Calendar getMin(){
        Calendar calendar = clone(min);
        return calendar;
	}

    public static Calendar getMax(){
        Calendar calendar = clone(max);
        return calendar;
    }

    public static Calendar getStartOfCurrent(){
    	return getStartOf(getCurrentDateTime());
    }

    public static Calendar getEndOfCurrent(){
    	return getEndOf(getCurrentDateTime());
    }
    
    public static Calendar getLastDueDay(Calendar calendar,Integer tenor){
    	calendar.add(Calendar.MONTH, tenor);
    	return calendar;
    }
    
    public static Calendar getLastDueDay1(Calendar calendar,Integer day){
    	calendar.add(Calendar.DATE, day);
    	return calendar;
    }
    
    public static Calendar getExtensionMonth(Calendar calendar){
    	calendar.add(Calendar.MONTH, -1);
    	return calendar;
    }
    
    public static Calendar getTodayOfNextMonth(Calendar calendar){
    	calendar.add(Calendar.MONTH, 1);
    	return calendar;
    }
    

    public static Calendar getEndOfMonth(Calendar calendar){
    	calendar.set(Calendar.DATE, 1);
    	calendar.add(Calendar.MONTH, 1);
    	calendar.add(Calendar.DATE, -1);
    	return calendar;
    }
    public static Calendar getStartOf(final Calendar calendar){
        return new GregorianCalendar(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static Calendar getEndOf(final Calendar calendar){
        return new GregorianCalendar(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH),
            23, 59, 59);
    }
    
//    public static void main(String[] args) {
//    	Calendar c = Calendar.getInstance();
//    	SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
//    	try {
//			c.setTime(sdf.parse("2014-09-12"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//    	Calendar calendar = DateHelper.getEndOf(c);
//    	System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
//    	System.out.println("YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR)); 
//    	1.// 在具有默认语言环境的默认时区内使用当前时间构造一个默认的 GregorianCalendar  
//    	2.    Calendar calendar = new GregorianCalendar();  
//    	3.      
//    	4.// 创建一个Date  
//    	5.    Date trialTime = new Date();  
//    	6.      
//    	7.// 看看当前的trialTime  
//    	8.    System.out.println("Date : " + trialTime);  
//    	9.      
//    	10.// 使用给定的 Date 设置此 Calendar 的时间。  
//    	11.    calendar.setTime(trialTime); 
//    	12.
//    	13.// 这个就是输出年  
//    	14.    System.out.println("YEAR: " + calendar.get(Calendar.YEAR));  
//    	15.      
//    	16.// 这是一个特定于日历的值。一年中的第一个月是 JANUARY，它为 0；最后一个月取决于一年中的月份数。  
//    	17.      
//    	18.// 所以依次类推，输出月要+1，不然结果不是想要的效果  
//    	19.    System.out.println("MONTH: " + calendar.get(Calendar.MONTH + 1));  
//    	20.      
//    	21.// 指示当前年中的星期数  
//    	22.    System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));  
//    	23.      
//    	24.// 指示当前月中的星期数  
//    	25.    System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));  
//    	26.      
//    	27.// 查看是几号  
//    	28.    System.out.println("DATE: " + calendar.get(Calendar.DATE));  
//    	29.      
//    	30.// 当前月的第几天  
//    	31.    System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));  
//    	32.      
//    	33.// 当前年的第几天  
//    	34.    System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));  
//    	35.      
//    	36.// 指示一个星期中的某天  
//    	37.    System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));  
//    	38.      
//    	39.// 当前天在这个月的第几个星期  
//    	40.    System.out.println("DAY_OF_WEEK_IN_MONTH: " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));  
//    	41.      
//    	42.// 判断是AM还是PM 中午之前还是在中午之后。，如果输出0是AM 上午，如果输出1是PM下午  
//    	43.    System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));  
//    	44.      
//    	45.// HOUR 用于 12 小时制时钟 ，假设现在上下午3点，则输出3  
//    	46.    System.out.println("HOUR: " + calendar.get(Calendar.HOUR));  
//    	47.      
//    	48.// 输出当前小时在这天的值，假设现在是下午3点，则输出15  
//    	49.    System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));  
//    	50.      
//    	51.// 输出分钟  
//    	52.    System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));  
//    	53.      
//    	54.// 输出秒  
//    	55.    System.out.println("SECOND: " + calendar.get(Calendar.SECOND));  
//    	56.      
//    	57.// 输出毫秒  
//    	58.    System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));  
//    	59.      
//    	60.// 以毫秒为单位指示距 GMT 的大致偏移量。  
//    	61.    System.out.println("ZONE_OFFSET: "  
//    	62.        + (calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000)));  
//    	63.      
//    	64.// 以毫秒为单位指示夏令时的偏移量。  
//    	65.    System.out.println("DST_OFFSET: " + (calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000)));  
//    }

    public static Calendar getFirstDateOfMonth(Calendar calendar){
    	Calendar dateTime = getCurrentDateTime();
    	dateTime.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
    	dateTime.set(Calendar.MONTH, calendar.get(Calendar.MONDAY));
    	dateTime.set(Calendar.DAY_OF_MONTH, 1);
    	dateTime.set(Calendar.HOUR_OF_DAY, 0);
    	dateTime.set(Calendar.MINUTE, 0);
    	dateTime.set(Calendar.SECOND, 0);
    	dateTime.set(Calendar.MILLISECOND, 0);
    	return dateTime;
    }

    public static Calendar getPreviousSunday(Calendar clandar){
    	int dayOfWeek = clandar.get(Calendar.DAY_OF_WEEK);
//    	String str = toString(clandar, datePattern);
    	int offsetDay = 0;
    	if(dayOfWeek==1){
    		offsetDay = 7;
    	}else{
    		offsetDay = dayOfWeek-1;
    	}
    	Calendar clone = (Calendar)clandar.clone();
    	clone.add(Calendar.DAY_OF_MONTH, -offsetDay);
    	return clone;
    }

    public static Calendar getNextDayStartOf(final Calendar date){
        Calendar calendar = clone(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        return getStartOf(calendar);
    }

    public static Calendar getNextDayStart(){
        return getNextDayStartOf(DateHelper.getCurrentDateTime());
    }

    public static Calendar clone(final Calendar date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date.getTime());
        return calendar;
    }

    public static Calendar getPreviousDayEndOf(final Calendar date){
        Calendar calendar = clone(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return getEndOf(calendar);
    }

    /**
     * yyyy-MM-dd
     */
	public static final String datePattern = "yyyy-MM-dd";
	/**
	 * yyyyMMdd
	 */
	public static final String datePattern2 = "yyyyMMdd";
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static final String dateMinutePattern = "yyyy-MM-dd HH:mm";
	/**
	 * yyyy-MM
	 */
	public static final String dateMonthPattern = "yyyy-MM";
	/**
	 * yyyyMM
	 */
	public static final String dateMonthPattern2 = "yyyyMM";
	/**
	 * yyyyMMdd HHmmss
	 */
	public static final String dateTimePattern2 = "yyyyMMdd HHmmss";
	/**
	 * yyyyMMddHHmmss
	 */
	public static final String dateTimePattern3 = "yyyyMMddHHmmss";
	/**
	 * yyyy-MM-dd HH:mm:ss:SSS
	 */
	public static final String dateTimePattern4 = "yyyy-MM-dd HH:mm:ss:SSS";
	/**
     * yyyyMMddHHmmssSSS
     */
    public static final String dateTimePattern5 = "yyyyMMddHHmmssSSS";
    /**
	 * yyyyMMddHHmm
	 */
	public static final String dateTimePattern6 = "yyyyMMddHHmm";
	/**
	 * HH:mm:ss
	 */
	public static final String timePattern = "HH:mm:ss";
	/**
	 * HH:mm
	 */
	public static final String hourMinutesPattern = "HH:mm";
	public static final String MonthAndDatePattern = "MMdd";

	public static String toTimeString(Calendar calendar){
		return toDateString(calendar, timePattern);
	}


	public static String toHourMinutesPattern(Calendar calendar){
		return toDateString(calendar, hourMinutesPattern);
	}

	public static String toDateString(Calendar calendar){
		return toDateString(calendar, datePattern);
	}

	public static String toDateString2(Calendar calendar){
		return toDateString(calendar, datePattern2);
	}
	public static String toDateTimeString(Calendar calendar){
		return toDateString(calendar, dateTimePattern);
	}
	public static String toDateTimeString2(Calendar calendar){
		return toDateString(calendar, dateTimePattern2);
	}
	public static String toDateTimeString3(Calendar calendar) {
        return toDateString(calendar, dateTimePattern3);
    }
	public static String toDateTimeString4(Calendar calendar) {
        return toDateString(calendar, dateTimePattern4);
    }
	public static String toDateTimeString5(Calendar calendar) {
        return toDateString(calendar, dateTimePattern5);
    }

	public static String toDateTimeString6(Calendar calendar) {
        return toDateString(calendar, dateTimePattern6);
    }

	public static String toDateMonthString(Calendar calendar){
		return toDateString(calendar, dateMonthPattern);
	}

	public static String toDateMonthString2(Calendar calendar){
        return toDateString(calendar, dateMonthPattern2);
    }

	public static String toDateMinuteString(Calendar calendar){
        return toDateString(calendar, dateMinutePattern);
    }

	public static String toMonthAndDateString(Calendar calendar){
		return toDateString(calendar, MonthAndDatePattern);
	}

	public static String toDateString(Calendar calendar,String pattern){
        if(calendar==null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(calendar.getTime());
    }
	
    public static Calendar toCalendarFixed(String s){
		Calendar c =getStartOf(Calendar.getInstance());
		c.set(
				Integer.parseInt(s.substring(0, 4)),
				Integer.parseInt(s.substring(4,6))-1,
				Integer.parseInt(s.substring(6,8))
				);
		return c;
    }
    
    /**
     * 根据起始日期返回一个存放12个月的集合
     * @param fm 格式：201409
     * @return 201409，201408，201407......201310
     */
 	public static List<String> get12Months(String fm) {
 		try {
 			List<String> list = new ArrayList<String>();
 			list.add(fm);
 			Date fmDate = sf2.parse(fm);
 			Calendar fmCalendar = Calendar.getInstance();
 			fmCalendar.setTime(fmDate);
 			for (int i = 0; i < 11; i++) {
 				fmCalendar.add(Calendar.MONTH, -1);
 				String lastDate = sf2.format(fmCalendar.getTime());
 				list.add(lastDate);
 			}
 			return list;
 		} catch (ParseException e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
 	/**
     * 获得两个日期之间的年份
     * @param firstDate 格式：2012-01-01
     * @param lastDate 格式：2014-09-01
     * @return list={2012,2013,2014}
     */
 	public static List<Integer> getYears(String firstDate, String lastDate) {
 		try {
 			List<Integer> list = new ArrayList<Integer>();
 			
 			Calendar c_begin = toCalendar(firstDate);
 	 		Calendar c_end = toCalendar(lastDate);
 	 		
 	 		//添加起始的年份
 	 		list.add(Integer.valueOf(firstDate.substring(0, 4)));
 	 		
 	 		while (c_begin.before(c_end)) {
// 	 			突然又不需要加1了，加1会获得大的年份
// 	 			int m = c_begin.get(Calendar.YEAR) + 1;
 	 			int m = c_begin.get(Calendar.YEAR) + 1;
 	 			list.add(m);
 	 			System.out.println(m);
 	 			c_begin.add(Calendar.YEAR, 1);
 			}
 			return list;
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
    /**
     * 获得两个日期之间的月份
     * @param firstDate 格式：2014-01-01
     * @param lastDate 格式：2014-09-01
     * @return list={1,2,3,4,5,6,7,8,9}
     */
 	public static List<Integer> getMonths(String firstDate, String lastDate) {
 		try {
 			List<Integer> list = new ArrayList<Integer>();
 			
 			Calendar c_begin = toCalendar(firstDate);
 	 		Calendar c_end = toCalendar(lastDate);
 	 		
 	 		//添加起始的月份（不知道，为什么突然，会保存起始月份了，建议调用时实现测试下）
 	 		list.add(Integer.valueOf(firstDate.substring(5, 7)));
 	 		
 	 		while (c_begin.before(c_end)) {
// 	 			突然又不需要加1了，加1会获得大的月份
// 	 			int m = c_begin.get(Calendar.MONTH) + 1;
 	 			int m = c_begin.get(Calendar.MONTH) + 1;
 	 			list.add(m);
 	 			System.out.println(m);
 	 			c_begin.add(Calendar.MONTH, 1);
 			}
 			return list;
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
 	/**
 	 * 将毫秒数换算成x天x时x分x秒x毫秒
 	 * @param ms
 	 * @return
 	 */
 	public static String format(int ms) {
 		int ss = 1000;
 		int mi = ss * 60;
		int hh = mi * 60;
		int dd = hh * 24;
		
		long day = ms / dd;
		long hour = (ms - day * dd) / hh;
		long minute = (ms - day * dd - hour * hh) / mi;
		long second = (ms - day * dd - hour * hh - minute * mi) / ss;
		long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

		String strDay = day < 10 ? "0" + day : "" + day;
		String strHour = hour < 10 ? "0" + hour : "" + hour;
		String strMinute = minute < 10 ? "0" + minute : "" + minute;
		String strSecond = second < 10 ? "0" + second : "" + second;
		String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;
		strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : "" + strMilliSecond;
		return strDay + " " + strHour + ":" + strMinute + ":" + strSecond + " " + strMilliSecond;
	}
 	
 	/**
 	 * 将分钟数换算成x天x时x分
 	 * @param minutes 分钟总数
 	 * @return x天x时x分
 	 */
 	public static String minutesFormatDayHourMinute(long minutes){
 		StringBuffer result = new StringBuffer();
 		int hh = 60;
		int dd = hh * 24;
		
		//计算天数
		long day = minutes / dd;
		//计算小时数
		long hour = (minutes - day * dd) / hh;
		//计算分钟数
		long minute = (minutes - day * dd - hour * hh);
		
		//判断天数是否大于10，否则就在天数前加上0
		String strDay = day < 10 ? "0" + day : "" + day;
		System.out.println(strDay);
		//判断小时数是否大于10，否则就在小时数前加上0
		String strHour = hour < 10 ? "0" + hour : "" + hour;
		System.out.println(strHour);
		//判断分钟数是否大于10，否则就在分钟数前加上0
		String strMinute = minute < 10 ? "0"  + minute : "" + minute;
		System.out.println(strMinute);
		
		
		if (day > 0){
			result.append(strDay);
			result.append("天");
			result.append(strHour);
			result.append("小时");
			result.append(strMinute);
			result.append("分钟");
		}else{
			if (hour > 0){
				result.append(strHour);
				result.append("小时");
				result.append(strMinute);
				result.append("分钟");
			}else{
				result.append(strMinute);
				result.append("分钟");
			}
		}
		
		return result.toString();
 	}
 	
// 	public static void main(String[] args) {
// 		List<Integer> months = getMonths("2013-09-30", "2014-09-30");
// 		String monthJson = JsonMapper.listToJson(months);
// 		//System.out.println("(" + monthJson.substring(1, monthJson.length() - 1) + ")");
// 		Calendar c_begin = toCalendar("2012-02");
// 		Calendar c_end = toCalendar("2014-09-30");
// 		
// 		System.out.println(getDaysOfMonth(c_begin));
 		
// 		getDaysStartAndEndBetween("2014-09-01", "2014-09-30");
// 		getYears("2014-01-01", "2014-01-30");
// 		getMonths("2014-08-30", "2014-09-30");
//	}
 	
 	public static List<Integer> getDaysStartAndEndBetween(String startDate, String endDate){
 		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
 		List<Integer> days = new ArrayList<Integer>();
 		try{
 			Calendar c_begin = toCalendar(startDate);
	 		Calendar c_end = toCalendar(endDate);
 			while(c_begin.before(c_end)){
 				String date = sdf.format(c_begin.getTime());
 				days.add(Integer.valueOf(date.substring(8, 10)));
 				System.out.println(sdf.format(c_begin.getTime()));
 				c_begin.add(Calendar.DAY_OF_MONTH, 1);
			}
		}
 		catch(Exception e){
 			e.printStackTrace();
		}
 		return days;
	}
 	
	public static SimpleDateFormat sf1 = new SimpleDateFormat(datePattern);
	public static SimpleDateFormat sf3 = new SimpleDateFormat(datePattern2);
	public static SimpleDateFormat sf4 = new SimpleDateFormat(dateTimePattern);
	public static SimpleDateFormat sf2 = new SimpleDateFormat(dateMonthPattern2);
	
	/**
	 * 将字符串转换成日期格式
	 * @param s 格式：yyyy-MM-dd
	 * @return
	 */
    public static Calendar toCalendar(String s){
		Calendar c =getStartOf(Calendar.getInstance());
		c.set(
				Integer.parseInt(s.substring(0, 4)),	//年
				Integer.parseInt(s.substring(5,7))-1,	//月
				Integer.parseInt(s.substring(8, 10))	//日
				);
		return c;
    }
	
    /**
	 * 将字符串转换成日期格式
	 * @param s 格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
    public static Calendar toCalendar2(String s){
    		Calendar c =getStartOf(Calendar.getInstance());
    		c.set(
    				Integer.parseInt(s.substring(0, 4)),	//年
    				Integer.parseInt(s.substring(5,7))-1,	//月
    				Integer.parseInt(s.substring(8, 10)),	//日
    				Integer.parseInt(s.substring(11, 13)),	
    				Integer.parseInt(s.substring(14, 16)),	
    				Integer.parseInt(s.substring(17, 19))	
    				);
        return c;
    }
    
    /**
	 * 将字符串转换成日期格式
	 * @param s 格式：yyyyMMdd HHmmss
	 * @return
	 */
    public static Calendar toCalendar3(String s){
		Calendar c =getStartOf(Calendar.getInstance());
		c.set(
				Integer.parseInt(s.substring(0, 4)),
				Integer.parseInt(s.substring(4,6))-1,
				Integer.parseInt(s.substring(6, 8)),
				Integer.parseInt(s.substring(9, 11)),
				Integer.parseInt(s.substring(11, 13)),
				Integer.parseInt(s.substring(13, 15))
				);
		return c;
    }

    /**
	 * 将字符串转换成日期格式
	 * @param s 格式：yyyyMMdd
	 * @return
	 */
    public static Calendar toCalendar4(String s){
		Calendar c =getStartOf(Calendar.getInstance());
		c.set(
				Integer.parseInt(s.substring(0, 4)),
				Integer.parseInt(s.substring(4,6))-1,
				Integer.parseInt(s.substring(6, 8))
				);
		return c;
    }
    
    /**
	 * 将字符串转换成日期格式
	 * @param s 格式：yyyyMMddHHmmss
	 * @return
	 */
    public static Calendar toCalendar5(String s){
        Calendar c =getStartOf(Calendar.getInstance());
        c.set(
                Integer.parseInt(s.substring(0, 4)),
                Integer.parseInt(s.substring(4,6))-1,
                Integer.parseInt(s.substring(6, 8)),
                Integer.parseInt(s.substring(8, 10)),
                Integer.parseInt(s.substring(10, 12)),
                Integer.parseInt(s.substring(12, 14))
                );
        return c;
    }

    public static Calendar toCalendar6(String s){
		Calendar c =getStartOf(Calendar.getInstance());
		c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(s.substring(0,2)));
		c.set(Calendar.MINUTE, Integer.parseInt(s.substring(3,5)));
		c.set(Calendar.SECOND, Integer.parseInt(s.substring(6,7)));
		return c;
    }
    
    /**
   	 * 将字符串转换成日期格式
   	 * @param s 格式：yyyy-MM-dd HH:mm
   	 * @return
   	 */
    public static Calendar toCalendar7(String s){
    		Calendar c =getStartOf(Calendar.getInstance());
    		c.set(
    				Integer.parseInt(s.substring(0, 4)),	//年
    				Integer.parseInt(s.substring(5,7))-1,	//月
    				Integer.parseInt(s.substring(8, 10)),	//日
    				Integer.parseInt(s.substring(11, 13)),	//小时
    				Integer.parseInt(s.substring(14, 16))	//分钟
    				);
        return c;
    }

    /**
   	 * 将字符串转换成日期格式
   	 * @param s 格式：yyyyMM
   	 * @return
   	 */
    public static Calendar toCalendar8(String s){
		Calendar c =getStartOf(Calendar.getInstance());
		c.set(
				Integer.parseInt(s.substring(0, 4)),
				Integer.parseInt(s.substring(4,6))-1
				);
		return c;
    }
    
	public static long getDurationDays(Calendar start, Calendar end) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		assert start.compareTo(end) <= 0 : MessageFormat.format(
				"开始时间 大于 结束时间",
				dateFormat.format(start.getTime()),
				dateFormat.format(end.getTime()));
		long mod = (end.getTimeInMillis() - start.getTimeInMillis())
				% (24 * 60 * 60 * 1000);
		long days = (end.getTimeInMillis() - start.getTimeInMillis())
				/ (24 * 60 * 60 * 1000) + (mod == 0 ? 0 : 1);
		return days;
	}

	
	public static long getChargeDays(Calendar start, Calendar end) {
		long mod = (end.getTimeInMillis() - start.getTimeInMillis())
				% (24 * 60 * 60 * 1000);
		long days = (end.getTimeInMillis() - start.getTimeInMillis())
				/ (24 * 60 * 60 * 1000) + (mod == 0 ? 0 : (mod > 0 ? 1 : -1));
		if (Math.abs(days) == 1
				&& start.get(Calendar.DAY_OF_MONTH) == end.get(Calendar.DAY_OF_MONTH)) {
            days = 0;
        }
		return days;
	}

	

    public static Calendar toCalendar(Date date) {
        if (date == null) {
            return null;
        }

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        return calendar;
    }

   
    public static boolean isCurrentMonthDateTime(Calendar dateTime){
    	assert dateTime!=null : "dateTime为null";

    	int currentYear = getCurrentDateTime().get(Calendar.YEAR);
    	int currentMonth = getCurrentDateTime().get(Calendar.MONTH);

    	int dateTimeYear = dateTime.get(Calendar.YEAR);
    	int dateTimeMonth = dateTime.get(Calendar.MONTH);

    	return (currentYear==dateTimeYear && currentMonth==dateTimeMonth);
    }

    public static boolean isFirstDayOfMonth(Calendar dateTime){
    	return dateTime.get(Calendar.DAY_OF_MONTH)==1;
    }

    public static Calendar getCurrentMonthStartDateTime(){
    	Calendar startDateTime = getCurrentDateTime();

    	startDateTime.set(Calendar.DAY_OF_MONTH, 1);
    	startDateTime.set(Calendar.HOUR_OF_DAY, 0);
    	startDateTime.set(Calendar.MINUTE, 0);
    	startDateTime.set(Calendar.SECOND, 0);
    	startDateTime.set(Calendar.MILLISECOND, 0);

    	return startDateTime;
    }

    public static Calendar getNextMonthStartDateTime(){
    	Calendar startDateTime = getCurrentDateTime();

    	startDateTime.add(Calendar.MONTH, 1);
    	startDateTime.set(Calendar.DAY_OF_MONTH, 1);
    	startDateTime.set(Calendar.HOUR_OF_DAY, 0);
    	startDateTime.set(Calendar.MINUTE, 0);
    	startDateTime.set(Calendar.SECOND, 0);
    	startDateTime.set(Calendar.MILLISECOND, 0);

    	return startDateTime;
    }

    public static Calendar getNextMonthStartDateTime(Calendar date){
    	Calendar startDateTime = DateHelper.clone(date);

    	startDateTime.add(Calendar.MONTH, 1);
    	startDateTime.set(Calendar.DAY_OF_MONTH, 1);
    	startDateTime.set(Calendar.HOUR_OF_DAY, 0);
    	startDateTime.set(Calendar.MINUTE, 0);
    	startDateTime.set(Calendar.SECOND, 0);
    	startDateTime.set(Calendar.MILLISECOND, 0);

    	return startDateTime;
    }

    public static Calendar toCalendar(String dateTime, String dateFormatter) {
    	DateFormat dateFormat = new SimpleDateFormat(dateFormatter);
    	Date date;
		try {
			date = dateFormat.parse(dateTime);
		} catch (ParseException e) {
			throw new Error("格式转换错误:" + dateFormatter + "时间:" + dateTime, e);
		}
    	return toCalendar(date);
    }

    public static String toString(Calendar dateTime, String dateFormatter) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatter);
		return dateFormat.format(dateTime.getTime());
    }

	public static Calendar min(Calendar... dates) {
		return Collections.min(Arrays.asList(dates));
	}

	public static Calendar max(Calendar... dates) {
		return Collections.max(Arrays.asList(dates));
	}

	public static long getHoursDifference(Calendar start, Calendar end){
		return (end.getTimeInMillis() - start.getTimeInMillis()) / (60 * 60 * 1000);
	}

	/**
	 * 查询两个日期之间相差的天数
	 * @param start Calendar c_begin = toCalendar("2013-01-01");
	 * @param end Calendar c_begin = toCalendar("2014-01-01");
	 * @return 365 long类型
	 */
	public static long getDaysDifference(Calendar start, Calendar end) {
		if(end == null){
			end = start;
		}
		start.set(start.get(Calendar.YEAR), start.get(Calendar.MONTH), start.get(Calendar.DATE), 0, 0, 0);
		end.set(end.get(Calendar.YEAR), end.get(Calendar.MONTH), end.get(Calendar.DATE), 0, 0, 0);
		return (end.getTimeInMillis() - start.getTimeInMillis()) / (24 * 60 * 60 * 1000);
	}

	public static boolean isSameDate(Calendar c1,Calendar c2){
		return toDateString(c1).equals(toDateString(c2));
	}

	public static boolean isDifferentDay(Calendar calendar, Calendar otherCalendar){
		return !isSameDay(calendar,otherCalendar);
	}
	public static boolean isSameDay(Calendar calendar, Calendar otherCalendar){
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

		int otherYear = otherCalendar.get(Calendar.YEAR);
		int otherMonth = otherCalendar.get(Calendar.MONTH);
		int otherDayOfMonth = otherCalendar.get(Calendar.DAY_OF_MONTH);

		if(year==otherYear&&month==otherMonth&&dayOfMonth==otherDayOfMonth){
			return true;
		}else{
			return false;
		}
	}

	public static Calendar getStartOfMonth(final Calendar date){
		  return new GregorianCalendar(
				  date.get(Calendar.YEAR),
				  date.get(Calendar.MONTH),1);
	}

	public static boolean isFullMonth(String date1,String date2){
		Calendar d1 = toCalendar(date1,datePattern2);
		Calendar d2 = toCalendar(date2,datePattern2);
		return isFullMonth(d1,d2);
	}

	public static boolean isFullMonth(Calendar date1, Calendar date2) {
		int syear = date1.get(Calendar.YEAR);
		int smonth = date1.get(Calendar.MONTH);
		int eyear = date2.get(Calendar.YEAR);
		int emonth = date2.get(Calendar.MONTH);
		if (!(syear == eyear && smonth == emonth)) {
            return false;
        }
		Calendar monthStart = getStartOfMonth(clone(date1));
		Calendar monthEnd = getEndOfMonth(clone(date2));
		return (monthStart.get(Calendar.DAY_OF_MONTH) == date1
				.get(Calendar.DAY_OF_MONTH))
				&& (monthEnd.get(Calendar.DAY_OF_MONTH) == date2
						.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * 判断传递进的月份的天数
	 * @param calendar Calendar c_begin = toCalendar("2012-02-01");
	 * @return 29
	 * @param calendar Calendar c_begin = toCalendar("2014-02-01");
	 * @return 28
	 */
	public static int getDaysOfMonth(Calendar calendar) {
		return getEndOfMonth(clone(calendar)).get(Calendar.DATE);
	}

	/**
	 * 查询两个日期之间相差的天数
	 * @param start Calendar c_begin = toCalendar("2013-01-01");
	 * @param end Calendar c_begin = toCalendar("2014-01-01");
	 * @return 365 int类型
	 */
	public static int getDays(Calendar startC, Calendar endC) {
		startC = DateHelper.getStartOf(startC);
		endC = DateHelper.getStartOf(endC);
		long days = (endC.getTimeInMillis() - startC.getTimeInMillis()) / (1000 * 60 * 60 * 24);
		return (int) days;
	}

	public static Calendar getStartDayByProductChargeType(Calendar date) {
		return date;
//		if(date.get(Calendar.DATE) > 28) {
//			return getNextMonthStartDateTime(date);
//		}else {
//			return date;
//		}
	}

	public static boolean isSameMonth(Calendar calendar1, Calendar calendar2) {
		return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
				&& calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
	}




	public static int getCountMonths(Calendar start, Calendar end) {
		int startMonths = start.get(Calendar.YEAR) * 12 + start.get(Calendar.MONTH);
		int endMonths = end.get(Calendar.YEAR) * 12 + end.get(Calendar.MONTH);
		return (startMonths > endMonths ? startMonths - endMonths : endMonths - startMonths);
	}

	public static Calendar processEndValidFor(Calendar calendar){
		if(calendar==null) {
            return null;
        }
		Calendar c = (Calendar)calendar.clone();
		c.add(Calendar.SECOND, -1);
		return c;
	}

	public static Calendar addTime(Calendar calendar, int calendarField, int amount){
	    Calendar result = clone(calendar);
	    result.add(calendarField, amount);
	    return result;
	}

	public static Calendar getMonthStartDateTime(final Calendar calendar) {
		Calendar startDateTime = DateHelper.clone(calendar);

		startDateTime.set(Calendar.DAY_OF_MONTH, 1);
		startDateTime.set(Calendar.HOUR_OF_DAY, 0);
		startDateTime.set(Calendar.MINUTE, 0);
		startDateTime.set(Calendar.SECOND, 0);
		startDateTime.set(Calendar.MILLISECOND, 0);

		return startDateTime;
	}

	public static Calendar getMonthEndDateTime(final Calendar calendar) {
		Calendar dateTime = DateHelper.clone(calendar);

		dateTime.set(Calendar.DATE, 1);
		dateTime.add(Calendar.MONTH, 1);
		dateTime.add(Calendar.DATE, -1);
		dateTime.set(Calendar.HOUR_OF_DAY, 23);
		dateTime.set(Calendar.MINUTE, 59);
		dateTime.set(Calendar.SECOND, 59);
		dateTime.set(Calendar.MILLISECOND, 999);

		return dateTime;
	}
	
	/**
	 * 在传递的日期上加秒
	 * @param date
	 * @return
	 */
	public static Date editSecond(Date date, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, second);
		return calendar.getTime();
	}
	
	/**
	 * 计算两个日期时间相差多少秒
	 * @param date
	 * @return
	 */
	public static long calcTwoTimeSecondDifference(Date date1, Date date2) {
		long diff = date1.getTime() - date2.getTime();
//		System.out.println(date1.getTime());
//		System.out.println(date2.getTime());
		long second = diff / 1000;
		return second;
	}
	
	/**
	 * 计算两个日期时间相差多少小时
	 * @param date
	 * @return
	 */
	public static long calcTwoTimeHourDifference(Date date1, Date date2) {
		long diff = date1.getTime() - date2.getTime();
		long hour = diff / (1000 * 60 * 60);
		return hour;
	}
	
	/**
	 * 在指定日期上加上指定天数
	 * @param date
	 * @return
	 */
	public static Date dateAdditive(Date date, Integer additiveNum) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH) + additiveNum);   //让日期加1
		return calendar.getTime();
	}
	
	/**
	 * 在指定日期上减去指定天数
	 * @param date
	 * @return
	 */
	public static String dateSubtraction(String date, Integer subtractionNum) {
		try {
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(sf1.parse(date));
			calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH) - subtractionNum);   //让日期减1
			return sf1.format(calendar.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获得天数
	 * @param date
	 * @return
	 */
	public static List<String> getDates(Date begin, Date end) {
		Date date = null;
		List<String> dates = new ArrayList<String>();
		dates.add(sf1.format(begin));
		while (begin.compareTo(end) < 0) {
			date = dateAdditive(begin, 1);
			dates.add(sf1.format(date));
			begin = date;
		}
		return dates;
	}
	
	/**
	 * 获得当前是星期几（0表示星期天，1表示星期一）
	 * @param date
	 * @return
	 */
	public static Integer getWeek(String date){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sdf.parse(date)); 
			Integer dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
			return dayOfWeek;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获得当前是星期几（0表示星期天，1表示星期一）
	 * @param date
	 * @return
	 */
	public static String getDateFirstDate(String strDate){
		strDate = strDate.substring(0, 8);
		return strDate + "01";
	}
	
//	public static void main(String[] args) {
//		Calendar cal = Calendar.getInstance();
//		  // 不加下面2行，就是取当前时间前一个月的第一天及最后一天
//		cal.set(Calendar.YEAR, 2014);
//		  cal.set(Calendar.MONTH, 2);
//		  cal.set(Calendar.DAY_OF_MONTH, 1);
//		  cal.add(Calendar.DAY_OF_MONTH, -1);
//		  Date lastDate = cal.getTime();
//		  
//		  cal.set(Calendar.DAY_OF_MONTH, 1);
//		  Date firstDate = cal.getTime();
//		  
//		  System.out.println(sf1.format(lastDate));
//		  System.out.println(sf1.format(firstDate));
//		List<String> as = getFirstAndLastDays(2014, 3);
//		for (int i = 0; i < as.size(); i+=2){
//			System.out.println(as.get(i));
//			System.out.println(as.get(i+1));
//		}
//	}
	
	/**
     * 当月第一天
     * @return
     */
	public static List<String> getFirstAndLastDays(Integer year, Integer month){
		List<String> dates = new ArrayList<String>();
		for (int i = 1; i <= month; i++){
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, i);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			String lastDate = sf1.format(calendar.getTime());
			System.out.println(lastDate);

			calendar.set(Calendar.DAY_OF_MONTH, 1);
			String firstDate = sf1.format(calendar.getTime());
			System.out.println(firstDate);
			
			dates.add(firstDate);
			dates.add(lastDate);
		}
		
		return dates;
	}
	
	/**
     * 获得昨天的日期
     * @return
     */
	public static String getYesterDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
        Date yesterDay = calendar.getTime();
        return sf1.format(yesterDay);
	}
	
	/**
	 * （特殊方法）在指定日期上加上1天，到12点
	 * @param date 2014-11-11 07:34:46
	 * @return 2014-11-12 12:00:00
	 */
	public static Date dateAdditive(Date date) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			
			String temp = sf4.format(date);
			temp = temp.substring(0, 11) + "12:00:00";
			
			if (calcTwoTimeSecondDifference(sf4.parse(temp), date) > 0){
				return sf4.parse(temp);
			}else{
				calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH) + 1);   //让日期加1
				String result = sf4.format(calendar.getTime());
				result = result.substring(0, 11) + "12:00:00";
				return sf4.parse(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * （特殊方法）将指定日期设置为睡眠的起始绝对时间，到12点
	 * @param date 2014-11-11
	 * @return 2014-11-11 12:00:00
	 */
	public static Date dateSubtraction(Date date) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			String result = sf4.format(calendar.getTime());
			result = result.substring(0, 11) + "12:00:00";
			System.out.println(result);
			return sf4.parse(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * （特殊方法）判断睡眠日期是否超过12点
	 */
	public static String isExceedTwelve(Date date) {
		try {
			String resultDate = null;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			String result = sf4.format(calendar.getTime());
			result = result.substring(0, 11) + "12:00:00";
			Long second = calcTwoTimeSecondDifference(date, sf4.parse(result));
			if (second < 0){
				resultDate = dateSubtraction(result.substring(0, 10), 1);
			}else{
				resultDate = sf4.format(date).substring(0, 10);
			}
			return resultDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}