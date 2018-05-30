package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.devices.LaptopView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class LaptopParagraphView extends VerticalLayout {
    private LaptopView laptopView = new LaptopView();

    public LaptopParagraphView(Component content) {
        this();
        laptopView.add(content);
    }

    public LaptopParagraphView() {
        add(laptopView);
        setAlignItems(Alignment.CENTER);
    }

    public LaptopView getLaptopView() {
        return laptopView;
    }

}

