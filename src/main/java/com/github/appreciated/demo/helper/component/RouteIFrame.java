package com.github.appreciated.demo.helper.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.router.HasUrlParameter;

@Tag("iframe")
@JavaScript("com/github/appreciated/demo-helper/iframe-helper.js")
public class RouteIFrame<T, C extends Component & HasUrlParameter<T>> extends IFrame {

    public RouteIFrame(Class<C> className, T parameter) {
        setSrc(UI.getCurrent().getRouter().getUrl(className, parameter));
        addOnLoadListener(event -> getElement().executeJavaScript("initIFrameObserver($0)", getElement()));
    }

    public RouteIFrame(Class<? extends Component> className) {
        setSrc(UI.getCurrent().getRouter().getUrl(className));
        addOnLoadListener(event -> getElement().executeJavaScript("initIFrameObserver($0)", getElement()));
    }
}

