package com.github.appreciated.demo.helper.component.browser;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.HasUrlParameter;

public class HasParameterRouteBrowser<T, C extends Component & HasUrlParameter<T>> extends Browser {

    public HasParameterRouteBrowser(Class<C> route, T parameter) {
        super(UI.getCurrent().getRouter().getUrl(route, parameter));
    }
}
