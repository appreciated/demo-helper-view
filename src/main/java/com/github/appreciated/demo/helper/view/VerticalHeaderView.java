package com.github.appreciated.demo.helper.view;

import com.github.appreciated.demo.helper.view.design.VerticalHeaderDesign;

public class VerticalHeaderView extends VerticalHeaderDesign {

    public VerticalHeaderView(String header, String description, String resource) {
        this.header.setText(header);
        if (description != null) {
            this.subtitle.setText(description);
        } else {
            this.subtitle.setVisible(false);
        }
        if (resource != null) {
            image.setSrc(resource);
        } else {
            image.setVisible(false);
        }

    }
}
