package com.github.appreciated.demo.helper.view.design;

import com.vaadin.server.Resource;

public class HeaderView extends HeaderDesign {

    public HeaderView(String header, String description, Resource resource) {
        this.header.setValue(header);
        if (description != null) {
            this.subtitle.setValue(description);
        } else {
            this.subtitle.setVisible(false);
        }
        if (resource != null) {
            image.setSource(resource);
        } else {
            image.setVisible(false);
        }

    }
}
