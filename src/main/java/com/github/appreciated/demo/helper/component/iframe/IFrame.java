package com.github.appreciated.demo.helper.component.iframe;

import com.github.appreciated.demo.helper.style.CustomElementStylePropertyMap;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.dom.DomEventListener;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.internal.StateNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Tag("iframe")
@JavaScript("com/github/appreciated/demo-helper/iframe-helper.js")
public class IFrame extends HtmlContainer {

    private final CustomElementStylePropertyMap queryStyle;
    private List<Consumer<String>> listeners = new ArrayList<>();

    public IFrame() {
        super.getStyle().set("border", "none");
        queryStyle = new CustomElementStylePropertyMap(new StateNode());
        queryStyle.addChangeListener(this::setInnerStyle);
    }

    public void addOnLoadListener(DomEventListener loadListener) {
        getElement().addEventListener("load", loadListener);
    }

    public IFrame(String src) {
        this();
        this.setSrc(src);
    }

    public String getSrc() {
        return getElement().getAttribute("src");
    }

    public void setSrc(String src) {
        getElement().setAttribute("src", src);
    }

    public IFrame withFullSize() {
        setSizeFull();
        return this;
    }

    private void setInnerStyle(Style style) {
        getElement().callFunction("contentWindow.document.body.setAttribute", "style",
                style.getNames()
                        .map(name -> name + ":" + style.get(name)).reduce((s, s2) -> s + ";" + s2).orElse("")
        );
    }

    @ClientCallable
    public void onUrlChanged(String newUrl) {
        this.listeners.forEach(listener -> listener.accept(newUrl));
    }

    public void addOnUrlChangedListener(Consumer<String> listener) {
        this.listeners.add(listener);
    }

    public void back() {
        getElement().callFunction("contentWindow.history.back");
    }

    public void forward() {
        getElement().callFunction("contentWindow.history.forward");
    }

    public void reload() {
        getElement().callFunction("contentWindow.location.reload");
    }

    @Override
    public Style getStyle() {
        return queryStyle.getStyle();
    }
}

