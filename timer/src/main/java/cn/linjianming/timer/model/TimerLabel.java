package cn.linjianming.timer.model;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: James Lin
 * @Date: 2020/03/11 09:45
 */
public class TimerLabel extends JLabel {

    public TimerLabel(int fontSize, int x, int y, int width, int height) {
        this.setFont(new Font(null, Font.BOLD, fontSize));
        this.setBounds(x, y, width, height);
    }

}
