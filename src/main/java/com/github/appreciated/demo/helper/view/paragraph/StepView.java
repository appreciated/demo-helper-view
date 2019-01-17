package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.card.RippleClickableCard;
import com.github.appreciated.demo.helper.view.components.layout.CssFlexLayout;
import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.demo.helper.view.other.CodeExampleView;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Arrays;

public class StepView extends CssFlexLayout {
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
        descriptionHolder.getStyle().set("max-width", "610px");
        codeExampleHolder.setWidth("100%");
        codeExampleHolder.getStyle().set("max-width", "610px").set("flex-shrink", "0").set("user-select", "none");
        setWidth("100%");
        setSpacing(false);
        setPadding(true);
        codeExampleHolder.setMargin(false);
        codeExampleHolder.setPadding(false);
        setFlexWrap(FlexWrap.WRAP);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setBoxSizing(BoxSizing.BORDER_BOX);
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
            CodeExampleView codeExampleView = new CodeExampleView(codeExample);
            RippleClickableCard card = new RippleClickableCard(componentEvent -> codeExampleView.onClick(), codeExampleView);
            card.setWidth("100%");
            card.getStyle().set("user-select", "none");
            getCodeExampleHolder().add(card);
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
