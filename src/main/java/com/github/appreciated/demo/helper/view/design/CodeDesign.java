package com.github.appreciated.demo.helper.view.design;


import com.github.appreciated.prism.element.PrismHighlighter;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class CodeDesign extends VerticalLayout {
    private PrismHighlighter stepCode;
    private Label codeTypeLabel;

    public CodeDesign(String code, String lang) {
        getElement().getClassList().add("code-example-text-area");
        stepCode = new PrismHighlighter(code, lang);
        codeTypeLabel = new Label(lang);
        codeTypeLabel.getStyle()
                .set("background", "var(--lumo-primary-color)")
                .set("padding", "0 12px")
                .set("border-radius", "10px")
                .set("color", "var(--lumo-primary-contrast-color)")
                .set("box-shadow", "var(--lumo-box-shadow-s)");

        add(stepCode, codeTypeLabel);
    }

    public PrismHighlighter getStepCode() {
        return stepCode;
    }

    public Label getCodeTypeLabel() {
        return codeTypeLabel;
    }

}
