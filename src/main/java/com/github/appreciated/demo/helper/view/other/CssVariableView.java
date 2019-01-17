package com.github.appreciated.demo.helper.view.other;

import com.github.appreciated.calc.color.helper.CalculatedColorHelper;
import com.github.appreciated.demo.helper.view.entity.CssVariable;
import com.github.appreciated.demo.helper.view.entity.CssVariableChangeListener;
import com.github.appreciated.papercolor.textfield.PaperColorTextField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.binder.Binder;

import java.util.Optional;

public class CssVariableView extends HorizontalLayout {
    private final Button button = new Button(VaadinIcon.DOWNLOAD.create());
    private Grid<CssVariable> grid = new Grid<>();

    private Optional<CssVariableChangeListener> listener = Optional.empty();
    private CssVariable[] variables;
    private CalculatedColorHelper helper;

    public CssVariableView(CssVariable... variables) {
        getStyle()
                .set("overflow", "hidden")
                .set("position", "relative");
        //.set("border-radius", "20px")
        //.set("box-shadow", "var(--lumo-box-shadow-s)")
        this.variables = variables;
        grid.setHeight((56 + variables.length * 60 + 2 + 1) + "px");
        grid.setThemeName(GridVariant.LUMO_NO_BORDER.getVariantName());
        grid.setThemeName(GridVariant.LUMO_NO_ROW_BORDERS.getVariantName());
        grid.setThemeName(GridVariant.LUMO_ROW_STRIPES.getVariantName());
        grid.setWidth("400px");
        grid.setItems(variables);
        grid.addColumn(CssVariable::getName).setHeader("Variable");
        grid.addComponentColumn(cssVariable -> {
            Binder<CssVariable> binder = new Binder<>(CssVariable.class);
            PaperColorTextField tf = new PaperColorTextField();
            binder.setBean(cssVariable);
            binder.bind(tf, CssVariable::getValue, CssVariable::setValue);
            binder.addValueChangeListener(valueChangeEvent -> {
                button.setVisible(true);
                listener.ifPresent(listener1 -> listener1.onVariableChanged(cssVariable));
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
        grid.getStyle().set("border", "none");
        add(grid, button);
        getStyle().set("max-width", "800px").set("margin-top", "50px");
    }

    public CssVariableView(CalculatedColorHelper helper, CssVariable... variables) {
        this(variables);
        setCalculatedColorHelper(helper);
    }

    public void setValueChangeListener(CssVariableChangeListener listener) {
        this.listener = Optional.ofNullable(listener);
    }

    public void setCalculatedColorHelper(CalculatedColorHelper helper) {
        this.helper = helper;
        setValueChangeListener((variable) -> helper.setCalculatedColor(variable.getName(), variable.getValue()));
    }
}
