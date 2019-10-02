package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;

public class FluentDiv extends Div {
    public FluentDiv withClassNames(String... classNames) {
        addClassNames(classNames);
        return this;
    }

    public FluentDiv with(Component... components) {
        add(components);
        return this;
    }
}
