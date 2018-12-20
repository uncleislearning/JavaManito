package com.xiao.JAVAManito.effective.safe;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by unclexiao on 17/05/2018.
 *
 * 这里VisualComponent的线程安全 委托给keyListeners状态变量以及mouseListeners状态变量
 *
 * 注意到这里的两个状态变量之间是没有关系的
 */
public class VisualComponent {
    private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<>();
    private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<>();

    public void addKeyListener(KeyListener keyListener){
        this.keyListeners.add(keyListener);
    }

    public void addMouseListener(MouseListener mouseListener){
        this.mouseListeners.add(mouseListener);
    }

}
