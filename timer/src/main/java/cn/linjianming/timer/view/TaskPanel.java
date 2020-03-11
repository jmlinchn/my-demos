package cn.linjianming.timer.view;

import cn.linjianming.timer.constant.FrameConstant;
import cn.linjianming.timer.model.TaskButton;
import cn.linjianming.timer.model.TaskInput;
import cn.linjianming.timer.model.TaskLabel;

import javax.swing.*;

/**
 * @Author: James Lin
 * @Date: 2020/03/11 09:30
 */
public class TaskPanel extends JPanel {

    private static TaskPanel taskPanel;
    private TaskLabel taskNameLabel;
    private TaskInput taskNameInput;
    private TaskLabel taskTimeLabel;
    private TaskInput taskTimeInput;
    private TaskLabel timeUnitLabel;
    private TaskButton taskButton;

    private TaskPanel() {
        // 设置绝对布局
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(FrameConstant.TASK_TITLE));

        taskNameLabel = new TaskLabel(
                FrameConstant.TASK_PADDING_X, FrameConstant.TASK_PADDING_Y,
                FrameConstant.TASK_LABEL_WIDTH, FrameConstant.TASK_LABEL_HEIGHT);
        taskNameLabel.setText("事件");
        this.add(taskNameLabel);

        taskNameInput = new TaskInput(FrameConstant.TASK_INPUT_FONT_SIZE,
                FrameConstant.TASK_INPUT_X, FrameConstant.TASK_INPUT_Y,
                FrameConstant.TASK_INPUT_WIDTH, FrameConstant.TASK_INPUT_HEIGHT);
        this.add(taskNameInput);


        taskTimeLabel = new TaskLabel(
                FrameConstant.TASK_PADDING_X, FrameConstant.TASK_PADDING_Y + FrameConstant.TASK_LABEL_HEIGHT,
                FrameConstant.TASK_LABEL_WIDTH, FrameConstant.TASK_LABEL_HEIGHT);
        taskTimeLabel.setText("时长");
        this.add(taskTimeLabel);

        taskTimeInput = new TaskInput(FrameConstant.TASK_INPUT_FONT_SIZE,
                FrameConstant.TASK_INPUT_X, FrameConstant.TASK_INPUT_Y + FrameConstant.TASK_INPUT_HEIGHT,
                FrameConstant.TASK_INPUT_WIDTH - FrameConstant.TASK_TIME_UNIT_WIDTH, FrameConstant.TASK_INPUT_HEIGHT);
        this.add(taskTimeInput);

        timeUnitLabel = new TaskLabel(
                FrameConstant.TASK_INPUT_X + FrameConstant.TASK_INPUT_WIDTH - FrameConstant.TASK_TIME_UNIT_WIDTH, FrameConstant.TASK_INPUT_Y + FrameConstant.TASK_INPUT_HEIGHT,
                FrameConstant.TASK_TIME_UNIT_WIDTH, FrameConstant.TASK_TIME_UNIT_HEIGHT);
        timeUnitLabel.setText("分钟");
        this.add(timeUnitLabel);

        taskButton = new TaskButton(FrameConstant.TASK_BUTTON_FONT_SIZE,
                FrameConstant.TASK_BUTTON_X, FrameConstant.TASK_BUTTON_Y,
                FrameConstant.TASK_BUTTON_WIDTH, FrameConstant.TASK_BUTTON_HEIGHT);
        taskButton.setText("<html>添<br>加</html>");
        this.add(taskButton);
    }

    public static TaskPanel getTaskPanel() {
        if (taskPanel == null) {
            synchronized (TaskPanel.class) {
                if (taskPanel == null) {
                    taskPanel = new TaskPanel();
                }
            }
        }
        return taskPanel;
    }

    // ============================== getter ==============================

    public TaskInput getTaskNameInput() {
        return taskNameInput;
    }

    public TaskInput getTaskTimeInput() {
        return taskTimeInput;
    }

    public TaskButton getTaskButton() {
        return taskButton;
    }


}
