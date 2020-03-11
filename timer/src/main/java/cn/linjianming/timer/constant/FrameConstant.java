package cn.linjianming.timer.constant;

import java.awt.*;

/**
 * @Author: James Lin
 * @Date: 2020/03/10 08:49
 */
public interface FrameConstant {

    String FRAME_TITLE = "计时器";
    String TIMER_TITLE = "计时器面板";
    String TASK_TITLE = "任务面板";
    String TASK_LIST_TITLE = "任务列表";
    String LONG_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    String SHORT_TIME_FORMAT = "HH:mm:ss";

    Color COLOR_GO = new Color(48, 118, 66);
    Color COLOR_PAUSE = Color.RED;
    Color COLOR_OVERTIME = new Color(153, 52, 0);

    /***** 窗口属性 *****/
    int FRAME_X = 1650;
    int FRAME_Y = 70;
    int FRAME_WIDTH = 180;
    int FRAME_HEIGHT = 190;

    int PADDING_X = 5;
    int PADDING_Y = 8;

    /***** 标签属性 *****/
    int LABEL_FONT_SIZE = 14;

    /***** 关闭标签 *****/
    int CLOSE_LABEL_SIZE = 20;
    int CLOSE_LABEL_Y = 0;

    /***** 计时器面板属性 *****/
    int TIMER_PANEL_X = 0;
    int TIMER_PANEL_Y = 5;
    int TIMER_PANEL_WIDTH = 180;
    int TIMER_PANEL_HEIGHT = 75;
    int TIMER_PADDING_X = PADDING_X;
    int TIMER_PADDING_Y = 20;
    /***** 计时器标签 *****/
    int TIMER_LABEL_WIDTH = 170;
    int TIMER_LABEL_HEIGHT = 25;

    /***** 任务面板属性 *****/
    int TASK_PANEL_X = 0;
    int TASK_PANEL_Y = PADDING_Y + TIMER_PANEL_HEIGHT;
    int TASK_PANEL_WIDTH = 180;
    int TASK_PANEL_HEIGHT = 80;
    int TASK_PADDING_X = PADDING_X;
    int TASK_PADDING_Y = 20;
    /***** 任务标签 *****/
    int TASK_LABEL_WIDTH = 28;
    int TASK_LABEL_HEIGHT = 25;
    /***** 任务输入框 *****/
    int TASK_INPUT_X = TASK_PADDING_X + TASK_LABEL_WIDTH;
    int TASK_INPUT_Y = TASK_PADDING_Y;
    int TASK_INPUT_WIDTH = 110;
    int TASK_INPUT_HEIGHT = 25;
    int TASK_INPUT_FONT_SIZE = 11;
    /***** 任务时间单位 *****/
    int TASK_TIME_UNIT_WIDTH = 30;
    int TASK_TIME_UNIT_HEIGHT = TASK_LABEL_HEIGHT;
    /***** 任务添加按钮 *****/
    int TASK_BUTTON_X = 145;
    int TASK_BUTTON_Y = TASK_PADDING_Y;
    int TASK_BUTTON_WIDTH = 30;
    int TASK_BUTTON_HEIGHT = 48;
    int TASK_BUTTON_FONT_SIZE = 10;
    /***** 任务列表 *****/
    int TASK_LIST_X = 0;
    int TASK_LIST_Y = TASK_PANEL_Y + TASK_PANEL_HEIGHT;
    int TASK_LIST_WIDTH = 180;
    int TASK_LIST_HEIGHT = 25;
    int TASK_ITEM_LABEL_HEIGHT = 16;

}
