package com.github.appreciated.demo.helper.view.design;


import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class VerticalHeaderDesign extends VerticalLayout {
    private Image image = new Image();
    private Label header = new Label();
    private Label subtitle = new Label();

    public VerticalHeaderDesign() {
        add(image, header, subtitle);
    }

    public Image getImage() {
        return image;
    }

    public Label getHeader() {
        return header;
    }

    public Label getSubtitle() {
        return subtitle;
    }
}
