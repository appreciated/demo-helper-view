package com.github.appreciated.demo.helper.view.other;


import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.prism.element.PrismHighlighter;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * https://codepen.io/v4ku1a/pen/WxLxgb
 * or
 * https://www.webcomponents.org/element/ryersonlibrary/rula-expandable-card/demo/demo/index.html
 * and
 * https://material.io/design/motion/understanding-motion.html#usage
 */
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
                    .set("border-radius", "var(--lumo-border-radius)")
                    .set("color", "var(--lumo-primary-contrast-color)")
                    .set("box-shadow", "var(--lumo-box-shadow-s)")
                    .set("pointer-events", "none");
            add(codeTypeLabel);
        }
    }

    public PrismHighlighter getStepCode() {
        return stepCode;
    }

    public Label getCodeTypeLabel() {
        return codeTypeLabel;
    }

}
