package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.devices.PhoneView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class PhoneParagraphView extends Div {
    private PhoneView phoneContent = new PhoneView();
    private Label label = new Label();
    private HorizontalLayout labelHolder = new HorizontalLayout(label);

    public PhoneParagraphView(Component content) {
        this();
        getPhoneContent().add(content);
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
        add(phoneContent, labelHolder);
        getElement().getStyle()
                .set("display", "flex")
                .set("justify-content", "space-around")
                .set("align-items", "center")
                .set("flex-wrap", "wrap");
        setWidth("100%");
    }

    public VerticalLayout getPhoneContent() {
        return phoneContent;
    }

    public HorizontalLayout getLabelHolder() {
        return labelHolder;
    }

    public Label getLabel() {
        return label;
    }

}
