#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright 2016 xtecuan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ${package}.xtecuannet.framework.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author xtecuan
 */
public final class CalendarUtil {

    public Date getCurrentDate() {
        return new Date();
    }

    public Calendar getCurrentCalendar() {
        Calendar ccalendar = Calendar.getInstance();
        ccalendar.setTime(getCurrentDate());
        return ccalendar;
    }

    public Calendar getCalendar(Date cdate) {
        Calendar ccalendar = Calendar.getInstance();
        ccalendar.setTime(cdate);
        return ccalendar;
    }

    public Integer getCurrentYear() {
        return getCurrentCalendar().get(Calendar.YEAR);
    }

    public Date getFirstDayOfCurrentYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getCurrentYear());
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    public Date getLastDayOfCurrentYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getCurrentYear());
        cal.set(Calendar.MONTH, 11);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        return cal.getTime();
    }

    public Date addMonthsToDate(Date date, int months) {
        Calendar ccalendar = Calendar.getInstance();
        ccalendar.setTime(date);
        ccalendar.add(Calendar.MONTH, months);
        return ccalendar.getTime();
    }

    public Date addDaysToDate(Date date, int days) {
        Calendar ccalendar = Calendar.getInstance();
        ccalendar.setTime(date);
        ccalendar.add(Calendar.DATE, days);
        return ccalendar.getTime();
    }

    public Date fromUnixTimestampToDate(String unixtimestamp, String timezone) {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone(timezone));
        c.setTimeInMillis(Long.parseLong(unixtimestamp) * 1000L);
        return c.getTime();
    }

    public Date fromUnixTimestampToDefaultDate(String unixtimestamp) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(Long.parseLong(unixtimestamp) * 1000L);
        return c.getTime();
    }

    public Date fromUnixTimestampToNewYorkDate(String unixtimestamp) {
        return fromUnixTimestampToDate(unixtimestamp, "America/New_York");
    }

    public Date fromUnixTimestampToCST(String unixtimestamp) {
        return fromUnixTimestampToDate(unixtimestamp, "CST");
    }

}
