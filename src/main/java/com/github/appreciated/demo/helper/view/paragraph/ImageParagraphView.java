package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.layout.FlexLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ImageParagraphView extends FlexLayout {

    private VerticalLayout textWrapper = new VerticalLayout();
    private H2 headerLabel = new H2();
    private Label descriptionLabel = new Label();
    private Image image = new Image();

    public ImageParagraphView() {
        textWrapper.add(headerLabel, descriptionLabel);
        textWrapper.setAlignItems(Alignment.CENTER);
        textWrapper.getStyle().set("max-width", "630px");
        add(textWrapper, image);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setFlexWrap(FlexWrap.WRAP);
        setWidth("100%");
    }

    public ImageParagraphView(String header, String description, String resource) {
        this();
        headerLabel.setText(header);
        descriptionLabel.setText(description);
        image.setSrc(resource);
    }

    public H2 getHeaderLabel() {
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
