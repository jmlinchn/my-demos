package cn.linjianming.timer;

import cn.linjianming.timer.controller.FrameController;

/**
 * @Author: James Lin
 * @Date: 2020/03/10 08:46
 */
public class StartApp {
    public static void main(String[] args) {
        new Thread(new FrameController()).start();
    }
}
