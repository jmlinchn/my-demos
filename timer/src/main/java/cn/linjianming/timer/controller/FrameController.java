package cn.linjianming.timer.controller;

import cn.linjianming.timer.util.TimeUtils;
import cn.linjianming.timer.view.TaskListAB;
import cn.linjianming.timer.view.TaskPanel;
import cn.linjianming.timer.view.TimerFrame;
import cn.linjianming.timer.view.TimerPanel;

import java.util.concurrent.TimeUnit;

/**
 * @Author: James Lin
 * @Date: 2020/03/10 08:54
 */
public class FrameController implements Runnable {

    private TimerFrame timerFrame;
    private TimerPanel timerPanel;
    private TaskPanel taskPanel;

    public FrameController() {
        timerFrame = TimerFrame.getTimerFrame();
        timerPanel = TimerPanel.getTimerPanel();
        taskPanel = TaskPanel.getTaskPanel();

        this.addTimerListener();
        this.addTaskListener();
    }

    /**
     * 添加计时面板监听
     */
    private void addTimerListener() {
        // 添加鼠标拖动监听
        TimerMouseDragListener timerMouseDragListener = new TimerMouseDragListener();
        timerFrame.addMouseListener(timerMouseDragListener);
        timerFrame.addMouseMotionListener(timerMouseDragListener);

        // 添加鼠标关闭监听
        TimerMouseCloseListener timerMouseCloseListener = new TimerMouseCloseListener();
        timerFrame.getTimerPanel().getExitLabel().addMouseListener(timerMouseCloseListener);
    }

    /**
     * 添加任务面板监听
     */
    private void addTaskListener() {
        TaskActionListener taskActionListener = new TaskActionListener();
        taskPanel.getTaskButton().addActionListener(taskActionListener);
    }

    @Override
    public void run() {
        while (true) {
            this.setCurrentTime();
            this.setRemainTime();
            TaskListAB.refreshList();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void setCurrentTime() {
        timerPanel.getCurrentTimeLabel().setText(TimeUtils.getCurrentTime());
    }

    private void setRemainTime() {
        timerPanel.getRemainTimeLabel().setText(TimeUtils.getRemainTime());
    }
}
