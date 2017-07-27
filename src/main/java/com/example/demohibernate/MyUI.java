package com.example.demohibernate;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 * Created by phann on 7/26/2017.
 */
@Theme("mytheme")
@SpringUI
public class MyUI extends UI {

    private HomeUI homeUI=new HomeUI();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(homeUI);
    }
}
