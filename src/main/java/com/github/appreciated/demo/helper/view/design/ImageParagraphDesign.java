package com.github.appreciated.demo.helper.view.design;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ImageParagraphDesign extends HorizontalLayout {

    private VerticalLayout textWrapper = new VerticalLayout();
    private Label headerLabel = new Label();
    private Label descriptionLabel = new Label();
    private Image image = new Image();

    public ImageParagraphDesign() {
        textWrapper.add(headerLabel, descriptionLabel);
        add(textWrapper, image);
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

    public VerticalLayout getTextWrapper() {
        return textWrapper;
    }
}
