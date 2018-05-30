package com.github.appreciated.demo.helper.view.paragraph;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ParagraphView extends VerticalLayout {
    private Label headerLabel;
    private Label descriptionLabel;

    public ParagraphView() {
        headerLabel = new Label();
        descriptionLabel = new Label();
        add(headerLabel, descriptionLabel);
    }

    public ParagraphView(String header, String description) {
        this();
        getHeaderLabel().setText(header);
        if (description != null) {
            getDescriptionLabel().setText(description);
        } else {
            setVisible(false);
        }
        setAlignItems(Alignment.CENTER);
    }

    public ParagraphView(String header, String description, Component[] components) {
        this(header, description);
        add(components);
    }

    public Label getHeaderLabel() {
        return headerLabel;
    }

    public ParagraphView(String header) {
        this(header, (String) null);
    }

    public Label getDescriptionLabel() {
        return descriptionLabel;
    }

    public ParagraphView(String header, Component[] components) {
        this(header, null, components);
    }

}
