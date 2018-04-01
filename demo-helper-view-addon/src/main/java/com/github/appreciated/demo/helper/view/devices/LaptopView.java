package com.github.appreciated.demo.helper.view.devices;

import com.github.appreciated.demo.helper.view.devices.design.LaptopDesign;
import com.vaadin.ui.Component;

public class LaptopView extends LaptopDesign {
    public LaptopView(Component content) {
        getTabletContent().setContent(content);
    }

    public LaptopView() {
    }

}
