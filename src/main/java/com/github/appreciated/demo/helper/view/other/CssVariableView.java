package com.github.appreciated.demo.helper.view.other;

import com.github.appreciated.calc.color.helper.CalculatedColorHelper;
import com.github.appreciated.demo.helper.entity.CssVariable;
import com.github.appreciated.demo.helper.interfaces.CssVariableChangeListener;
import com.github.appreciated.papercolor.textfield.PaperColorTextField;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CssVariableView extends VerticalLayout {
    private final Button button = new Button("Download", VaadinIcon.DOWNLOAD.create());
    private Grid<CssVariable> grid = new Grid<>();

    private Optional<CssVariableChangeListener> listener = Optional.empty();
    private CssVariable[] variables;
    private CalculatedColorHelper helper;
    private List<HasStyle> styleableViews = new ArrayList<>();

    public CssVariableView(CalculatedColorHelper helper, CssVariable... variables) {
        this(variables);
        setCalculatedColorHelper(helper);
    }

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
        grid.setWidth("100%");
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
        button.addClickListener(buttonClickEvent -> {

        });
        grid.getStyle().set("border", "none");
        add(grid, button);
        getStyle().set("max-width", "790px").set("margin-top", "50px");
        setMargin(false);
        setPadding(false);
    }

    public void setCalculatedColorHelper(CalculatedColorHelper helper) {
        this.helper = helper;
        setValueChangeListener((variable) -> {
            helper.setCalculatedColor(variable.getName(), variable.getValue());
            styleableViews.forEach(component -> component.getStyle().set(variable.getName(), variable.getValue()));
        });
    }

    public void setValueChangeListener(CssVariableChangeListener listener) {
        this.listener = Optional.ofNullable(listener);
    }

    public void addStylableView(HasStyle content) {
        styleableViews.add(content);
    }
}
