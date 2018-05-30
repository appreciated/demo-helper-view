package com.github.appreciated.demo.helper.view.devices.design;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


public class TabletDesign extends VerticalLayout {
    private Div deviceWrapper = new Div();
    private VerticalLayout tabletContent = new VerticalLayout();

    public TabletDesign() {
        getElement().getClassList().add("tablet-view");
    }

    public Div getDeviceWrapper() {
        return deviceWrapper;
    }

    public VerticalLayout getTabletContent() {
        return tabletContent;
    }

}
