package com.github.appreciated;

import com.github.appreciated.demo.helper.DemoHelperView;
import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.demo.helper.view.entity.CssVariable;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=no")
@Theme(value = Lumo.class, variant = Lumo.DARK)
public class DemoView extends VerticalLayout {

    public DemoView() {


        DemoHelperView demoView = new DemoHelperView()
                .withVerticalHeader("VerticalHeaderView",
                        "I can display a header and an optionally an image or a subtitle",
                        "images/demo-helper-logo.png"
                )
                .withHorizontalHeader("HorizontalHeaderView",
                        "I can display a header and optionally an image or I am suited for longer description texts. Additionally I may contain Components which are display beneath the description that can be used to display f.e. links",
                        "images/demo-helper-logo.png",
                        new Button("Click Me!")
                )
                .withTabletAndPhoneView(
                        getDeviceContent("< I belong to a TabletAndPhoneView an display content inside a css rendered tablet >"),
                        getDeviceContent("< I also belong to a TabletAndPhoneView an display content inside a css rendered phone >")
                )
                .withParagraph("I am a ParagraphView", "I can display a header and a description")
                .withStylablePhone(getDeviceContent("< I'm a StylablePhoneView I display content and my css variables can be edited beside me >"), new CssVariable("--lumo-primary-text-color"), new CssVariable("--lumo-primary-color"))
                .withPhone(
                        getDeviceContent("< I belong to a PhoneView I display content inside a css rendered phone >"),
                        "Also I can show a optional message beside the PhoneView"
                )
                .withImage("I am a ImageParagraphView", "I can display a header, a description and an image", "images/phone.png")
                .withStylableTablet(getDeviceContent("< I belong to a TabletView I display content inside a css rendered tablet >"), new CssVariable("--lumo-primary-text-color"))
                .withTablet(getDeviceContent("< I belong to a TabletView I display content inside a css rendered tablet >"))
                .withParagraph("I am a ParagraphView",
                        "I display a header and optionally a description. Also you can add components below the description",
                        new Button("Click Me!")
                )
                .withParagraph("I am a ParagraphView without description")
                .withParagraph("I am a ParagraphView without description")
                .withParagraph("I am a ParagraphView without description but with a Component", new Button("Click Me"))
                .withLaptopView(getDeviceContent("< I belong to a LaptopView I display content inside a css rendered laptop >"))
                .withStep("I am a StepView",
                        "I display a header step number (1,2,3,4,5) which is automatically generated, also a description and one or multiple code examples",
                        new CodeExample("<dependency>\n" +
                                "\t<groupId>com.github.appreciated</groupId>\n" +
                                "\t<artifactId>demo-helper</artifactId>\n" +
                                "\t<version>0.8.2</version>\n" +
                                "</dependency>", "xml", "Maven")
                )
                .withStep("I am also a StepView",
                        "And I contain a single code example",
                        new CodeExample("clean install", "xml", "Maven")
                )
                .withStep("I am also a StepView", "And I contain multiple code examples",
                        new CodeExample("// Initialize our new UI component\n" +
                                "DemoView demoView = new DemoView(\"DemoView Demo\", \n" +
                                "        \"https://github.com/appreciated/vaadin-app-layout\", \n" +
                                "        new VerticalLayout(new Button(\"Tablet\")), \n" +
                                "        new VerticalLayout(new Button(\"Handheld\"))\n" +
                                ");", "java", "Java"),
                        new CodeExample("DemoView demoView = new DemoView(\"DemoView Demo\", \n" +
                                "        \"https://github.com/appreciated/vaadin-app-layout\", \n" +
                                "        new VerticalLayout(new Button(\"Tablet\")), \n" +
                                "        new VerticalLayout(new Button(\"Handheld\"))\n" +
                                ");", "java", "Java"),
                        new CodeExample("DemoView demoView = new DemoView(\"DemoView Demo\", \n" +
                                "        \"https://github.com/appreciated/vaadin-app-layout\", \n" +
                                "        new VerticalLayout(new Button(\"Tablet\")), \n" +
                                "        new VerticalLayout(new Button(\"Handheld\"))\n" +
                                ");", "java", "Java")
                );
        add(demoView);
        setSizeFull();
    }

    VerticalLayout getDeviceContent(String text) {
        Label label = new Label(text);
        label.setSizeFull();
        VerticalLayout contentHolder = new VerticalLayout(label);
        contentHolder.add(new Button("Test"));
        contentHolder.setSizeFull();
        contentHolder.getElement().getStyle().set("background", "white");
        return contentHolder;
    }

}
