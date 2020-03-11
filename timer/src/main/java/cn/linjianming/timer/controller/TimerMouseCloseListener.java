package cn.linjianming.timer.controller;

import cn.linjianming.timer.view.TimerFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Author: James Lin
 * @Date: 2020/03/10 09:38
 */
public class TimerMouseCloseListener extends MouseAdapter {

    private TimerFrame timerFrame;

    public TimerMouseCloseListener() {
        timerFrame = TimerFrame.getTimerFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseButton = e.getButton();
        if (MouseEvent.BUTTON1 == mouseButton) {
            // 左键单击
            timerFrame.dispose();
            System.exit(0);
        } else if (MouseEvent.BUTTON2 == mouseButton) {
            // 滚轮单击
        } else if (MouseEvent.BUTTON3 == mouseButton) {
            // 右键单击
        }
    }

}
