package com.github.appreciated.demo.helper.view;

import com.github.appreciated.demo.helper.view.design.TextContentDesign;

public class TextContentView extends TextContentDesign {

    public TextContentView(String header, String description) {
        getHeaderLabel().setValue(header);
        getDescriptionLabel().setValue(description);
    }

}
