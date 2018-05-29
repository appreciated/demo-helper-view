package com.github.appreciated.demo.helper;

import com.github.appreciated.demo.helper.view.HorizontalHeaderView;
import com.github.appreciated.demo.helper.view.ImageParagraphView;
import com.github.appreciated.demo.helper.view.ParagraphView;
import com.github.appreciated.demo.helper.view.StepView;
import com.github.appreciated.demo.helper.view.devices.LaptopView;
import com.github.appreciated.demo.helper.view.devices.PhoneView;
import com.github.appreciated.demo.helper.view.devices.TabletAndPhoneView;
import com.github.appreciated.demo.helper.view.devices.TabletView;
import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class DemoHelperView extends VerticalLayout {

    private int counter = 1;

    public DemoHelperView() {

    }

    public DemoHelperView withVerticalHeaderView(String header, String description, String resource) {
        return withVerticalHeaderView(header, description, resource);
    }


    public DemoHelperView withVerticalHeaderView(String header) {
        return withVerticalHeaderView(header, null, null);
    }


    public DemoHelperView withHorizontalHeaderView(String header, String description) {
        return withHorizontalHeaderView(header, description, null);
    }

    public DemoHelperView withHorizontalHeaderView(String header) {
        return withHorizontalHeaderView(header, null, null);
    }

    public DemoHelperView withHorizontalHeaderView(String header, String description, String image) {
        add(new HorizontalHeaderView(header, description, image));
        return this;
    }


    public DemoHelperView withHorizontalHeaderView(String header, String description, String image, Component... components) {
        add(new HorizontalHeaderView(header, description, image, components));
        return this;
    }

    public DemoHelperView withPhoneView(Component content) {
        add(new PhoneView(content));
        return this;
    }

    public DemoHelperView withPhoneView(Component content, String description) {
        add(new PhoneView(content, description));
        return this;
    }

    public DemoHelperView withTabletView(Component content) {
        add(new TabletView(content));
        return this;
    }

    public DemoHelperView withTabletAndPhoneView(Component tabletContent, Component phoneContent) {
        add(new TabletAndPhoneView(tabletContent, phoneContent));
        return this;
    }

    public DemoHelperView withLaptopView(Component content) {
        add(new LaptopView(content));
        return this;
    }

    public DemoHelperView withParagraphView(String header) {
        add(new ParagraphView(header));
        return this;
    }

    public DemoHelperView withParagraphView(String header, Component... components) {
        add(new ParagraphView(header, components));
        return this;
    }

    public DemoHelperView withParagraphView(String header, String description) {
        add(new ParagraphView(header, description));
        return this;
    }

    public DemoHelperView withParagraphView(String header, String description, Component... components) {
        add(new ParagraphView(header, description, components));
        return this;
    }

    public DemoHelperView withImageParagraphView(String header, String description, String resource) {
        add(new ImageParagraphView(header, description, resource));
        return this;
    }

    public DemoHelperView withStepView(String title, String description, CodeExample... codeExamples) {
        add(new StepView(counter++, title, description, codeExamples));
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
