package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TabletView extends VerticalLayout {

    public TabletView() {
        getElement().getClassList().add("tablet-view");
    }

    public TabletView(Component component) {
        this();
        add(component);
    }

}
