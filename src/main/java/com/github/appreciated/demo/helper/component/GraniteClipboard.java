package com.github.appreciated.demo.helper.component;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;


@NpmPackage(value = "@granite-elements/granite-clipboard", version = "3.0.0")
@JsModule("@granite-elements/granite-clipboard/granite-clipboard.js")
@Tag("granite-clipboard")
public class GraniteClipboard extends Component implements HasComponents {

    public void setClipboard(String value) {
        getElement().setAttribute("text", value);
    }
}
