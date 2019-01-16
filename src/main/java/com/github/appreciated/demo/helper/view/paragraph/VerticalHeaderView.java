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
        this.headerLabel.setText(header);
        this.headerLabel.setWidth("100%");
        this.headerLabel.getStyle()
                .set("text-align", "center")
                .set("overflow", "hidden")
                .set("text-overflow", "ellipsis");
        if (description != null) {
            this.getSubtitleLabel().setText(description);
        } else {
            this.getSubtitleLabel().setVisible(false);
        }
        if (resource != null) {
            getImage().setSrc(resource);
            image.setWidth("256px");
            image.setHeight("256px");
            image.getElement().getClassList().add("onload-animated");
        } else {
            getImage().setVisible(false);
        }
        add(image, headerLabel, subtitleLabel);
        setAlignItems(Alignment.CENTER);
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
