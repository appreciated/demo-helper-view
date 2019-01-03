package com.github.appreciated.demo.helper;

import com.github.appreciated.demo.helper.view.devices.DeviceView;
import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.demo.helper.view.entity.CssVariable;
import com.github.appreciated.demo.helper.view.layout.FlexLayout;
import com.github.appreciated.demo.helper.view.other.CssVariableView;
import com.github.appreciated.demo.helper.view.paragraph.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.StyleSheet;

@StyleSheet("com/github/appreciated/demo-helper/demo-helper.css")
@HtmlImport("com/github/appreciated/demo-helper/dialog-full-size.html")
public class DemoHelperView extends FlexLayout {

    private int counter = 1;

    public DemoHelperView() {
        setMargin(false);
        setPadding(false);
        setSpacing(true);
        setAlignItems(Alignment.CENTER);
        setFlexDirection(FlexDirection.COLUMN);
        getElement().setAttribute("theme", "spacing-xl");
        getElement().getStyle().set("--flex-layout-space", "3rem").set("flex-shrink", "0");
        setSizeUndefined();
        setWidth("100%");
    }

    public DemoHelperView withVerticalHeader(String header, String description, String image) {
        addParagraph(new VerticalHeaderView(header, description, image));
        return this;
    }

    public DemoHelperView withVerticalHeader(String header) {
        return withVerticalHeader(header, null, null);
    }

    public DemoHelperView withHorizontalHeader(String header, String description) {
        return withHorizontalHeader(header, description, null);
    }

    public DemoHelperView withHorizontalHeader(String header) {
        return withHorizontalHeader(header, null, null);
    }

    public DemoHelperView withHorizontalHeader(String header, String description, String image) {
        addParagraph(new HorizontalHeaderParagraphView(header, description, image));
        return this;
    }

    public DemoHelperView withHorizontalHeader(String header, String description, String image, Component... components) {
        addParagraph(new HorizontalHeaderParagraphView(header, description, image, components));
        return this;
    }

    public DemoHelperView withDeviceParagraph(DeviceView phoneView, String s) {
        addParagraph(new DeviceParagraphView(phoneView, s));
        return this;
    }

    public DemoHelperView withDevice(DeviceView tabletView) {
        return this;
    }

    public DemoHelperView withStylableDevice(DeviceView content, CssVariable... cssVariables) {
        add(new DemoParagraphView(content, new CssVariableView(cssVariables)));
        return this;
    }

    public DemoHelperView withDevices(DeviceView tabletContent, DeviceView phoneContent) {
        addLargeParagraph(new DevicesParagraphView(tabletContent, phoneContent));
        return this;
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

    private void addParagraph(Component component) {
        add(component);
        component.getElement().getClassList().add("content-wrapper-small");
    }

    private void addLargeParagraph(Component component) {
        add(component);
        component.getElement().getClassList().add("content-wrapper");
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
