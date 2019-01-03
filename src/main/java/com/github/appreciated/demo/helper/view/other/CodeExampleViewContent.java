package com.github.appreciated.demo.helper.view.other;


import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.prism.element.PrismHighlighter;
import com.github.appreciated.ripple.PaperRipple;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class CodeExampleViewContent extends VerticalLayout {
    private PrismHighlighter stepCode;
    private Label codeTypeLabel;

    public CodeExampleViewContent(CodeExample example) {
        this(example.getCode(), example.getCodeType());
        setMargin(false);
    }

    public CodeExampleViewContent(String code, String lang) {
        getStyle().set("position", "relative");
        stepCode = new PrismHighlighter(code, lang);

        add(stepCode);
        if (lang != null) {
            codeTypeLabel = new Label(lang);
            codeTypeLabel.getStyle()
                    .set("background", "var(--lumo-primary-color)")
                    .set("padding", "0 12px")
                    .set("border-radius", "10px")
                    .set("color", "var(--lumo-primary-contrast-color)")
                    .set("box-shadow", "var(--lumo-box-shadow-s)")
                    .set("pointer-events", "none");
            add(codeTypeLabel);
        }
        PaperRipple ripple = new PaperRipple();
        ripple.getElement().getStyle().set("margin", "unset");
        getElement().getStyle().set("position", "relative");
        add(ripple);
    }

    public PrismHighlighter getStepCode() {
        return stepCode;
    }

    public Label getCodeTypeLabel() {
        return codeTypeLabel;
    }

}
