package com.github.appreciated.demo.helper.view.devices;

import com.github.appreciated.IronCollapse;
import com.github.appreciated.calc.color.helper.CalculatedColorHelper;
import com.github.appreciated.demo.helper.entity.CssVariable;
import com.github.appreciated.demo.helper.view.other.CssVariableView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
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
    private final HashMap<Tab, DeviceType> deviceMap;
    private final VerticalLayout contentHolder;
    private final Tabs tabs;
    private CssVariableView variableView;

    public DeviceSwitchView(Component content) {
        super();
        deviceMap = new HashMap<>();
        getClassNames().add("device-wrapper");
        device = new IPhone5C(content);
        device.getStyle().set("margin-left", "calc(104px + 1em)");

        actions.setWidth("undefined");
        tabs = new Tabs();
        Tab tab1 = new Tab(VaadinIcon.MOBILE.create());
        Tab tab2 = new Tab(getRotatedIcon(VaadinIcon.MOBILE, 90));
        tab2.addClassName("size-s");
        Tab tab3 = new Tab(getRotatedIcon(VaadinIcon.TABLET, 90));
        Tab tab4 = new Tab(VaadinIcon.TABLET.create());
        tab4.addClassName("size-m");
        Tab tab5 = new Tab(VaadinIcon.LAPTOP.create());
        tab5.addClassName("size-l");
        deviceMap.put(tab1, DeviceType.PHONE);
        deviceMap.put(tab2, DeviceType.PHONE_LANDSCAPE);
        deviceMap.put(tab3, DeviceType.TABLET);
        deviceMap.put(tab4, DeviceType.TABLET_LANDSCAPE);
        deviceMap.put(tab5, DeviceType.LAPTOP);
        tabs.add(tab1, tab2, tab3, tab4, tab5);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        //tabs.addSelectedChangeListener(event -> device.changeTo(deviceMap.get(tabs.getSelectedTab()).getClassNames()));
        tabs.setSelectedTab(tab1);
        actions.add(tabs);
        HorizontalLayout deviceWrapper = new HorizontalLayout(device, actions);
        contentHolder = new VerticalLayout(deviceWrapper);
        contentHolder.setAlignItems(FlexComponent.Alignment.CENTER);
        add(contentHolder);
        setWidth("100%");
    }

    Icon getRotatedIcon(VaadinIcon icon, int degree) {
        Icon i = icon.create();
        i.getStyle().set("transform", "rotate(" + degree + "deg)");
        return i;
    }

    public DeviceSwitchView withStyleableVariables(CssVariable... variables) {
        CalculatedColorHelper helper = new CalculatedColorHelper();

        variableView = new CssVariableView(helper, variables);
        IronCollapse collapse = new IronCollapse(variableView);
        device.withButton(VaadinIcon.PAINTBRUSH.create(), event -> collapse.toggle())
                .withCalculatedColorHelper(helper);
        contentHolder.add(collapse);
        collapse.setWidth("500px");
        return this;
    }

    public void setDeviceType(DeviceType type) {
        deviceMap.forEach((tab, deviceType) -> {
            if (deviceType == type) {
                tabs.setSelectedTab(tab);
            }
        });
    }

    public void withStyleableView(HasStyle content) {
        if (variableView != null) {
            variableView.addStylableView(content);
        }
    }
}
