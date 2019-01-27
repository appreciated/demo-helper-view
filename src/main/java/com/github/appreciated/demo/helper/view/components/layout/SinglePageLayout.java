package com.github.appreciated.demo.helper.view.components.layout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Arrays;
import java.util.Optional;

public class SinglePageLayout extends VerticalLayout {

    private Component header;

    public SinglePageLayout(Component header, Component... components) {
        this(components);
        setHeader(header);
    }

    public SinglePageLayout(Component... components) {
        this();
        add(components);
    }

    public Component setHeader(Component component) {
        if (this.header != null && indexOf(this.header) > -1) {
            remove(this.header);
        }
        Component header = getComponentAsPage(component);
        getElement().insertChild(0, header.getElement());
        this.header = header;
        return header;
    }

    public SinglePageLayout() {
        getElement().getStyle().set("overflow", "auto");
        setAlignItems(Alignment.CENTER);
        setSizeFull();
    }

    @Override
    public void add(Component... components) {
        super.add(components);
        Arrays.stream(components).forEach(component -> component.getElement().getStyle().set("flex-shrink", "0"));
    }

    public static Component getComponentAsPage(Component component) {
        HorizontalLayout header = new HorizontalLayout(component);
        header.setJustifyContentMode(JustifyContentMode.CENTER);
        header.setAlignItems(Alignment.CENTER);
        header.setSizeFull();
        return header;
    }

    public Optional<Component> getHeader() {
        if (this.header != null && indexOf(this.header) < 0) {
            return Optional.of(header);
        }
        return Optional.empty();
    }

}
