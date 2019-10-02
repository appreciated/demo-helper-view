package com.github.appreciated.demo.helper.view.devices;

import com.github.appreciated.calc.color.helper.CalculatedColorHelper;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.dom.impl.ImmutableEmptyStyle;

import java.util.Objects;

@NpmPackage(value = "marvel-devices.css", version = "1.0.0")
@CssImport("marvel-devices.css/assets/devices.min.css")
public abstract class Device<T> extends FluentDiv implements HasOrientation<T> {
    private final Component content;

    public Device(Component component) {
        Objects.requireNonNull(component);
        this.content = component;
        Style style = component.getElement().getStyle();
        if (!(style instanceof ImmutableEmptyStyle)) {
            style.set("width", "100%")
                    .set("height", "100%");
        }
        getElement().getStyle()
                .set("flex-shrink", "0")
                .set("transition", "scale 0.1s")
                .set("transform", "scale(" + getMaxScale() + ")");
    }

    protected abstract double getMaxScale();

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

    abstract String[] getColors();

    public Component getContent() {
        return content;
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        Page page = attachEvent.getUI().getPage();
        page.addBrowserWindowResizeListener(event -> setScale(event.getWidth()));
    }

    private void setScale(int currentWidth) {
        getElement().getStyle()
                .set("transform", "scale(" + getDesiredScale(currentWidth) + ")")
                .set("margin-top", "-" + ((100 - (getDesiredScale(currentWidth) * 100)) / 2) + "%")
                .set("margin-bottom", "-" + ((100 - (getDesiredScale(currentWidth) * 100)) / 2) + "%");
    }

    private double getDesiredScale(int currentWidth) {
        return Math.min(((double) currentWidth / (double) getMaxDeviceWidth()) * 0.9, getMaxScale());
    }

    protected abstract int getMaxDeviceWidth();

    abstract public Orientation[] hasOrientation();
}
