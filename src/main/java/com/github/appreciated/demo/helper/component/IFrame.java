package com.github.appreciated.demo.helper.component;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.dom.DomEventListener;
import com.vaadin.flow.dom.Style;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Tag("iframe")
@JavaScript("com/github/appreciated/demo-helper/iframe-helper.js")
public class IFrame extends HtmlContainer {

    private boolean sizeFull;
    private List<Consumer<String>> listeners = new ArrayList<>();

    public IFrame(Class<? extends Component> className) {
        this();
        setSrc(UI.getCurrent().getRouter().getUrl(className));
        addOnLoadListener(event -> getElement().executeJavaScript("initIFrameObserver($0)", getElement()));
    }

    public IFrame() {
        getStyle().set("border", "none");
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

    public void setInnerStyle(Style style) {
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

}

