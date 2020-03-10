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
            // ���������
            System.out.println("���������");
            // ע����壬�ر�������
            timerFrame.dispose();
            System.exit(0);
        } else if (MouseEvent.BUTTON2 == mouseButton) {
            // �����껬��
            System.out.println("�����껬��");
        } else if (MouseEvent.BUTTON3 == mouseButton) {
            // �������Ҽ�
            System.out.println("�������Ҽ�");
        }
    }

}
