package com.github.appreciated.demo.helper.style;

import com.vaadin.flow.dom.Style;
import com.vaadin.flow.internal.StateNode;
import com.vaadin.flow.internal.nodefeature.ElementStylePropertyMap;

import java.io.Serializable;

public class CustomElementStylePropertyMap extends ElementStylePropertyMap {
    private PropertyChangedListener listener;

    public CustomElementStylePropertyMap(StateNode node) {
        super(node);
    }

    @Override
    public void setProperty(String name, Serializable value, boolean emitChange) {
        super.setProperty(name, value, emitChange);
        if (listener != null) {
            listener.onChange(getStyle());
        }
    }

    public void addChangeListener(PropertyChangedListener listener) {
        this.listener = listener;
    }

    public interface PropertyChangedListener {
        void onChange(Style style);
    }
}
