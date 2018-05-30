package com.github.appreciated.demo.helper.view.design;


import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ParagraphDesign extends VerticalLayout {
    private Label headerLabel;
    private Label descriptionLabel;

    public ParagraphDesign() {
        headerLabel = new Label();
        descriptionLabel = new Label();
        add(headerLabel, descriptionLabel);
    }

    public Label getHeaderLabel() {
        return headerLabel;
    }

    public Label getDescriptionLabel() {
        return descriptionLabel;
    }

}
