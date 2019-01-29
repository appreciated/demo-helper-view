package com.github.appreciated.demo.helper;

import com.github.appreciated.demo.helper.view.components.layout.SinglePageLayout;
import com.github.appreciated.demo.helper.view.devices.Device;
import com.github.appreciated.demo.helper.view.devices.DeviceSwitchView;
import com.github.appreciated.demo.helper.view.devices.DeviceType;
import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.demo.helper.view.entity.CssVariable;
import com.github.appreciated.demo.helper.view.paragraph.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.StyleSheet;

import java.util.Arrays;

@StyleSheet("com/github/appreciated/demo-helper/demo-helper.css")
public class DemoHelperView extends SinglePageLayout {

    private int counter = 1;

    public DemoHelperView() {
        getElement().setAttribute("theme", "spacing-xl");
        getElement().getStyle().set("--flex-layout-space", "3rem");
    }

    public DemoHelperView withVerticalHeader(String header) {
        return withVerticalHeader(header, null, null);
    }

    public DemoHelperView withVerticalHeader(String header, String description, String image) {
        addHeader(new VerticalHeaderView(header, description, image));
        return this;
    }

    private void addHeader(Component component) {
        addFullHeightComponent(component).getElement().getClassList().add("content-wrapper-small");
    }

    public DemoHelperView withHorizontalHeader(String header, String description) {
        return withHorizontalHeader(header, description, null);
    }

    public DemoHelperView withHorizontalHeader(String header, String description, String image) {
        addHeader(new HorizontalHeaderParagraphView(header, description, image));
        return this;
    }

    public DemoHelperView withHorizontalHeader(String header) {
        return withHorizontalHeader(header, null, null);
    }

    public DemoHelperView withDevice(Device device, String s) {
        addParagraph(new DeviceParagraphView(device, s));
        return this;
    }

    private void addParagraph(Component component) {
        add(component);
        component.getElement().getClassList().add("content-wrapper-small");
    }

    @Override
    public void add(Component... components) {
        super.add(components);
        Arrays.stream(components).forEach(component -> {
            component.getElement().getStyle().set("flex-shrink", "0");
        });
    }

    public DemoHelperView withHorizontalHeader(String header, String description, String image, Component... components) {
        addHeader(new HorizontalHeaderParagraphView(header, description, image, components));
        return this;
    }

    public DemoHelperView withDevice(Device device) {
        add(new DeviceParagraphView(device));
        return this;
    }

    public DemoHelperView withStylableDevice(Component content, CssVariable... cssVariables) {
        withStylableDevice(content, DeviceType.PHONE, cssVariables);
        return this;
    }

    public DemoHelperView withStylableDevice(Component content, DeviceType type, CssVariable... cssVariables) {
        DeviceSwitchView view = new DeviceSwitchView(content);
        if (cssVariables.length > 0) {
            view.withStyleableVariables(cssVariables);
        }
        view.setDeviceType(type);
        add(view);
        return this;
    }

    public DemoHelperView withDevices(Device device1, Device device2) {
        addLargeParagraph(new DevicesParagraphView(device1, device2));
        return this;
    }

    private void addLargeParagraph(Component component) {
        add(component);
        component.getElement().getClassList().add("content-wrapper");
    }

    public DemoHelperView withParagraph(String header) {
        addParagraph(new ParagraphView(header));
        return this;
    }

    public DemoHelperView withParagraph(String header, Component... components) {
        addParagraph(new ParagraphView(header, components));
        return this;
    }

    public DemoHelperView withParagraph(String header, String description) {
        addParagraph(new ParagraphView(header, description));
        return this;
    }

    public DemoHelperView withParagraph(String header, String description, Component... components) {
        addParagraph(new ParagraphView(header, description, components));
        return this;
    }

    public DemoHelperView withImage(String header, String description, String resource) {
        addParagraph(new ImageParagraphView(header, description, resource));
        return this;
    }

    public DemoHelperView withStep(String title, String description, CodeExample... codeExamples) {
        addParagraph(new StepView(counter++, title, description, codeExamples));
        return this;
    }

    public DemoHelperView withCounterStep(int c) {
        counter = c;
        return this;
    }

    public DemoHelperView resetCounterStep() {
        counter = 1;
        return this;
    }

    public DemoHelperView withComponent(Component component) {
        add(component);
        return this;
    }
}
