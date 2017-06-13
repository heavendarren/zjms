package com.tfkj.zongjiao.panel;

import com.tfkj.zongjiao.entity.RelgPer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wangqingxiang on 2017/5/22.
 */
public class DataFromPanel  extends Container implements ActionListener {
    protected RelgPer relgPer;

    public void setRelgPer(RelgPer relgPer) {
        this.relgPer = relgPer;
    }

    public RelgPer getRelgPer() {
        return relgPer;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
