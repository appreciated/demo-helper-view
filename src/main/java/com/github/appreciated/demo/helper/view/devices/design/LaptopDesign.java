package com.github.appreciated.demo.helper.view.devices.design;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class LaptopDesign extends VerticalLayout {
    private VerticalLayout laptopContent = new VerticalLayout();
    private Div deviceWrapper = new Div(laptopContent);

    public LaptopDesign() {
        deviceWrapper.getElement().getClassList().add("laptop-view");
    }

    public Div getDeviceWrapper() {
        return deviceWrapper;
    }

    public VerticalLayout getLaptopContent() {
        return laptopContent;
    }

}
