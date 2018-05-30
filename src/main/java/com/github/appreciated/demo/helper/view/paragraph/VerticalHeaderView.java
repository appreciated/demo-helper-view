package com.github.appreciated.demo.helper.view.paragraph;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class VerticalHeaderView extends VerticalLayout {
    private Image image = new Image();
    private H1 headerLabel = new H1();
    private Label subtitleLabel = new Label();

    public VerticalHeaderView(String header, String description, String resource) {
        this.getHeaderLabel().setText(header);
        if (description != null) {
            this.getSubtitleLabel().setText(description);
        } else {
            this.getSubtitleLabel().setVisible(false);
        }
        if (resource != null) {
            getImage().setSrc(resource);
        } else {
            getImage().setVisible(false);
        }
        add(image, headerLabel, subtitleLabel);
        image.setWidth("256px");
        image.setHeight("256px");
        setAlignItems(Alignment.CENTER);
        setSizeFull();
    }

    public Image getImage() {
        return image;
    }

    H1 getHeaderLabel() {
        return headerLabel;
    }

    public Label getSubtitleLabel() {
        return subtitleLabel;
    }

}
