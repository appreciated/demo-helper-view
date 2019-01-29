package com.github.appreciated.demo.helper.view.devices;

import com.github.appreciated.calc.color.helper.CalculatedColorHelper;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;

import java.util.Arrays;

public class Device<T> extends Div implements HasOrientation<T> {
    public Device(Component component) {
        this();
        add(component);
    }

    public Device() {
        getClassNames().add("device");
        changeToPhone();
        getStyle().set("position", "relative");
    }

    public void changeToPhone() {
        changeTo("phone");
    }

    public void changeTo(String... classNames) {
        getClassNames().removeAll(Arrays.asList("phone", "tablet", "laptop", "landscape"));
        for (String className : classNames) {
            getClassNames().add(className);
        }
    }

    public void changeToTablet() {
        changeTo("tablet");
    }

    public void changeToLaptop() {
        changeTo("laptop");
    }

    public Device withButton(Component icon, ComponentEventListener<ClickEvent<Button>> listner) {
        Button button = new Button(icon, listner);
        button.getStyle()
                .set("position", "absolute")
                .set("transition", "all 0.3s ease")
                .set("color", "var(--lumo-primary-contrast-color)")
                .set("right", "calc(var(--button-padding) + 4px)")
                .set("box-shadow", "var(--lumo-box-shadow-m)")
                .set("background", "var(--lumo-primary-color)")
                .set("border-radius", "100%")
                .set("bottom", "var(--button-padding)");
        button.setWidth("50px");
        button.setHeight("50px");
        add(button);
        return this;
    }

    public Device withCalculatedColorHelper(CalculatedColorHelper helper) {
        add(helper);
        return this;
    }
}
