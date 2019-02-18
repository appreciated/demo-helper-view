package com.github.appreciated.demo.helper.view.paragraph;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ParagraphView extends VerticalLayout {
    private H2 headerLabel = new H2();
    private Label descriptionLabel = new Label();

    public ParagraphView() {
        add(headerLabel, descriptionLabel);
    }

    public ParagraphView(String header, String description) {
        this();
        getHeaderLabel().setText(header);
        add(headerLabel);
        if (description != null) {
            getDescriptionLabel().setText(description);
            add(descriptionLabel);
        } else {
            descriptionLabel.setVisible(false);
        }
        setAlignItems(Alignment.CENTER);
    }

    public ParagraphView(String header, String description, Component[] components) {
        this(header, description);
        add(components);
    }

    public H2 getHeaderLabel() {
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
