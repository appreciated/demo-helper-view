package com.github.appreciated.demo.helper.view.devices.design;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TabletAndPhoneDesign extends VerticalLayout {
    private Div deviceWrapper;
    private VerticalLayout tabletContent;
    private VerticalLayout phoneContent;

    public Div getDeviceWrapper() {
        return deviceWrapper;
    }

    public VerticalLayout getTabletContent() {
        return tabletContent;
    }

    public VerticalLayout getPhoneContent() {
        return phoneContent;
    }

}
