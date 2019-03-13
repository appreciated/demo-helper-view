package com.github.appreciated.demo.helper.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;

@Route("test2")
public class OtherContent2 extends Div {
    public OtherContent2() {
        add(new Label("test2"));
        add(new Button("test2", event -> UI.getCurrent().navigate(OtherContent.class)));
    }
}
