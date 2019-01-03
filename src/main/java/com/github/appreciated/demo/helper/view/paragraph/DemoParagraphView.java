package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.RevealableContent;
import com.github.appreciated.demo.helper.view.devices.DeviceView;
import com.github.appreciated.demo.helper.view.other.CssVariableView;
import com.vaadin.flow.component.Component;


public class DemoParagraphView extends RevealableContent {

    public DemoParagraphView(DeviceView component, CssVariableView variableView) {
        super((Component) component, variableView);
        //HorizontalLayout styleWrapper = new HorizontalLayout(view);
        //styleWrapper.getStyle().set("position", "relative");
        //CalculatedColorHelper helper = new CalculatedColorHelper();
        //add(new Div((Component) component, helper));
        //add(styleWrapper, "Style");
        //view.setCalculatedColorHelper(helper);
    }
}

