package com.github.appreciated.demo.helper.view;

import com.github.appreciated.demo.helper.view.design.ImageParagraphDesign;

public class ImageParagraphView extends ImageParagraphDesign {
    public ImageParagraphView(String header, String description, String resource) {
        getHeaderLabel().setText(header);
        getDescriptionLabel().setText(description);
        getImage().setSrc(resource);
    }
}
