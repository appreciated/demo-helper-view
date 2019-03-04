package com.github.appreciated.demo.helper.component.browser;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;

public class RouteBrowser extends Browser {
    public RouteBrowser(Class<? extends Component> route) {
        super(UI.getCurrent().getRouter().getUrl(route));
    }
}
