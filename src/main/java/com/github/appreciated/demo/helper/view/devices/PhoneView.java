package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class PhoneView extends VerticalLayout {

    public PhoneView(Component content) {
        this();
        add(content);
    }

    public PhoneView() {
        getElement().getClassList().add("phone-view");
    }

}
