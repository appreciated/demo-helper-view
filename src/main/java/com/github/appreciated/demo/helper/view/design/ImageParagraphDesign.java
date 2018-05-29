package com.github.appreciated.demo.helper.view.design;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ImageParagraphDesign extends VerticalLayout {
    private VerticalLayout contentHolder;
    private Label headerLabel;
    private Label descriptionLabel;
    private Image image;

    public VerticalLayout getContentHolder() {
        return contentHolder;
    }

    public Label getHeaderLabel() {
        return headerLabel;
    }

    public Label getDescriptionLabel() {
        return descriptionLabel;
    }

    public Image getImage() {
        return image;
    }

}
