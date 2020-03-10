package cn.linjianming.timer;

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
            // Left button
            System.out.println("左键单击");
            timerFrame.dispose();
            System.exit(0);
        } else if (MouseEvent.BUTTON2 == mouseButton) {
            // Middle button
            System.out.println("滚轮单击");
        } else if (MouseEvent.BUTTON3 == mouseButton) {
            // Right button
            System.out.println("右键单击");
        }
    }

}
