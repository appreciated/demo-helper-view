package com.github.appreciated.demo.helper;

import com.github.appreciated.demo.helper.view.devices.PhoneView;
import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.demo.helper.view.paragraph.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@StyleSheet("com/github/appreciated/demo-helper/demo-helper.css")
public class DemoHelperView extends VerticalLayout {

    private int counter = 1;

    public DemoHelperView() {
        setMargin(false);
        setPadding(false);
        setAlignItems(Alignment.CENTER);
        getElement().setAttribute("theme", "spacing-xl");
        getElement().getStyle().set("--lumo-space-xl", "6rem");
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

    public DemoHelperView withPhone(Component content) {
        add(new PhoneView(content));
        return this;
    }

    public DemoHelperView withPhone(Component content, String description) {
        add(new PhoneParagraphView(content, description));
        return this;
    }

    public DemoHelperView withTablet(Component content) {
        add(new TabletParagraphView(content));
        return this;
    }

    public DemoHelperView withTabletAndPhoneView(Component tabletContent, Component phoneContent) {
        addLargeParagraph(new TabletAndPhoneParagraphView(tabletContent, phoneContent));
        return this;
    }

    public DemoHelperView withLaptopView(Component content) {
        add(new LaptopParagraphView(content));
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
