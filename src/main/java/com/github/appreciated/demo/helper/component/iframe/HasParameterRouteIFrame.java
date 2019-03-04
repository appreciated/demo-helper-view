package com.github.appreciated.demo.helper.component.iframe;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.HasUrlParameter;

public class HasParameterRouteIFrame<T, C extends Component & HasUrlParameter<T>> extends IFrame {

    public HasParameterRouteIFrame(Class<C> className, T parameter) {
        setSrc(UI.getCurrent().getRouter().getUrl(className, parameter));
        addOnLoadListener(event -> getElement().executeJavaScript("initIFrameObserver($0)", getElement()));
    }
}

