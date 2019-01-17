package com.github.appreciated.demo.helper.view.components;

import com.github.appreciated.papermenubutton.PaperMenuButton;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.textfield.TextField;

public class PaperMenuPicker extends PaperMenuButton {
    private final TextField tf;

    public PaperMenuPicker(Component button, Component content) {
        super(new TextField(), content);
        tf = (TextField) getButton();
    }
}
