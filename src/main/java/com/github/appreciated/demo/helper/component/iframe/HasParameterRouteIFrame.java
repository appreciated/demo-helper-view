package com.github.appreciated.demo.helper.component.iframe;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.HasUrlParameter;

public class HasParameterRouteIFrame<T, C extends Component & HasUrlParameter<T>> extends IFrame {

    public HasParameterRouteIFrame(Class<C> className, String parameter) {
        setSrc(UI.getCurrent()
                .getRouter()
                .getRegistry()
                .getTargetUrl(className)
                .orElseThrow(() -> new IllegalArgumentException("Class needs to have a @Route"))
                + "/" + parameter);
    }
}

