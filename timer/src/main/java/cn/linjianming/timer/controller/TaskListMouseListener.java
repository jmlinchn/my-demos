package cn.linjianming.timer.controller;

import cn.linjianming.timer.model.Task;
import cn.linjianming.timer.model.TaskLabel;
import cn.linjianming.timer.view.TaskListAB;

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
        Object source = e.getSource();
        if (source instanceof TaskLabel) {
            Task task = TaskListAB.getTaskMap().get(source);
            task.togglePause();
        }
    }

}
