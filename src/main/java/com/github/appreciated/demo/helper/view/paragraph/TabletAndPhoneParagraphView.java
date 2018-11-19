package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.devices.PhoneView;
import com.github.appreciated.demo.helper.view.devices.TabletView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;

public class TabletAndPhoneParagraphView extends Div {
    private TabletView tabletView = new TabletView();
    private PhoneView phoneView = new PhoneView();
    private Div deviceWrapper = new Div(tabletView, phoneView);

    public TabletAndPhoneParagraphView(Component tabletContent, Component phoneContent) {
        tabletView.add(tabletContent);
        phoneView.add(phoneContent);
        add(tabletView);
        add(phoneView);

        getElement().getStyle()
                .set("display", "flex")
                .set("justify-content", "space-around")
                .set("align-items", "flex-end")
                .set("flex-wrap", "wrap");
        setWidth("100%");

        phoneView.getStyle().set("margin-top", "40px").set("margin-left", "20px").set("margin-right", "20px");
        tabletView.getStyle().set("margin-left", "20px").set("margin-right", "20px");
    }

    public TabletAndPhoneParagraphView() {
        add(deviceWrapper);
    }

    public Div getDeviceWrapper() {
        return deviceWrapper;
    }

    public TabletView getTabletView() {
        return tabletView;
    }

    public PhoneView getPhoneView() {
        return phoneView;
    }
}

