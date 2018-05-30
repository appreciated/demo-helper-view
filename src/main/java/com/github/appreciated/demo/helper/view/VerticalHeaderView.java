package com.github.appreciated.demo.helper.view;

import com.github.appreciated.demo.helper.view.design.VerticalHeaderDesign;

public class VerticalHeaderView extends VerticalHeaderDesign {

    public VerticalHeaderView(String header, String description, String resource) {
        this.getHeader().setText(header);
        if (description != null) {
            this.getSubtitle().setText(description);
        } else {
            this.getSubtitle().setVisible(false);
        }
        if (resource != null) {
            getImage().setSrc(resource);
        } else {
            getImage().setVisible(false);
        }
    }
}
