package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.entity.CssVariable;
import com.github.appreciated.demo.helper.view.entity.CssVariableChangeListener;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import java.util.Arrays;
import java.util.Optional;

public class CssVariableView extends HorizontalLayout {
    private final Button button = new Button(VaadinIcon.DOWNLOAD.create());
    private Grid<CssVariable> grid = new Grid<>();

    private Optional<CssVariableChangeListener> listener = Optional.empty();
    private CssVariable[] variables;

    public CssVariableView(CssVariable... variables) {
        getStyle()
                .set("overflow", "hidden")
                .set("position", "relative")
                .set("border-radius", "20px")
                .set("box-shadow", "var(--lumo-box-shadow-s)");
        this.variables = variables;
        grid.setHeight((56 + variables.length * 52 + 2 + 1) + "px");
        grid.setThemeName(GridVariant.LUMO_NO_BORDER.getVariantName());
        grid.setThemeName(GridVariant.LUMO_NO_ROW_BORDERS.getVariantName());
        grid.setThemeName(GridVariant.LUMO_ROW_STRIPES.getVariantName());
        grid.setWidth("500px");
        grid.setItems(variables);
        grid.addColumn(CssVariable::getName).setHeader("Variable");
        grid.addComponentColumn(cssVariable -> {
            Binder<CssVariable> binder = new Binder<>(CssVariable.class);
            TextField tf = new TextField();
            binder.setBean(cssVariable);
            binder.bind(tf, var -> var.getValue(), (var, stringValue) -> var.setValue(stringValue));
            tf.addValueChangeListener(event -> {
                button.setVisible(true);
                listener.ifPresent(listener1 -> listener1.onVariableChanged(cssVariable.getName(), tf.getValue()));
            });
            return tf;
        }).setHeader("Value");

        button.setVisible(false);
        button.getStyle()
                .set("background", "var(--lumo-primary-color)")
                .set("color", "var(--lumo-tint)")
                .set("border-radius", "100%")
                .set("box-shadow", "var(--lumo-box-shadow-m)")
                .set("width", "55px")
                .set("height", "55px")
                .set("margin", "0");

        button.getStyle()
                .set("position", "absolute")
                .set("right", "15px")
                .set("bottom", "15px");
        button.addClickListener(buttonClickEvent -> {

        });
        add(grid, button);
    }

    public void setValueChangeListener(CssVariableChangeListener listener) {
        this.listener = Optional.ofNullable(listener);
    }

    public void setStyledComponent(Component component) {
        Arrays.stream(variables)
                .filter(cssVariable -> cssVariable.getValue() == null)
                .forEach(cssVariable -> {
                    //cssVariable.
                });
        setValueChangeListener((variable, value) -> component.getElement().getStyle().set(variable, value));
    }
}
