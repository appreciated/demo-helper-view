package com.github.appreciated.demo.helper.view.design;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class StepDesign extends HorizontalLayout {
    private Label stepNumber = new Label();
    private Label stepHeader = new Label();
    private Label stepDescription = new Label();
    private VerticalLayout codeExampleHolder = new VerticalLayout(stepNumber, stepHeader, stepDescription);

    public StepDesign() {

    }

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
