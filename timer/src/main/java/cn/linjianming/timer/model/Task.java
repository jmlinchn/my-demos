package cn.linjianming.timer.model;

import java.time.LocalDateTime;

/**
 * @Author: James Lin
 * @Date: 2020/03/11 16:04
 */
public class Task {

    private String taskName;
    private LocalDateTime endDateTime;
    private boolean isPause;
    private int remainSeconds;

    public Task(String taskName, int minutes) {
        this.remainSeconds = minutes * 60;
        this.endDateTime = LocalDateTime.now().plusSeconds(remainSeconds);
        this.taskName = taskName;
    }

    public void reduceSeconds() {
        if (isPause) {
            this.endDateTime = LocalDateTime.now().plusSeconds(remainSeconds);
        } else {
            remainSeconds--;
        }
    }

    public void togglePause() {
        if (isPause) {
            LocalDateTime now = LocalDateTime.now();
            endDateTime = now.plusSeconds(remainSeconds);
        }
        isPause = !isPause;
        System.out.println("任务 [" + taskName + "] 暂停，要加油哦！");
    }

    // ============================== getter ==============================

    public String getTaskName() {
        return taskName;
    }

    public int getRemainSeconds() {
        return remainSeconds;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }
}
