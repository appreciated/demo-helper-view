package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;

import java.util.Arrays;

public class Device extends Div implements HasOrientation {
    public Device() {
        getClassNames().add("device");
        changeToPhone();
        getStyle().set("position", "relative");
    }

    public Device(Component component) {
        this();
        add(component);
    }

    public void changeToPhone() {
        changeTo("phone");
    }

    public void changeToTablet() {
        changeTo("tablet");
    }

    public void changeToLaptop() {
        changeTo("laptop");
    }

    public void changeTo(String... classNames) {
        getClassNames().removeAll(Arrays.asList("phone", "tablet", "laptop", "landscape"));
        for (String className : classNames) {
            getClassNames().add(className);
        }
    }

    public void withFloatingButton(Component icon, ComponentEventListener<ClickEvent<Button>> listner) {
        Button button = new Button(icon, listner);
        button.getStyle()
                .set("position", "absolute")
                .set("transition", "all 0.3s ease")
                .set("color", "var(--lumo-primary-contrast-color)")
                .set("right", "calc(var(--button-padding) + 4px)")
                .set("opacity", "var(--button-opacity)")
                .set("box-shadow", "var(--lumo-box-shadow-m)")
                .set("background", "var(--lumo-primary-color)")
                .set("border-radius", "100%")
                .set("bottom", "var(--button-padding)");
        button.setWidth("45px");
        button.setHeight("45px");
        add(button);
    }
}
