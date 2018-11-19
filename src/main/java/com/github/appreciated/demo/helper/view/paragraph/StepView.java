package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.demo.helper.view.design.CodeDesign;
import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Arrays;

public class StepView extends HorizontalLayout {
    private Label stepNumber = new Label();
    private Label stepHeader = new Label();
    private Label stepDescription = new Label();
    HorizontalLayout descriptionHolder = new HorizontalLayout(new HorizontalLayout(stepNumber), new VerticalLayout(stepHeader, stepDescription));
    private VerticalLayout codeExampleHolder = new VerticalLayout();

    public StepView() {
        add(descriptionHolder, codeExampleHolder);
        stepNumber.getElement().getClassList().add("step-number");
        stepNumber.setWidth("55px");
        stepNumber.setHeight("55px");

        stepHeader.getElement().getClassList().add("step-content-holder");
        descriptionHolder.setWidth("100%");
        codeExampleHolder.setWidth("100%");
        setWidth("100%");
        getStyle().set("padding", "0 20px");
    }

    /**
     * @param stepNumber
     * @param title
     * @param description
     * @param codeExamples
     */
    public StepView(int stepNumber, String title, String description, CodeExample... codeExamples) {
        this();
        this.stepNumber.setText(String.valueOf(stepNumber));
        stepHeader.setText(title);
        stepDescription.setText(description);
        Arrays.stream(codeExamples).forEach(codeExample -> {
            CodeDesign codeDesign = new CodeDesign(codeExample.getCode(), codeExample.getHighlightingType());
            if (codeExample.getCodeType() == null) {
                codeDesign.getCodeTypeLabel().setVisible(false);
            } else {
                codeDesign.getCodeTypeLabel().setText(codeExample.getCodeType());
            }
            getCodeExampleHolder().add(codeDesign);
        });
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

    private int countLines(String str) {
        return str.split("\r\n|\r|\n").length;
    }

}
