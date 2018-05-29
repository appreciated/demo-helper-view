package com.github.appreciated;

import com.github.appreciated.demo.helper.DemoHelperView;
import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class DemoView extends Div {

    public DemoView() {
        DemoHelperView demoView = new DemoHelperView()
                .withVerticalHeaderView("VerticalHeaderView",
                        "I can display a header and an optionally an image or a subtitle",
                        "images/demo-helper-logo.png"
                )
                .withHorizontalHeaderView("HorizontalHeaderView",
                        "I can display a header and optionally an image or I am suited for longer description texts. Additionally I may contain Components which are display beneath the description that can be used to display f.e. links",
                        "images/demo-helper-logo.png",
                        new Button("Click Me!")
                )
                .withTabletAndPhoneView(
                        getLabel("< I belong to a TabletAndPhoneView an display content inside a css rendered tablet >"),
                        getLabel("< I also belong to a TabletAndPhoneView an display content inside a css rendered phone >")
                )
                .withParagraphView("I am a ParagraphView", "I can display a header and a description")
                .withPhoneView(
                        getLabel("< I belong to a PhoneView I display content inside a css rendered phone >"),
                        "Also I can show a optional message beside the PhoneView"
                )
                .withImageParagraphView("I am a ImageParagraphView", "I can display a header, a description and an image", "images/phone.png")
                .withTabletView(getLabel("< I belong to a TabletView I display content inside a css rendered tablet >"))
                .withParagraphView("I am a ParagraphView",
                        "I display a header and optionally a description. Also you can add components below the description",
                        new Button("Click Me!")
                )
                .withParagraphView("I am a ParagraphView without description")
                .withParagraphView("I am a ParagraphView without description")
                .withParagraphView("I am a ParagraphView without description but with a Component", new Button("Click Me"))
                .withLaptopView(getLabel("< I belong to a LaptopView I display content inside a css rendered laptop >"))
                .withStepView("I am a StepView",
                        "I display a header step number (1,2,3,4,5) which is automatically generated, also a description and one or multiple code examples",
                        new CodeExample("<dependency>\n" +
                                "\t<groupId>com.github.appreciated</groupId>\n" +
                                "\t<artifactId>demo-helper</artifactId>\n" +
                                "\t<version>0.8.2</version>\n" +
                                "</dependency>", "Maven")
                )
                .withStepView("I am also a StepView",
                        "And I contain a single code example",
                        new CodeExample("clean install", "Maven")
                )
                .withStepView("I am also a StepView", "And I contain multiple code examples",
                        new CodeExample("// Initialize our new UI component\n" +
                                "DemoView demoView = new DemoView(\"DemoView Demo\", \n" +
                                "        \"https://github.com/appreciated/vaadin-app-layout\", \n" +
                                "        new VerticalLayout(new Button(\"Tablet\")), \n" +
                                "        new VerticalLayout(new Button(\"Handheld\"))\n" +
                                ");", "java"),
                        new CodeExample("DemoView demoView = new DemoView(\"DemoView Demo\", \n" +
                                "        \"https://github.com/appreciated/vaadin-app-layout\", \n" +
                                "        new VerticalLayout(new Button(\"Tablet\")), \n" +
                                "        new VerticalLayout(new Button(\"Handheld\"))\n" +
                                ");", "java"),
                        new CodeExample("DemoView demoView = new DemoView(\"DemoView Demo\", \n" +
                                "        \"https://github.com/appreciated/vaadin-app-layout\", \n" +
                                "        new VerticalLayout(new Button(\"Tablet\")), \n" +
                                "        new VerticalLayout(new Button(\"Handheld\"))\n" +
                                ");", "java")
                );
        demoView.setSizeFull();
        add(demoView);
    }

    VerticalLayout getLabel(String text) {
        Label label = new Label(text);
        label.setSizeFull();
        return new VerticalLayout(label);
    }

}
