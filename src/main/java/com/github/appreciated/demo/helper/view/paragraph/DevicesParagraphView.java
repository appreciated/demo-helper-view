package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.devices.DeviceView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;

public class DevicesParagraphView extends Div {

    public DevicesParagraphView(DeviceView largeDevice, DeviceView smallDevice) {
        add((Component) largeDevice);
        add((Component) smallDevice);
        getElement().getStyle()
                .set("display", "flex")
                .set("justify-content", "space-around")
                .set("align-items", "flex-end")
                .set("flex-wrap", "wrap");
        setWidth("100%");

        smallDevice.getElement().getStyle().set("margin-top", "40px").set("margin-left", "20px").set("margin-right", "20px");
        largeDevice.getElement().getStyle().set("margin-left", "20px").set("margin-right", "20px");
    }

    public DevicesParagraphView() {
    }
}
