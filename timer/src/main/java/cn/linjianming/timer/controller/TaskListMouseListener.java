package cn.linjianming.timer.controller;

import cn.linjianming.timer.constant.FrameConstant;
import cn.linjianming.timer.model.Task;
import cn.linjianming.timer.model.TaskLabel;
import cn.linjianming.timer.view.TaskListAB;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Author: James Lin
 * @Date: 2020/03/11 12:26
 */
public class TaskListMouseListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        int mouseButton = e.getButton();
        TaskLabel taskLabel = (TaskLabel) e.getSource();
        Task task = TaskListAB.getTaskMap().get(taskLabel);
        if (MouseEvent.BUTTON1 == mouseButton) {
            // 左键单击
            task.togglePause();
            Color newColor = task.isPause() ? FrameConstant.COLOR_PAUSE : FrameConstant.COLOR_GO;
            taskLabel.setForeground(newColor);
        } else if (MouseEvent.BUTTON2 == mouseButton) {
            // 滚轮单击
        } else if (MouseEvent.BUTTON3 == mouseButton) {
            // 右键单击
            TaskListAB.removeTask(taskLabel);
        }
    }

}
