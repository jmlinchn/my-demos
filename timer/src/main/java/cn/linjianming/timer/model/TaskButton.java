package cn.linjianming.timer.model;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: James Lin
 * @Date: 2020/03/11 09:50
 */
public class TaskButton extends JButton {

    public TaskButton(int fontSize, int x, int y, int width, int height) {
        this.setFont(new Font(null, Font.PLAIN, fontSize));
        this.setBounds(x, y, width, height);
        this.setMargin(new Insets(0, 0, 0, 0));
    }
}
