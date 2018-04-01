package com.github.appreciated.demo.helper.view.devices;

import com.github.appreciated.demo.helper.view.devices.design.TabletAndPhoneDesign;
import com.vaadin.ui.Component;

public class TabletAndPhoneView extends TabletAndPhoneDesign {
    public TabletAndPhoneView(Component tabletContent, Component phoneContent) {
        getTabletContent().setContent(tabletContent);
        getPhoneContent().setContent(phoneContent);
    }

    boolean isSizeFull(Component component) {
        return component.getHeight() == 100f && component.getHeightUnits() == Unit.PERCENTAGE &&
                component.getWidth() == 100f && component.getWidthUnits() == Unit.PERCENTAGE;
    }

    public TabletAndPhoneView() {
    }
}
