package com.github.appreciated.demo.helper.view.design;


import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ParagraphDesign extends VerticalLayout {
    private Label headerLabel;
    private HorizontalLayout descriptionWrapper;
    private Label descriptionLabel;

    public Label getHeaderLabel() {
        return headerLabel;
    }

    public HorizontalLayout getDescriptionWrapper() {
        return descriptionWrapper;
    }

    public Label getDescriptionLabel() {
        return descriptionLabel;
    }

}
