package cn.linjianming.timer.util;

import cn.linjianming.timer.constant.FrameConstant;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @Author: James Lin
 * @Date: 2020/03/11 12:43
 */
public class TimeUtils {

    public static String getCurrentTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FrameConstant.LONG_TIME_FORMAT);
        return LocalDateTime.now().format(dateTimeFormatter);
    }

    public static String getRemainTime() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextDateTime = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0);
        LocalDateTime nextMinuteTime = LocalDateTime.now().plusMinutes(1).withSecond(0);

        long minutes = MINUTES.between(now, nextDateTime);
        long seconds = SECONDS.between(now, nextMinuteTime);
        return "min: " + new DecimalFormat("0000").format(minutes) + " / " + 60 * 24
                + "  sec: " + new DecimalFormat("00").format(seconds == 60 ? 0 : seconds);
    }
}
