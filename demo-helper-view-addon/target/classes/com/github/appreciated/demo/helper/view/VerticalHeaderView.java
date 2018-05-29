package com.github.appreciated.demo.helper.view;

import com.github.appreciated.demo.helper.view.design.VerticalHeaderDesign;
import com.vaadin.server.Resource;

public class VerticalHeaderView extends VerticalHeaderDesign {

    public VerticalHeaderView(String header, String description, Resource resource) {
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
