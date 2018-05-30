package com.github.appreciated.demo.helper.view.paragraph;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ImageParagraphView extends HorizontalLayout {

    private VerticalLayout textWrapper = new VerticalLayout();
    private Label headerLabel = new Label();
    private Label descriptionLabel = new Label();
    private Image image = new Image();

    public ImageParagraphView() {
        textWrapper.add(headerLabel, descriptionLabel);
        add(textWrapper, image);
        setAlignItems(Alignment.CENTER);
        setSizeFull();
    }

    public ImageParagraphView(String header, String description, String resource) {
        this();
        headerLabel.setText(header);
        descriptionLabel.setText(description);
        image.setSrc(resource);
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
