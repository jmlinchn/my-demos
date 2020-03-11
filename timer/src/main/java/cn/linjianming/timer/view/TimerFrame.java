package cn.linjianming.timer.view;

import cn.linjianming.timer.constant.FrameConstant;

import javax.swing.*;

/**
 * @Author: James Lin
 * @Date: 2020/03/10 08:45
 */
public class TimerFrame extends JFrame {

    private static volatile TimerFrame timerFrame;
    private TimerPanel timerPanel;
    private TaskPanel taskPanel;

    private TaskListAB taskListA;
    private TaskListAB taskListB;

    private TimerFrame() {
        super();
        this.setTitle(FrameConstant.FRAME_TITLE);
        this.setSize(FrameConstant.FRAME_WIDTH, FrameConstant.FRAME_HEIGHT);

        // 设置绝对布局
        this.setLayout(null);

        timerPanel = TimerPanel.getTimerPanel();
        timerPanel.setBounds(FrameConstant.TIMER_PANEL_X, FrameConstant.TIMER_PANEL_Y,
                FrameConstant.TIMER_PANEL_WIDTH, FrameConstant.TIMER_PANEL_HEIGHT);
        this.add(timerPanel);

        taskPanel = TaskPanel.getTaskPanel();
        taskPanel.setBounds(FrameConstant.TASK_PANEL_X, FrameConstant.TASK_PANEL_Y,
                FrameConstant.TASK_PANEL_WIDTH, FrameConstant.TASK_PANEL_HEIGHT);
        this.add(taskPanel);

        taskListA = TaskListAB.getTaskListA();
        taskListA.setBounds(FrameConstant.TASK_LIST_X, FrameConstant.TASK_LIST_Y,
                FrameConstant.TASK_LIST_WIDTH, FrameConstant.TASK_LIST_HEIGHT);
        this.add(taskListA);

        taskListB = TaskListAB.getTaskListB();
        taskListB.setBounds(FrameConstant.TASK_LIST_X, FrameConstant.TASK_LIST_Y,
                FrameConstant.TASK_LIST_WIDTH, FrameConstant.TASK_LIST_HEIGHT);
        this.add(taskListB);

        this.setLocation(FrameConstant.FRAME_X, FrameConstant.FRAME_Y);
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static TimerFrame getTimerFrame() {
        if (timerFrame == null) {
            synchronized (TimerFrame.class) {
                if (timerFrame == null) {
                    timerFrame = new TimerFrame();
                }
            }
        }
        return timerFrame;
    }

    // ============================== getter ==============================

    public TimerPanel getTimerPanel() {
        return timerPanel;
    }

    public TaskPanel getTaskPanel() {
        return taskPanel;
    }

    public TaskListAB getTaskListA() {
        return taskListA;
    }

    public TaskListAB getTaskListB() {
        return taskListB;
    }
}
