package cn.linjianming.timer.view;

import cn.linjianming.timer.constant.FrameConstant;
import cn.linjianming.timer.model.TimerLabel;

import javax.swing.*;

/**
 * @Author: James Lin
 * @Date: 2020/03/11 09:30
 */
public class TimerPanel extends JPanel {

    private static volatile TimerPanel timerPanel;
    private TimerLabel currentTimeLabel;
    private TimerLabel remainTimeLabel;
    private TimerLabel exitLabel;

    private TimerPanel() {
        // 设置绝对布局
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(FrameConstant.TIMER_TITLE));

        currentTimeLabel = new TimerLabel(FrameConstant.LABEL_FONT_SIZE,
                FrameConstant.TIMER_PADDING_X, FrameConstant.TIMER_PADDING_Y,
                FrameConstant.TIMER_LABEL_WIDTH, FrameConstant.TIMER_LABEL_HEIGHT);
        this.add(currentTimeLabel);

        remainTimeLabel = new TimerLabel(FrameConstant.LABEL_FONT_SIZE,
                FrameConstant.TIMER_PADDING_X, FrameConstant.TIMER_PADDING_Y + FrameConstant.TIMER_LABEL_HEIGHT,
                FrameConstant.TIMER_LABEL_WIDTH, FrameConstant.TIMER_LABEL_HEIGHT);
        this.add(remainTimeLabel);

        exitLabel = new TimerLabel(FrameConstant.LABEL_FONT_SIZE,
                FrameConstant.FRAME_WIDTH - FrameConstant.CLOSE_LABEL_SIZE, FrameConstant.CLOSE_LABEL_Y,
                FrameConstant.CLOSE_LABEL_SIZE, FrameConstant.CLOSE_LABEL_SIZE);
        exitLabel.setText("×");
        this.add(exitLabel);
    }

    public static TimerPanel getTimerPanel() {
        if (timerPanel == null) {
            synchronized (TimerPanel.class) {
                if (timerPanel == null) {
                    timerPanel = new TimerPanel();
                }
            }
        }
        return timerPanel;
    }


    // ============================== getter ==============================

    public TimerLabel getCurrentTimeLabel() {
        return currentTimeLabel;
    }

    public TimerLabel getRemainTimeLabel() {
        return remainTimeLabel;
    }

    public TimerLabel getExitLabel() {
        return exitLabel;
    }

}
