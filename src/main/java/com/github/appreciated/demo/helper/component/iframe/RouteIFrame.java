package com.github.appreciated.demo.helper.component.iframe;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;

public class RouteIFrame extends IFrame {

    public RouteIFrame(Class<? extends Component> className) {
        setSrc(UI.getCurrent().getRouter().getUrl(className));
    }
}

