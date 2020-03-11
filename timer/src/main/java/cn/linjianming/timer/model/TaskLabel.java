package cn.linjianming.timer.model;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: James Lin
 * @Date: 2020/03/11 09:45
 */
public class TaskLabel extends JLabel {

    public TaskLabel(int x, int y, int width, int height) {
        this.setFont(new Font(null, Font.PLAIN, 12));
        this.setBounds(x, y, width, height);
    }

}
