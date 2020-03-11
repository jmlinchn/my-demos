package cn.linjianming.timer.controller;

import cn.linjianming.timer.view.TimerFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Author: James Lin
 * @Date: 2020/03/10 10:26
 */
public class TimerMouseDragListener extends MouseAdapter {

    private TimerFrame timerFrame;
    /**
     * 鼠标起始点
     */
    private Point startPoint;

    public TimerMouseDragListener() {
        timerFrame = TimerFrame.getTimerFrame();
        startPoint = new Point();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        timerFrame.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        timerFrame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        startPoint.x = e.getX();
        startPoint.y = e.getY();
    }

    /**
     * 窗口终点 = 窗口起始点 + (鼠标终止点-鼠标起始点)
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        // 鼠标终止点
        Point endPoint = e.getPoint();
        double targetX = timerFrame.getLocation().getX() + (endPoint.getX() - startPoint.getX());
        double targetY = timerFrame.getLocation().getY() + (endPoint.getY() - startPoint.getY());
        timerFrame.setLocation((int) targetX, (int) targetY);
    }
}
