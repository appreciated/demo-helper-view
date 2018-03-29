package com.github.appreciated.demo.helper.view;

import com.github.appreciated.demo.helper.view.design.TextContentDesign;

public class ParagraphView extends TextContentDesign {

    public ParagraphView(String header, String description) {
        getHeaderLabel().setValue(header);
        getDescriptionLabel().setValue(description);
    }

}
