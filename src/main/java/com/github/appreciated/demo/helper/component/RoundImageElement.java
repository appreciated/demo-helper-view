package com.github.appreciated.demo.helper.component;

import com.github.appreciated.card.RippleClickableCard;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class RoundImageElement extends VerticalLayout {
    public RoundImageElement(String imagePath, String alt, String name) {
        this(imagePath, alt, name, null);
    }

    public RoundImageElement(String imagePath, String alt, String name, ComponentEventListener listener) {
        Image img = new Image(imagePath, alt);
        img.setWidth("70px");
        img.setHeight("70px");
        RippleClickableCard imgWrapper = new RippleClickableCard(img);
        imgWrapper.setElevationOnActionEnabled(true);
        imgWrapper.setElevation(1);
        imgWrapper.setBorderRadius("70px");
        if (listener != null) {
            imgWrapper.addClickListener(listener);
        }
        Label txt = new Label(name);
        txt.setWidthFull();
        txt.getStyle().set("overflow", "hidden").set("text-overflow", "ellipsis").set("text-align", "center");
        add(imgWrapper, txt);
        setSizeUndefined();
        setPadding(false);
        setMargin(false);
        setSpacing(false);
        getStyle().set("overflow", "hidden");
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(CENTER);
    }
}
