package com.github.appreciated.demo.helper.view.devices;

import com.github.appreciated.demo.helper.view.devices.design.PhoneDesign;
import com.vaadin.flow.component.Component;

public class PhoneView extends PhoneDesign {

    public PhoneView(Component content) {
        getPhoneContent().add(content);
        getLabel().setVisible(true);
    }

    public PhoneView(Component content, String description) {
        this(content);
        if (description == null) {
            getLabel().setVisible(true);
        } else {
            getLabel().setText(description);
        }
    }

    public PhoneView() {
    }


}
