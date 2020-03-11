package cn.linjianming.timer.controller;

import cn.linjianming.timer.model.Task;
import cn.linjianming.timer.model.TaskInput;
import cn.linjianming.timer.view.TaskListAB;
import cn.linjianming.timer.view.TaskPanel;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: James Lin
 * @Date: 2020/03/11 12:26
 */
public class TaskActionListener implements ActionListener {

    private TaskPanel taskPanel;

    public TaskActionListener() {
        taskPanel = TaskPanel.getTaskPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TaskInput taskNameInput = taskPanel.getTaskNameInput();
        TaskInput taskTimeInput = taskPanel.getTaskTimeInput();

        String taskName = taskNameInput.getText();
        String taskTime = taskTimeInput.getText();

        if (StringUtils.isBlank(taskName)) {
            JOptionPane.showMessageDialog(null, "事件不能为空");
            return;
        }
        if (StringUtils.isBlank(taskTime)) {
            JOptionPane.showMessageDialog(null, "时长不能为空");
            return;
        } else if (!StringUtils.isNumeric(taskTime)) {
            JOptionPane.showMessageDialog(null, "请输入数字");
            return;
        }

        Task task = new Task(taskName, Integer.parseInt(taskTime));
        TaskListAB.addTask(task);

        taskNameInput.setText("");
        taskTimeInput.setText("");
    }
}
