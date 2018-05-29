package com.github.appreciated.demo.helper.view;

import com.github.appreciated.demo.helper.view.design.HorizontalHeaderDesign;
import com.vaadin.flow.component.Component;

import java.util.Arrays;

public class HorizontalHeaderView extends HorizontalHeaderDesign {

    public HorizontalHeaderView(String header, String description, String resource) {
        this.header.setText(header);
        if (description != null) {
            this.subtitle.setText(description);
        } else {
            this.descriptionWrapper.setVisible(false);
        }
        if (resource != null) {
            image.setSrc(resource);
        } else {
            image.setVisible(false);
        }
    }

    public HorizontalHeaderView(String header, String description, String image, Component[] components) {
        this(header, description, image);
        if (components != null && components.length > 0) {
            componentWrapper.setVisible(true);
            Arrays.stream(components).forEach(componentHolder::add);
        }
    }
}
