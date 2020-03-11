package cn.linjianming.timer.view;

import cn.linjianming.timer.constant.FrameConstant;
import cn.linjianming.timer.controller.TaskListMouseListener;
import cn.linjianming.timer.model.Task;
import cn.linjianming.timer.model.TaskLabel;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 【 添加、删除、重建、刷新 】操作添加 synchronized 进行线程同步
 * @Author: James Lin
 * @Date: 2020/03/11 13:16
 */
public class TaskListAB extends JPanel {

    private static TaskListAB taskListA = new TaskListAB();
    private static TaskListAB taskListB = new TaskListAB();
    // 分为 A、B 列表，一个隐藏一个展示
    private static volatile boolean visibleA = true;
    private static volatile TaskListAB enabled;
    private static volatile Map<TaskLabel, Task> taskMap = new LinkedHashMap<>();

    static {
        taskListA.setLayout(new BoxLayout(taskListA, BoxLayout.Y_AXIS));
        taskListB.setLayout(new BoxLayout(taskListB, BoxLayout.Y_AXIS));

        taskListA.setVisible(visibleA);
        taskListB.setVisible(!visibleA);

        taskListA.setBorder(BorderFactory.createTitledBorder(FrameConstant.TASK_LIST_TITLE));
        taskListB.setBorder(BorderFactory.createTitledBorder(FrameConstant.TASK_LIST_TITLE));
    }

    /**
     * 添加任务
     * @param task 任务
     */
    public synchronized static void addTask(Task task) {
        TaskLabel newTask = new TaskLabel(
                FrameConstant.TASK_LIST_X, FrameConstant.TASK_LIST_Y,
                FrameConstant.TASK_LIST_WIDTH, FrameConstant.TASK_LABEL_HEIGHT);

        newTask.setForeground(FrameConstant.COLOR_GO);
        newTask.addMouseListener(new TaskListMouseListener());
        taskMap.put(newTask, task);
        rebuild();
    }

    /**
     * 删除任务
     * @param taskLabel 任务组件
     */
    public synchronized static void removeTask(TaskLabel taskLabel) {
        // 删除的时候要接触监听
        for (MouseListener mouseListener : taskLabel.getMouseListeners()) {
            taskLabel.removeMouseListener(mouseListener);
        }
        taskMap.remove(taskLabel);
        rebuild();
    }

    /**
     * 新增或删除后重新构建
     */
    private synchronized static void rebuild() {
        enabled = visibleA ? taskListB : taskListA;
        visibleA = !visibleA;
        System.out.println("正在加载[" + (visibleA ? "A" : "B") + "]面板......");
        enabled.removeAll();

        Set<Map.Entry<TaskLabel, Task>> entries = taskMap.entrySet();
        for (Map.Entry<TaskLabel, Task> entry : entries) {
            TaskLabel taskLabel = entry.getKey();
            setTextForTaskList(taskLabel, entry.getValue());
            enabled.add(taskLabel);
        }

        enabled.setSize(FrameConstant.TASK_LIST_WIDTH,
                (taskMap.size() + 1) * FrameConstant.TASK_ITEM_LABEL_HEIGHT + FrameConstant.PADDING_Y / 2);
        TimerFrame timerFrame = TimerFrame.getTimerFrame();
        timerFrame.setSize(FrameConstant.FRAME_WIDTH,
                FrameConstant.TASK_LIST_Y + (taskMap.size() + 1) * FrameConstant.TASK_ITEM_LABEL_HEIGHT + FrameConstant.PADDING_Y);

        taskListA.setVisible(visibleA);
        taskListB.setVisible(!visibleA);
    }

    /**
     * 刷新时间
     */
    public synchronized static void refreshList() {
        Set<Map.Entry<TaskLabel, Task>> entries = taskMap.entrySet();
        for (Map.Entry<TaskLabel, Task> entry : entries) {
            Task task = entry.getValue();
            boolean isOver = task.reduceSeconds();
            if (isOver) {
                new Thread(() -> JOptionPane.showMessageDialog(null, "事件" + task.getTaskName() + "结束啦！")).start();
            }
            setTextForTaskList(entry.getKey(), task);
        }
    }

    private static void setTextForTaskList(TaskLabel taskLabel, Task task) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FrameConstant.SHORT_TIME_FORMAT);
        StringBuilder sb = new StringBuilder()
                .append("[")
                .append(task.getEndDateTime().format(dateTimeFormatter))
                .append("]  ")
                .append(task.getTaskName())
                .append(" - ");
        int remainSeconds = task.getRemainSeconds();
        if (remainSeconds < 0) {
            if (task.isPause()) {
                taskLabel.setForeground(FrameConstant.COLOR_PAUSE);
            } else {
                taskLabel.setForeground(FrameConstant.COLOR_OVERTIME);
            }
            sb.append("超时").append(-remainSeconds);
        } else {
            sb.append(remainSeconds);
        }
        sb.append("s");
        taskLabel.setText(sb.toString());

    }

    // ============================== getter ==============================

    public static TaskListAB getTaskListA() {
        return taskListA;
    }

    public static TaskListAB getTaskListB() {
        return taskListB;
    }

    public static Map<TaskLabel, Task> getTaskMap() {
        return taskMap;
    }
}
