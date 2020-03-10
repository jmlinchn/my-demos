package cn.linjianming.timer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @Author: James Lin
 * @Date: 2020/03/10 08:54
 */
public class TimerController implements Runnable {

    private TimerFrame timerFrame;
    private TimerMouseDragListener timerMouseDragListener;
    private TimerMouseCloseListener timerMouseCloseListener;

    public TimerController() {
        timerFrame = TimerFrame.getTimerFrame();
        // 添加鼠标拖动监听
        timerMouseDragListener = new TimerMouseDragListener();
        timerFrame.addMouseListener(timerMouseDragListener);
        timerFrame.addMouseMotionListener(timerMouseDragListener);
        // 添加鼠标关闭监听
        timerMouseCloseListener = new TimerMouseCloseListener();
        timerFrame.getExitLabel().addMouseListener(timerMouseCloseListener);
    }

    @Override
    public void run() {
        while (true) {
            this.setCurrentTime();
            this.setRemainTime();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void setCurrentTime() {
        timerFrame.getCurrentTimeLabel().setText(getCurrentTime());
    }

    private void setRemainTime() {
        timerFrame.getRemainTimeLabel().setText(getRemainTime());
    }

    private String getCurrentTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FrameConstant.TIME_FORMAT);
        return LocalDateTime.now().format(dateTimeFormatter);
    }

    private String getRemainTime() {
        LocalDateTime now = LocalDateTime.now();

        LocalDate nextDate = LocalDate.now().plusDays(1);
        LocalTime nextTime = LocalTime.of(0, 0);
        LocalDateTime nextDateTime = LocalDateTime.of(nextDate, nextTime);

        long minutes = MINUTES.between(now, nextDateTime);
        long seconds = SECONDS.between(now, nextDateTime);

        return minutes + " min   /   " + seconds + " sec";
    }

}
