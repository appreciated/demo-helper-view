package com.github.appreciated.demo.helper.view.devices;

import com.github.appreciated.demo.helper.view.devices.design.TabletAndPhoneDesign;
import com.vaadin.flow.component.Component;

public class TabletAndPhoneView extends TabletAndPhoneDesign {
    public TabletAndPhoneView(Component tabletContent, Component phoneContent) {
        getTabletContent().add(tabletContent);
        getPhoneContent().add(phoneContent);
    }

    public TabletAndPhoneView() {
    }
}
