package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.devices.Device;
import com.vaadin.flow.component.html.Div;

public class DevicesParagraphView extends Div {

    public DevicesParagraphView(Device largeDevice, Device smallDevice) {
        add(largeDevice);
        add(smallDevice);
        getStyle()
                .set("display", "flex")
                .set("justify-content", "space-evenly")
                .set("align-items", "flex-end")
                .set("flex-wrap", "wrap");
        setWidth("100%");

        smallDevice.getStyle()
                .set("margin-left", "20px")
                .set("margin-right", "20px");
        largeDevice.getStyle()
                .set("margin-left", "20px").
                set("margin-right", "20px");
    }

    public DevicesParagraphView() {
    }
}

