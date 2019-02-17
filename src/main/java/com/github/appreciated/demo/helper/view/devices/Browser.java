package com.github.appreciated.demo.helper.view.devices;

import com.github.appreciated.demo.helper.component.IFrame;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.DomEventListener;
import com.vaadin.flow.dom.Style;


public class Browser extends VerticalLayout {
    private final TextField navigationBar;
    private final IFrame browserWindow;

    public Browser(Class<? extends Component> route) {
        setSizeUndefined();
        browserWindow = new IFrame(route);
        browserWindow.setSizeFull();
        navigationBar = new TextField();
        navigationBar.setWidth("100%");
        navigationBar.setValue(UI.getCurrent().getRouter().getUrl(route));
        navigationBar.addKeyPressListener(Key.ENTER, event -> browserWindow.setSrc(navigationBar.getValue()));
        HorizontalLayout wrapper = new HorizontalLayout(
                new Button(VaadinIcon.ARROW_LEFT.create(), event -> browserWindow.back()),
                new Button(VaadinIcon.ARROW_RIGHT.create(), event -> browserWindow.forward()),
                new Button(VaadinIcon.REFRESH.create(), event -> browserWindow.reload()),
                navigationBar
        );
        wrapper.setWidth("100%");
        add(wrapper);
        add(browserWindow);
        setWidth("500px");
        setHeight("500px");
        setSpacing(false);
        getStyle().set("box-shadow", "var(--lumo-box-shadow-l)");
        getStyle().set("border-radius", "var(--lumo-border-radius)");
        setMargin(false);
    }

    public void setOnLoadListener(DomEventListener loadListener) {
        browserWindow.setOnLoadListener(loadListener);
    }

    public void setInnerStyle(Style style) {
        browserWindow.setInnerStyle(style);
    }
}
