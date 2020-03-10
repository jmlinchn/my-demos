package cn.linjianming.timer;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: James Lin
 * @Date: 2020/03/10 08:45
 */
public class TimerFrame extends JFrame {

    private static volatile TimerFrame timerFrame;

    private JLabel currentTimeLabel;
    private JLabel remainTimeLabel;
    private JLabel exitLabel;

    private TimerFrame() {
        super();
        this.setTitle(FrameConstant.FRAME_TITLE);
        this.setSize(new Dimension(FrameConstant.FRAME_WIDTH, FrameConstant.FRAME_HEIGHT));

        // ���Բ���
        this.setLayout(null);

        currentTimeLabel = new JLabel();
        currentTimeLabel.setFont(new Font(null, Font.BOLD, FrameConstant.LABEL_FONT_SIZE));
        currentTimeLabel.setBounds(FrameConstant.X_PADDING, FrameConstant.Y_PADDING, FrameConstant.LABEL_WIDTH, FrameConstant.LABEL_HEIGHT);
        this.add(currentTimeLabel);

        remainTimeLabel = new JLabel();
        remainTimeLabel.setFont(new Font(null, Font.BOLD, FrameConstant.LABEL_FONT_SIZE));
        remainTimeLabel.setBounds(FrameConstant.X_PADDING, FrameConstant.Y_PADDING + FrameConstant.LABEL_HEIGHT, FrameConstant.LABEL_WIDTH, FrameConstant.LABEL_HEIGHT);
        this.add(remainTimeLabel);

        exitLabel = new JLabel();
        exitLabel.setText("×");
        exitLabel.setFont(new Font(null, Font.BOLD, FrameConstant.LABEL_FONT_SIZE));
        exitLabel.setBounds(FrameConstant.FRAME_WIDTH - FrameConstant.LABEL_CLOSE_SIZE, FrameConstant.LABEL_CLOSE_Y, FrameConstant.LABEL_CLOSE_SIZE, FrameConstant.LABEL_CLOSE_SIZE);
        this.add(exitLabel);

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

    public JLabel getCurrentTimeLabel() {
        return currentTimeLabel;
    }

    public JLabel getRemainTimeLabel() {
        return remainTimeLabel;
    }

    public JLabel getExitLabel() {
        return exitLabel;
    }
}
