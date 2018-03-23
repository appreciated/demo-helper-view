package com.github.appreciated.demo.helper.view.devices;

import com.github.appreciated.demo.helper.view.devices.design.HandheldDesign;
import com.vaadin.ui.Component;

public class HandheldView extends HandheldDesign {

    public HandheldView(Component content) {
        getHandheldContent().setContent(content);
        getLabel().setVisible(true);
    }

    public HandheldView(Component content, String description) {
        this(content);
        if (description == null) {
            getLabel().setVisible(true);
        } else {
            getLabel().setValue(description);
        }
    }


    public HandheldView() {
    }


}
