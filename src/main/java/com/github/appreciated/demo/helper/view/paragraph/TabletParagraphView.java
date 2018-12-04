package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.devices.TabletView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TabletParagraphView extends VerticalLayout {
    private TabletView tabletView = new TabletView();

    public TabletParagraphView() {
        setAlignItems(Alignment.CENTER);
        add(tabletView);
    }

    public TabletParagraphView(Component content) {
        this();
        tabletView.add(content);
        setSizeUndefined();
    }

    public TabletView getTabletView() {
        return tabletView;
    }
}
