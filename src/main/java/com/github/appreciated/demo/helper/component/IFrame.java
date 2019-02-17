package com.github.appreciated.demo.helper.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.dom.DomEventListener;
import com.vaadin.flow.dom.Style;

@Tag("iframe")
public class IFrame extends HtmlContainer {

    private boolean sizeFull;

    public IFrame(Class<? extends Component> className) {
        this();
        setSrc(UI.getCurrent().getRouter().getUrl(className));
    }

    public IFrame() {
        getStyle().set("border", "none");
    }

    public IFrame(String src) {
        this();
        this.setSrc(src);
    }

    public String getSrc() {
        return getElement().getAttribute("src");
    }

    public void setSrc(String src) {
        System.out.println(src);
        getElement().setAttribute("src", src);
    }

    public IFrame withFullSize() {
        setSizeFull();
        return this;
    }

    public void setInnerStyle(Style style) {
        getElement().callFunction("contentWindow.document.body.setAttribute", "style",
                style.getNames()
                        .map(name -> name + ":" + style.get(name)).reduce((s, s2) -> s + ";" + s2).orElse("")
        );
    }

    public void setOnLoadListener(DomEventListener loadListener) {
        getElement().addEventListener("load", loadListener);
    }

}

