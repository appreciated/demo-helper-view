package com.github.appreciated.demo.helper.view.devices;

import com.github.appreciated.IronCollapse;
import com.github.appreciated.calc.color.helper.CalculatedColorHelper;
import com.github.appreciated.demo.helper.view.entity.CssVariable;
import com.github.appreciated.demo.helper.view.other.CssVariableView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

import java.util.HashMap;

@StyleSheet("com/github/appreciated/demo-helper/demo-helper.css")
public class DeviceSwitchView extends Div implements HasOrientation {
    private final Device device;
    private final VerticalLayout actions = new VerticalLayout();
    private final HashMap<Component, String[]> deviceMap;
    private final VerticalLayout contentHolder;

    public DeviceSwitchView(Component content) {
        super();
        deviceMap = new HashMap<>();
        getClassNames().add("device-wrapper");
        device = new Device(content);
        device.getStyle().set("margin-left", "104px");

        actions.setWidth("undefined");
        Tabs tabs = new Tabs();
        Tab tab1 = new Tab(VaadinIcon.MOBILE.create());
        Tab tab2 = new Tab(getRotatedIcon(VaadinIcon.MOBILE, 90));
        Tab tab3 = new Tab(getRotatedIcon(VaadinIcon.TABLET, 90));
        Tab tab4 = new Tab(VaadinIcon.TABLET.create());
        Tab tab5 = new Tab(VaadinIcon.LAPTOP.create());
        deviceMap.put(tab1, new String[]{"phone"});
        deviceMap.put(tab2, new String[]{"phone", "landscape"});
        deviceMap.put(tab3, new String[]{"tablet"});
        deviceMap.put(tab4, new String[]{"tablet", "landscape"});
        deviceMap.put(tab5, new String[]{"laptop"});
        tabs.add(tab1, tab2, tab3, tab4, tab5);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.addSelectedChangeListener(event -> device.changeTo(deviceMap.get(tabs.getSelectedTab())));
        tabs.setSelectedTab(tab1);
        actions.add(tabs);
        HorizontalLayout deviceWrapper = new HorizontalLayout(device, actions);
        contentHolder = new VerticalLayout(deviceWrapper);
        contentHolder.setAlignItems(FlexComponent.Alignment.CENTER);
        add(contentHolder);
        setWidth("100%");
    }

    public DeviceSwitchView withStyleableVariables(CssVariable... variables) {
        CalculatedColorHelper helper = new CalculatedColorHelper();
        IronCollapse collapse = new IronCollapse(new CssVariableView(helper, variables));
        device.withFloatingButton(VaadinIcon.PAINTBRUSH.create(), event -> collapse.toggle())
                .withCalculatedColorHelper(helper);
        contentHolder.add(collapse);
        collapse.setWidth("500px");
        return this;
    }

    Icon getRotatedIcon(VaadinIcon icon, int degree) {
        Icon i = icon.create();
        i.getStyle().set("transform", "rotate(" + degree + "deg)");
        return i;
    }
}
