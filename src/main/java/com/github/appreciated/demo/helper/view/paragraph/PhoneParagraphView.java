package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.devices.PhoneView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class PhoneParagraphView extends Div {
    private PhoneView phoneView = new PhoneView();
    private H3 label = new H3();
    private HorizontalLayout labelHolder = new HorizontalLayout(label);

    public PhoneParagraphView(Component content) {
        this();
        getPhoneView().add(content);
        getLabel().setVisible(true);
    }

    public PhoneParagraphView(Component content, String description) {
        this(content);
        if (description == null) {
            getLabel().setVisible(true);
        } else {
            getLabel().setText(description);
        }
    }

    public PhoneParagraphView() {
        add(phoneView, labelHolder);
        getElement().getStyle()
                .set("display", "flex")
                .set("justify-content", "space-around")
                .set("align-items", "center")
                .set("flex-wrap", "wrap");
        setWidth("100%");
    }

    public VerticalLayout getPhoneView() {
        return phoneView;
    }

    public HorizontalLayout getLabelHolder() {
        return labelHolder;
    }

    public H3 getLabel() {
        return label;
    }

}
