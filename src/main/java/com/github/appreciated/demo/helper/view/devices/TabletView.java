package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TabletView extends VerticalLayout implements DeviceView {

    public TabletView(Orientation orientation) {
        getElement().getClassList().add(orientation == Orientation.PORTRAIT ? "tablet-view" : "vertical-tablet-view");
    }

    public TabletView(Component component) {
        this(Orientation.PORTRAIT);
        setSizeUndefined();
        add(component);
    }

}
