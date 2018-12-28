package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.devices.DeviceView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class DeviceParagraphView extends Div {
    private DeviceView deviceView;
    private H3 label = new H3();
    private HorizontalLayout labelHolder = new HorizontalLayout(label);

    public DeviceParagraphView(DeviceView content) {
        deviceView = content;
        add((Component) deviceView, labelHolder);
        getElement().getStyle()
                .set("display", "flex")
                .set("justify-content", "center")
                .set("align-items", "center")
                .set("flex-wrap", "wrap");
        setWidth("100%");
        getLabel().setVisible(true);
        getDeviceView().getElement().getStyle().set("margin", "40px");
        getLabel().getStyle().set("margin", "40px");
    }

    public DeviceParagraphView(DeviceView content, String description) {
        this(content);
        if (description == null) {
            getLabel().setVisible(true);
        } else {
            getLabel().setText(description);
        }
    }

    public DeviceView getDeviceView() {
        return deviceView;
    }

    public HorizontalLayout getLabelHolder() {
        return labelHolder;
    }

    public H3 getLabel() {
        return label;
    }

}
