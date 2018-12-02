package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.entity.CssVariable;
import com.github.appreciated.demo.helper.view.entity.CssVariableChangeListener;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import java.util.Arrays;
import java.util.Optional;

public class CssVariableView extends Grid<CssVariable> {
    private Optional<CssVariableChangeListener> listener = Optional.empty();
    private CssVariable[] variables;

    public CssVariableView(CssVariable... variables) {
        this.variables = variables;
        setHeight((56 + variables.length * 52 + 2) + "px");
        setWidth("500px");
        setItems(variables);
        addColumn(CssVariable::getName).setHeader("Variable");
        addComponentColumn(cssVariable -> {
            Binder<CssVariable> binder = new Binder<>(CssVariable.class);
            TextField tf = new TextField();
            binder.setBean(cssVariable);
            binder.bind(tf, var -> var.getValue(), (var, stringValue) -> var.setValue(stringValue));
            tf.addValueChangeListener(event ->
                    listener.ifPresent(listener1 -> listener1.onVariableChanged(cssVariable.getName(), tf.getValue()))
            );
            return tf;
        }).setHeader("Value");
    }

    public void setValueChangeListener(CssVariableChangeListener listener) {
        this.listener = Optional.ofNullable(listener);
    }

    public void setStyledComponent(Component component) {
        Arrays.stream(variables)
                .filter(cssVariable -> cssVariable.getValue() == null)
                .forEach(cssVariable -> component.getElement().getStyle().get(cssVariable.getName()));
        setValueChangeListener((variable, value) -> component.getElement().getStyle().set(variable, value));
    }
}
