package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class VerticalTabletView extends VerticalLayout {

    public VerticalTabletView() {

    }

    public VerticalTabletView(Component component) {
        this();
        setSizeUndefined();
        setMargin(false);
        setPadding(false);
        add(component);
    }

}
