package com.github.appreciated.demo.helper.view.devices;

import com.github.appreciated.demo.helper.view.devices.design.TabletAndPhoneDesign;
import com.vaadin.ui.Component;

public class TabletAndPhoneView extends TabletAndPhoneDesign {
    public TabletAndPhoneView(Component tabletContent, Component phoneContent) {
        getTabletContent().setContent(tabletContent);
        getHandheldContent().setContent(phoneContent);
    }

    public TabletAndPhoneView() {
    }
}
