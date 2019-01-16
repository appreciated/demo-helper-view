package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.layout.FlexLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Arrays;

public class HorizontalHeaderParagraphView extends FlexLayout {
    protected Image image = new Image();
    protected HorizontalLayout imageWrapper = new HorizontalLayout(image);
    protected H1 header = new H1();
    protected Label subtitle = new Label();
    protected Div componentHolder = new Div();
    protected VerticalLayout descriptionWrapper = new VerticalLayout(header, subtitle, componentHolder);


    public HorizontalHeaderParagraphView(String header, String description, String resource) {
        this.header.setText(header);
        this.header.setWidth("100%");
        this.header.getStyle()
                .set("overflow", "hidden")
                .set("text-overflow", "ellipsis");
        if (description != null) {
            this.subtitle.setText(description);
        } else {
            this.descriptionWrapper.setVisible(false);
        }
        if (resource != null) {
            image.setSrc(resource);
            image.getElement().getClassList().add("onload-animated");
        } else {
            image.setVisible(false);
        }
        add(imageWrapper, descriptionWrapper);
        image.setWidth("300px");
        image.setHeight("300px");
        imageWrapper.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        descriptionWrapper.setWidth("100%");
        descriptionWrapper.getStyle().set("max-width", "630px");
        setJustifyContentMode(JustifyContentMode.CENTER);
        setFlexWrap(FlexWrap.WRAP);
        setWidth("100%");
    }

    public HorizontalHeaderParagraphView(String header, String description, String image, Component[] components) {
        this(header, description, image);
        if (components != null && components.length > 0) {
            setVisible(true);
            Arrays.stream(components).forEach(componentHolder::add);
        }
    }

    public Image getImage() {
        return image;
    }

    public H1 getHeader() {
        return header;
    }

    public VerticalLayout getDescriptionWrapper() {
        return descriptionWrapper;
    }

    public Label getSubtitle() {
        return subtitle;
    }

    public Div getComponentHolder() {
        return componentHolder;
    }
}