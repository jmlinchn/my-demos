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
    private boolean isOver;

    public Task(String taskName, int minutes) {
        this.remainSeconds = minutes * 60;
        this.endDateTime = LocalDateTime.now().plusSeconds(remainSeconds);
        this.taskName = taskName;
    }

    /**
     * 返回是否剩余时间为 0
     * @return
     */
    public boolean reduceSeconds() {
        if (isOver) {
            // 结束：显示当前时间，同时显示超时时间
            this.endDateTime = LocalDateTime.now();
            // 超时时间可以暂停
            if (!isPause) {
                remainSeconds--;
            }
        } else if (isPause) {
            // 未结束的暂停：
            this.endDateTime = LocalDateTime.now().plusSeconds(remainSeconds);
        } else {
            // 未结束未暂停：扣减时间
            if (remainSeconds == 0) {
                // 当倒计时刚刚结束时提示
                isOver = true;
                return true;
            }
            remainSeconds--;
        }
        return false;
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

    public boolean isPause() {
        return isPause;
    }

    public boolean isOver() {
        return isOver;
    }
}
