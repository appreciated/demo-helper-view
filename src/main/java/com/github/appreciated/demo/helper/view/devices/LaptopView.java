package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class LaptopView extends VerticalLayout {
    public LaptopView(Component content) {
        this();
        add(content);
    }

    public LaptopView() {
        getElement().getClassList().add("laptop-view");
    }
}

