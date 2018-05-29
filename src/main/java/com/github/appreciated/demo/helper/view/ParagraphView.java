package com.github.appreciated.demo.helper.view;

import com.github.appreciated.demo.helper.view.design.ParagraphDesign;
import com.vaadin.flow.component.Component;

import java.util.Arrays;

public class ParagraphView extends ParagraphDesign {

    public ParagraphView(String header, String description) {
        getHeaderLabel().setText(header);
        if (description != null) {
            getDescriptionLabel().setText(description);
        } else {
            getDescriptionWrapper().setVisible(false);
        }
    }

    public ParagraphView(String header) {
        this(header, (String) null);
    }

    public ParagraphView(String header, String description, Component[] components) {
        this(header, description);
        if (components != null && components.length > 0) {
            Arrays.stream(components).forEach(c -> {
                add(c);
                //TODO setComponentAlignment(c, Alignment.TOP_CENTER);
            });
        }
    }

    public ParagraphView(String header, Component[] components) {
        this(header, null, components);
    }

}
