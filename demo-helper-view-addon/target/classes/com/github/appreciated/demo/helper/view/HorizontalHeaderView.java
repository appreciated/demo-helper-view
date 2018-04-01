package com.github.appreciated.demo.helper.view;

import com.github.appreciated.demo.helper.view.design.HorizontalHeaderDesign;
import com.vaadin.server.Resource;
import com.vaadin.ui.Component;

import java.util.Arrays;

public class HorizontalHeaderView extends HorizontalHeaderDesign {

    public HorizontalHeaderView(String header, String description, Resource resource) {
        this.header.setValue(header);
        if (description != null) {
            this.subtitle.setValue(description);
        } else {
            this.descriptionWrapper.setVisible(false);
        }
        if (resource != null) {
            image.setSource(resource);
        } else {
            image.setVisible(false);
        }
    }

    public HorizontalHeaderView(String header, String description, Resource image, Component[] components) {
        this(header, description, image);
        if (components != null && components.length > 0) {
            componentWrapper.setVisible(true);
            Arrays.stream(components).forEach(componentHolder::addComponent);
        }
    }
}
