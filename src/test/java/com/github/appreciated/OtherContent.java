package com.github.appreciated;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;

@Route("test")
public class OtherContent extends Div {
    public OtherContent() {
        add(new Label("test"));
        add(new Button("test", event -> UI.getCurrent().navigate(OtherContent2.class)));
    }
}
