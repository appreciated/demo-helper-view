package com.github.appreciated.demo.helper.view.design;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class StepDesign extends HorizontalLayout {
    private Label stepNumber;
    private Label stepHeader;
    private Label stepDescription;
    private VerticalLayout codeExampleHolder;

    public Label getStepNumber() {
        return stepNumber;
    }

    public Label getStepHeader() {
        return stepHeader;
    }

    public Label getStepDescription() {
        return stepDescription;
    }

    public VerticalLayout getCodeExampleHolder() {
        return codeExampleHolder;
    }

}
