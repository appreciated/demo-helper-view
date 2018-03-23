package com.github.appreciated.demo.helper.view;

import com.github.appreciated.demo.helper.view.design.ImageContentDesign;
import com.vaadin.server.Resource;

public class ImageContentView extends ImageContentDesign {
    public ImageContentView(String header, String description, Resource resource) {
        getHeaderLabel().setValue(header);
        getDescriptionLabel().setValue(description);
        getImage().setSource(resource);
    }
}
