package com.github.appreciated.demo.helper.view.design;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class HorizontalHeaderDesign extends HorizontalLayout {
    protected Image image = new Image();
    protected Label header = new Label();
    protected Label subtitle = new Label();
    protected Div componentHolder = new Div();
    protected HorizontalLayout descriptionWrapper = new HorizontalLayout(header, subtitle, componentHolder);

    public HorizontalHeaderDesign() {
        add(image, descriptionWrapper);
    }

    public Image getImage() {
        return image;
    }

    public Label getHeader() {
        return header;
    }

    public HorizontalLayout getDescriptionWrapper() {
        return descriptionWrapper;
    }

    public Label getSubtitle() {
        return subtitle;
    }

    public Div getComponentHolder() {
        return componentHolder;
    }
}
