package com.github.appreciated.demo.helper;

import com.github.appreciated.demo.helper.view.HeaderView;
import com.github.appreciated.demo.helper.view.ImageContentView;
import com.github.appreciated.demo.helper.view.StepView;
import com.github.appreciated.demo.helper.view.ParagraphView;
import com.github.appreciated.demo.helper.view.devices.HandheldView;
import com.github.appreciated.demo.helper.view.devices.LaptopView;
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

    public DemoHelperView withHeaderView(String title) {
        contentHolder.addComponent(new HeaderView(title));
        return this;
    }

    public DemoHelperView withHeaderView(String title, String url) {
        contentHolder.addComponent(new HeaderView(title, url));
        return this;
    }

    public DemoHelperView withHeaderView(String title, Resource resource) {
        contentHolder.addComponent(new HeaderView(title, resource));
        return this;
    }

    public DemoHelperView withPhoneView(Component content) {
        contentHolder.addComponent(new HandheldView(content));
        return this;
    }

    public DemoHelperView withPhoneView(Component content, String description) {
        contentHolder.addComponent(new HandheldView(content, description));
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

    public DemoHelperView withTextContentView(String header, String description) {
        contentHolder.addComponent(new ParagraphView(header, description));
        return this;
    }

    public DemoHelperView withImageContentView(String header, String description, Resource resource) {
        contentHolder.addComponent(new ImageContentView(header, description, resource));
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
