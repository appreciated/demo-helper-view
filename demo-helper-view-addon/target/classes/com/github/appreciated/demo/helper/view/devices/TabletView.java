package com.github.appreciated.demo.helper.view.devices;

import com.github.appreciated.demo.helper.view.devices.design.TabletDesign;
import com.vaadin.ui.Component;

public class TabletView extends TabletDesign {
    public TabletView(Component content) {
        getTabletContent().setContent(content);
    }

    public TabletView() {
    }

}
