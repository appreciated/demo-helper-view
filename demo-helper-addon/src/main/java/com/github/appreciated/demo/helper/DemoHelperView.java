package com.github.appreciated.demo.helper;

import com.github.appreciated.demo.helper.view.*;
import com.github.appreciated.demo.helper.view.devices.LaptopView;
import com.github.appreciated.demo.helper.view.devices.PhoneView;
import com.github.appreciated.demo.helper.view.devices.TabletAndPhoneView;
import com.github.appreciated.demo.helper.view.devices.TabletView;
import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.vaadin.server.Resource;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class DemoHelperView extends Panel {
    private final VerticalLayout contentHolder;
    private int counter = 1;

    public DemoHelperView() {
        contentHolder = new VerticalLayout();
        contentHolder.setHeightUndefined();
        contentHolder.setSpacing(false);
        setContent(contentHolder);
    }

    public DemoHelperView withVerticalHeaderView(String header, Resource resource) {
        return withVerticalHeaderView(header, null, resource);
    }

    public DemoHelperView withVerticalHeaderView(String header, String description) {
        return withVerticalHeaderView(header, description, null);
    }

    public DemoHelperView withVerticalHeaderView(String header) {
        return withVerticalHeaderView(header, null, null);
    }

    public DemoHelperView withVerticalHeaderView(String header, String description, Resource image) {
        contentHolder.addComponent(new VerticalHeaderView(header, description, image));
        return this;
    }

    public DemoHelperView withHorizontalHeaderView(String header, Resource resource) {
        return withHorizontalHeaderView(header, null, resource);
    }

    public DemoHelperView withHorizontalHeaderView(String header, String description) {
        return withHorizontalHeaderView(header, description, null);
    }

    public DemoHelperView withHorizontalHeaderView(String header) {
        return withHorizontalHeaderView(header, null, null);
    }

    public DemoHelperView withHorizontalHeaderView(String header, String description, Resource image) {
        contentHolder.addComponent(new HorizontalHeaderView(header, description, image));
        return this;
    }


    public DemoHelperView withHorizontalHeaderView(String header, String description, Resource image, Component... components) {
        contentHolder.addComponent(new HorizontalHeaderView(header, description, image, components));
        return this;
    }

    public DemoHelperView withPhoneView(Component content) {
        contentHolder.addComponent(new PhoneView(content));
        return this;
    }

    public DemoHelperView withPhoneView(Component content, String description) {
        contentHolder.addComponent(new PhoneView(content, description));
        return this;
    }

    public DemoHelperView withTabletView(Component content) {
        contentHolder.addComponent(new TabletView(content));
        return this;
    }

    public DemoHelperView withTabletAndPhoneView(Component tabletContent, Component phoneContent) {
        contentHolder.addComponent(new TabletAndPhoneView(tabletContent, phoneContent));
        return this;
    }

    public DemoHelperView withLaptopView(Component content) {
        contentHolder.addComponent(new LaptopView(content));
        return this;
    }

    public DemoHelperView withParagraphView(String header) {
        contentHolder.addComponent(new ParagraphView(header));
        return this;
    }

    public DemoHelperView withParagraphView(String header, Component... components) {
        contentHolder.addComponent(new ParagraphView(header, components));
        return this;
    }

    public DemoHelperView withParagraphView(String header, String description) {
        contentHolder.addComponent(new ParagraphView(header, description));
        return this;
    }

    public DemoHelperView withParagraphView(String header, String description, Component... components) {
        contentHolder.addComponent(new ParagraphView(header, description, components));
        return this;
    }

    public DemoHelperView withImageParagraphView(String header, String description, Resource resource) {
        contentHolder.addComponent(new ImageParagraphView(header, description, resource));
        return this;
    }

    public DemoHelperView withStepView(String title, String description, CodeExample... codeExamples) {
        contentHolder.addComponent(new StepView(counter++, title, description, codeExamples));
        return this;
    }

    public DemoHelperView withComponent(Component component) {
        contentHolder.addComponent(component);
        return this;
    }

    public VerticalLayout getContentHolder() {
        return contentHolder;
    }

}
