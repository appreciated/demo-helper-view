package com.github.appreciated.demo.helper.view.other;


import com.github.appreciated.demo.helper.component.GraniteClipboard;
import com.github.appreciated.demo.helper.entity.CodeExample;
import com.github.appreciated.prism.element.Language;
import com.github.appreciated.prism.element.PrismHighlighter;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 */
public class CodeExampleViewContent extends GraniteClipboard {
    VerticalLayout wrapper = new VerticalLayout();
    private PrismHighlighter code;
    private Label type;

    public CodeExampleViewContent(CodeExample example) {
        this(example.getCode(), example.getHighlightingType(), example.getCodeType());
        wrapper.setMargin(false);
    }

    public CodeExampleViewContent(String code, Language highlightingType, String lang) {
        wrapper.getStyle().set("position", "relative").set("overflow", "auto");
        this.code = new PrismHighlighter(code, highlightingType);
        wrapper.add(this.code);
        if (lang != null) {
            type = new Label(lang);
            type.getStyle()
                    .set("background", "var(--lumo-primary-color)")
                    .set("padding", "0 12px")
                    .set("border-radius", "var(--lumo-border-radius)")
                    .set("color", "var(--lumo-primary-contrast-color)")
                    .set("box-shadow", "var(--lumo-box-shadow-s)")
                    .set("pointer-events", "none");
            wrapper.add(type);
        }
        add(wrapper);
    }

    public PrismHighlighter getCode() {
        return code;
    }

    public Label getType() {
        return type;
    }

}
