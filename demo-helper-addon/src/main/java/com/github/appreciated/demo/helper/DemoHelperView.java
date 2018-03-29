package com.github.appreciated.demo.helper;

import com.github.appreciated.demo.helper.view.ImageParagraphView;
import com.github.appreciated.demo.helper.view.ParagraphView;
import com.github.appreciated.demo.helper.view.StepView;
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

    public DemoHelperView withParagraphView(String header, String description) {
        contentHolder.addComponent(new ParagraphView(header, description));
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
