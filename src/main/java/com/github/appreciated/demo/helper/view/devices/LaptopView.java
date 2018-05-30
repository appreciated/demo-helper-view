package com.github.appreciated.demo.helper.view.devices;

import com.github.appreciated.demo.helper.view.devices.design.LaptopDesign;
import com.vaadin.flow.component.Component;

public class LaptopView extends LaptopDesign {
    public LaptopView(Component content) {
        getLaptopContent().add(content);
    }

    public LaptopView() {
    }

}
