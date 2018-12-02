package com.github.appreciated.demo.helper.view.paragraph;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class StyleView extends HorizontalLayout {

    public StyleView(Component component, CssVariableView view) {
        this.setPadding(true);
        HorizontalLayout styleWrapper = new HorizontalLayout(view);
        styleWrapper.getStyle().set("position", "relative").set("border", "5px dashed rgba(128,128,128,0.3)").set("border-radius", "30px").set("padding", "10px");

        Icon arrow = new Icon(VaadinIcon.ANGLE_LEFT);
        arrow.getElement().getStyle().set("width", "50px").set("height", "50px").set("margin-right", "6px");

        HorizontalLayout arrowWrapper = new HorizontalLayout(arrow);
        arrowWrapper.setAlignItems(Alignment.CENTER);

        add(component, arrowWrapper, styleWrapper);
        view.setStyledComponent(component);
    }

}

