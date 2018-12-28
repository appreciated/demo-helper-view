package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.devices.DeviceView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class StyleView extends Div {

    public StyleView(DeviceView component, CssVariableView view) {
        this.getStyle().set("padding", "30px");
        getElement().setAttribute("theme", "spacing-l");
        getElement().getStyle()
                .set("--lumo-space-l", "4rem")
                .set("display", "flex")
                .set("flex-wrap", "wrap")
                .set("box-shadow", "var(--lumo-box-shadow-s)")
                .set("padding", "30px")
                .set("border-radius", "20px");
        HorizontalLayout styleWrapper = new HorizontalLayout(view);
        styleWrapper.getStyle().set("position", "relative");
        add((Component) component, styleWrapper);
        component.getElement().getStyle().set("margin", "15px");
        styleWrapper.getElement().getStyle().set("margin", "15px");
        view.setStyledComponent((Component) component);
    }

}

