package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.HasUrlParameter;

public class RouteBrowser<T, C extends Component & HasUrlParameter<T>> extends Browser {
    public RouteBrowser(Class<? extends Component> route) {
        super(UI.getCurrent().getRouter().getUrl(route));
    }

    public RouteBrowser(Class<C> route, T parameter) {
        super(UI.getCurrent().getRouter().getUrl(route, parameter));
    }
}
