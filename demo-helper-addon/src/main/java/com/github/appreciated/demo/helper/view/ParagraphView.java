package com.github.appreciated.demo.helper.view;

import com.github.appreciated.demo.helper.view.design.ParagraphDesign;

public class ParagraphView extends ParagraphDesign {

    public ParagraphView(String header, String description) {
        getHeaderLabel().setValue(header);
        if (description != null) {
            getDescriptionLabel().setValue(description);
        } else {
            getDescriptionWrapper().setVisible(false);
        }
    }

    public ParagraphView(String header) {
        this(header, null);
    }
}
