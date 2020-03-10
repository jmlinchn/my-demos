package cn.linjianming.timer;

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
     * �϶�ǰ������
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
     * �����µ�����λ�� = �ƶ�ǰ����λ��+�����ָ�뵱ǰ����-��갴��ʱָ���λ�ã�
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        // �϶��������
        Point endPoint = e.getPoint();
        double targetX = timerFrame.getLocation().getX() + (endPoint.getX() - startPoint.getX());
        double targetY = timerFrame.getLocation().getY() + (endPoint.getY() - startPoint.getY());
        timerFrame.setLocation((int) targetX, (int) targetY);
    }
}
