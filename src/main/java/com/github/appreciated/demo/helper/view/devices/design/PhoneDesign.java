package com.github.appreciated.demo.helper.view.devices.design;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class PhoneDesign extends VerticalLayout {
    private Div deviceWrapper;
    private VerticalLayout phoneContent;
    private HorizontalLayout labelHolder;
    private Label label;

    public Div getDeviceWrapper() {
        return deviceWrapper;
    }

    public VerticalLayout getPhoneContent() {
        return phoneContent;
    }

    public HorizontalLayout getLabelHolder() {
        return labelHolder;
    }

    public Label getLabel() {
        return label;
    }

}
