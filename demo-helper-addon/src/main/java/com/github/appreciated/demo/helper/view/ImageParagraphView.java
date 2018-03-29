package com.github.appreciated.demo.helper.view;

import com.github.appreciated.demo.helper.view.design.ImageParagraphDesign;
import com.vaadin.server.Resource;

public class ImageParagraphView extends ImageParagraphDesign {
    public ImageParagraphView(String header, String description, Resource resource) {
        getHeaderLabel().setValue(header);
        getDescriptionLabel().setValue(description);
        getImage().setSource(resource);
    }
}
