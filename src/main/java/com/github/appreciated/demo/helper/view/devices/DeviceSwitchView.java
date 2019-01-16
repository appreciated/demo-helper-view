package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

import java.util.HashMap;

@StyleSheet("com/github/appreciated/demo-helper/demo-helper.css")
public class DeviceSwitchView extends Div implements HasOrientation {
    private final Device device;
    private final VerticalLayout actions = new VerticalLayout();
    private final HashMap<Component, String> deviceMap;

    public DeviceSwitchView(Component content) {
        super();
        deviceMap = new HashMap<>();
        getClassNames().add("device-wrapper");
        device = new Device(content);
        device.withFloatingButton(VaadinIcon.ROTATE_RIGHT.create(), event -> device.toggleOrientation());
        actions.setWidth("undefined");
        Tabs tabs = new Tabs();
        Tab tab1 = new Tab(VaadinIcon.MOBILE.create());
        Tab tab2 = new Tab(VaadinIcon.TABLET.create());
        Tab tab3 = new Tab(VaadinIcon.LAPTOP.create());
        deviceMap.put(tab1, "phone");
        deviceMap.put(tab2, "tablet");
        deviceMap.put(tab3, "laptop");
        tabs.add(tab1, tab2, tab3);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.addSelectedChangeListener(event -> device.changeTo(deviceMap.get(tabs.getSelectedTab())));
        tabs.setSelectedTab(tab1);
        actions.add(tabs);
        add(new HorizontalLayout(device, actions));
        setWidth("100%");
    }
}
