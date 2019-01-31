package com.github.appreciated.demo.helper.view.animation;

import com.vaadin.flow.component.html.Div;

public class RippleAnimation extends Div {
    public RippleAnimation() {
        addClassName("ripple-animation-dark");
        setWidth("800px");
        setHeight("800px");
        getStyle().set("position", "absolute")
                .set("top", "50%")
                .set("left", "50%")
                .set("transform", "translate(-50%,-50%)");
    }
}
