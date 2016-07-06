package com.tyaer.basic.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author mg
 */
public class DateUtils {

    private static SimpleDateFormat sf = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    /**
     * 获取格式化后的时间
     */
    public String getDateFormat(Date date) {
        return sf.format(date);
    }

    /**
     * 获取格式化时间
     * */

    /**
     * 得到当前时间的3位秒数
     */
    public String getMilliSecond() {
        String currentTime = String.valueOf(System.currentTimeMillis());
        String ms = currentTime.substring(currentTime.length() - 3,
                currentTime.length());
        return ms;
    }

    /**
     * 两个时间之间相差距离多少
     *
     * @return 相差分钟数
     */
    public long getDistanceMine(String publishTime, String createtime) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date one = new Date();
            if (publishTime != null) {
                one = df.parse(publishTime);
            }
            Date two = df.parse(createtime);
            long mins = 0;
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            mins = diff / 1000;
            return mins;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 比较两个时间
     *
     * @return 前者大返回fasle，后者大返回true
     */
    public boolean compareTime(String publishTime, String createtime) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date one = new Date();
            if (publishTime != null) {
                one = df.parse(publishTime);
            }
            Date two = df.parse(createtime);
            long time1 = one.getTime();
            long time2 = two.getTime();
            if (time1 > time2) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 比较两个时间
     *
     * @return 前者大返回1，后者大返回-1
     */
    public int compareToTime(String publishTime, String createtime) {
        int result = 0;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date ptime = df.parse(publishTime);
            Date ctime = df.parse(createtime);
            Calendar Calendar1 = Calendar.getInstance();
            Calendar1.setTime(ptime);
            Calendar Calendar2 = Calendar.getInstance();
            Calendar2.setTime(ctime);
            result = Calendar1.compareTo(Calendar2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getStringTimeFormat(Date date, String dateformat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
        return sdf.format(date);
    }

    public static Date getDataTimeFormat(String date, String dateformat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
        try {
            Date da = sdf.parse(date);
            return da;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 由时间戳转变成时间
    public static String getTimeByStamp(String timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date(Long.parseLong(timeStamp)));
        return date;
    }

    /**
     * 获取当前时间的前一天时间
     *
     * @param cl
     * @return
     */
    public static Calendar getBeforeDay(Calendar cl) {
        // 使用roll方法进行向前回滚
        // cl.roll(Calendar.DATE, -1);
        // 使用set方法直接进行设置
        int day = cl.get(Calendar.DATE);
        cl.set(Calendar.DATE, day - 1);
        return cl;
    }

    /**
     * 获取当前时间的后一天时间
     *
     * @param cl
     * @return
     */
    public static Calendar getAfterDay(Calendar cl) {
        // 使用roll方法进行回滚到后一天的时间
        // cl.roll(Calendar.DATE, 1);
        // 使用set方法直接设置时间值
        int day = cl.get(Calendar.DATE);
        cl.set(Calendar.DATE, day + 1);
        return cl;
    }

    public static void main(String[] args) {
//		DateUtils du = new DateUtils();
//		// System.out.println(du.fetchDateTime("07:36"));
//		String a = "2015-10-14 23:46:45";
//		String b = "2015-10-14 00:11:13";
//		boolean c = du.compareTime(a, b);
//		System.out.println(c);
//		int d = du.compareToTime(a, b);
//		System.out.println(d);
        System.out.println(sf.format(new Date()));
    }
}
