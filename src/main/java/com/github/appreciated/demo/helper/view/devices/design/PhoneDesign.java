package com.github.appreciated.demo.helper.view.devices.design;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class PhoneDesign extends VerticalLayout {
    private VerticalLayout phoneContent = new VerticalLayout();
    private Div deviceWrapper = new Div(phoneContent);
    private Label label = new Label();
    private HorizontalLayout labelHolder = new HorizontalLayout(label);

    public PhoneDesign() {
        deviceWrapper.getElement().getClassList().add("phone-view");
        add(deviceWrapper, labelHolder);
    }

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
