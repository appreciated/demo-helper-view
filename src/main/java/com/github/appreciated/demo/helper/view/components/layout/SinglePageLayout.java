package com.github.appreciated.demo.helper.view.components.layout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Arrays;

public class SinglePageLayout extends VerticalLayout {

    public SinglePageLayout(Component... components) {
        add(components);
    }

    @Override
    public void add(Component... components) {
        super.add(components);
        Arrays.stream(components).forEach(component -> component.getElement().getStyle().set("flex-shrink", "0"));
    }

    public SinglePageLayout() {
        getElement().getStyle().set("overflow", "auto");
        setAlignItems(Alignment.CENTER);
        setSizeFull();
    }

    public Component addFullHeightComponent(Component component) {
        Component page = getFullHeightComponent(component);
        add(page);
        return page;
    }

    public Component getFullHeightComponent(Component component) {
        HorizontalLayout header = new HorizontalLayout(component);
        header.setJustifyContentMode(JustifyContentMode.CENTER);
        header.setAlignItems(Alignment.CENTER);
        header.setSizeFull();
        return header;
    }

}
