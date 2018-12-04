package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.devices.VerticalTabletView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class VerticalTabletParagraphView extends VerticalLayout {
    private VerticalTabletView tabletView = new VerticalTabletView();

    public VerticalTabletParagraphView() {
        setAlignItems(Alignment.CENTER);
        add(tabletView);
    }

    public VerticalTabletParagraphView(Component content) {
        this();
        setSizeUndefined();
        setMargin(false);
        setPadding(false);
        tabletView.add(content);
    }

    public VerticalTabletView getTabletView() {
        return tabletView;
    }
}
