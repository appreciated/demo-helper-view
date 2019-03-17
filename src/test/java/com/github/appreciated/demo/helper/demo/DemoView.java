package com.github.appreciated.demo.helper.demo;

import com.github.appreciated.demo.helper.DemoHelperView;
import com.github.appreciated.demo.helper.component.browser.RouteBrowser;
import com.github.appreciated.demo.helper.component.iframe.RouteIFrame;
import com.github.appreciated.demo.helper.entity.CodeExample;
import com.github.appreciated.demo.helper.entity.CssVariable;
import com.github.appreciated.demo.helper.entity.GithubDependencies;
import com.github.appreciated.demo.helper.entity.GithubUrl;
import com.github.appreciated.demo.helper.view.devices.*;
import com.github.appreciated.prism.element.Language;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.Route;

import static com.github.appreciated.calc.color.helper.LumoVariables.LUMO_PRIMARY_COLOR;
import static com.github.appreciated.calc.color.helper.LumoVariables.LUMO_PRIMARY_TEXT_COLOR;

@Route("")
//@Theme(value = Lumo.class, variant = Lumo.DARK)
public class DemoView extends DemoHelperView {

    public DemoView() {
        super(new GithubUrl("https://github.com/appreciated/vaadin-app-layout"), new GithubDependencies("https://github.com/OlliTietavainenVaadin/clipboardhelper", "https://github.com/appreciated/grid-layout", "https://github.com/appreciated/card", "https://github.com/appreciated/prism-element", "https://github.com/appreciated/paper-color", "https://github.com/appreciated/iron-collapse", "https://github.com/appreciated/calculated-color-helper"));
        withVerticalHeader("VerticalHeaderView",
                "I can display a header and an optionally an image or a subtitle",
                "images/demo-helper-logo.png")
                .withHorizontalHeader("HorizontalHeaderView",
                        "I can display a header and optionally an image or I am suited for longer description texts. Additionally I may contain Components which are display beneath the description that can be used to display f.e. links",
                        "images/demo-helper-logo.png",
                        new Button("Click Me!")
                )
                .withStylableDevice(getDeviceContent("< I am a stylable device, meaning that you can edit the css variables of this view by clicking on the brush button below) >"), new CssVariable(LUMO_PRIMARY_TEXT_COLOR), new CssVariable(LUMO_PRIMARY_COLOR))
                .withStylableDevice(new RouteBrowser(OtherContent.class), new CssVariable(LUMO_PRIMARY_TEXT_COLOR), new CssVariable(LUMO_PRIMARY_COLOR))
                .withStylableDevice(new RouteIFrame(OtherContent.class), new CssVariable(LUMO_PRIMARY_TEXT_COLOR), new CssVariable(LUMO_PRIMARY_COLOR))
                .withThemeableAndStylableDevice(getDeviceContent("< I am also a stylable device as above and also themeable meaning that the theme (Lumo.Dark and Lumo.Light) can be switched between by clicking on the switch above) >"), new CssVariable(LUMO_PRIMARY_TEXT_COLOR), new CssVariable(LUMO_PRIMARY_COLOR))
                .withStylableDevice(getDeviceContent("Yay"), DeviceType.TABLET_LANDSCAPE)
                .withDevice(new LaptopView(new Text("test")))
                .withDevices(
                        new TabletView(getDeviceContent("< I belong to a TabletAndPhoneView an display content inside a css rendered tablet >")).withOrientation(Orientation.LANDSCAPE),
                        new PhoneView(getDeviceContent("< I also belong to a TabletAndPhoneView an display content inside a css rendered phone >"))
                )
                .withParagraph("I am a ParagraphView", "I can display a header and a description")
                .withStylableDevice(getDeviceContent("< I'm a StylablePhoneView I display content and my css variables can be edited beside me >"), new CssVariable(LUMO_PRIMARY_TEXT_COLOR), new CssVariable(LUMO_PRIMARY_COLOR))
                .withDevice(new PhoneView(
                                getDeviceContent("< I belong to a PhoneView I display content inside a css rendered phone >")),
                        "Also I can show a optional message beside the PhoneView"
                )
                .withImage("I am a ImageParagraphView", "I can display a header, a description and an image", "images/phone.png")
                .withStylableDevice(getDeviceContent("< I belong to a TabletView I display content inside a css rendered tablet >"), new CssVariable(LUMO_PRIMARY_TEXT_COLOR))
                .withDevice(new TabletView(getDeviceContent("< I belong to a TabletView I display content inside a css rendered tablet >")))
                .withParagraph("I am a ParagraphView",
                        "I display a header and optionally a description. Also you can add components below the description",
                        new Button("Click Me!")
                )
                .withParagraph("I am a ParagraphView without description")
                .withParagraph("I am a ParagraphView without description")
                .withParagraph("I am a ParagraphView without description but with a Component", new Button("Click Me"))
                .withDevice(new LaptopView(getDeviceContent("< I belong to a LaptopView I display content inside a css rendered laptop >")))
                .withStep("I am a StepView",
                        "I display a header step number (1,2,3,4,5) which is automatically generated, also a description and one or multiple code examples",
                        new CodeExample("<dependency>\n" +
                                "\t<groupId>com.github.appreciated</groupId>\n" +
                                "\t<artifactId>demo-helper</artifactId>\n" +
                                "\t<version>2.0.8</version>\n" +
                                "</dependency>", Language.markup, "Maven")
                )
                .withStep("I am also a StepView",
                        "And I contain a single code example",
                        new CodeExample("clean install", Language.markup, "Maven")
                )
                .withStep("I am also a StepView", "And I contain multiple highlighted code examples",
                        new CodeExample("package com.github.appreciated.demo.helper.view.devices;\n" +
                                "\n" +
                                "import com.vaadin.flow.component.Component;\n" +
                                "\n" +
                                "public class MyClass extends AnotherClass {\n" +
                                "    private AndAnotherClass attribute;\n" +
                                "    \n" +
                                "    \n" +
                                "    public MyClass(Component component) {\n" +
                                "        super(component);\n" +
                                "        someMethod();\n" +
                                "    }\n" +
                                "\n" +
                                "    private void someMethod() {\n" +
                                "        \n" +
                                "    }\n" +
                                "\n" +
                                "}\n", Language.java, "Java"),
                        new CodeExample("package com.github.appreciated.demo.helper.view.devices;\n" +
                                "\n" +
                                "import com.vaadin.flow.component.Component;\n" +
                                "\n" +
                                "public class MyClass extends AnotherClass {\n" +
                                "    private AndAnotherClass attribute;\n" +
                                "    \n" +
                                "    \n" +
                                "    public MyClass(Component component) {\n" +
                                "        super(component);\n" +
                                "        someMethod();\n" +
                                "    }\n" +
                                "\n" +
                                "    private void someMethod() {\n" +
                                "        \n" +
                                "    }\n" +
                                "\n" +
                                "}\n", Language.java, "Java"),
                        new CodeExample("package com.github.appreciated.demo.helper.view.devices;\n" +
                                "\n" +
                                "import com.vaadin.flow.component.Component;\n" +
                                "\n" +
                                "public class MyClass extends AnotherClass {\n" +
                                "    private AndAnotherClass attribute;\n" +
                                "    \n" +
                                "    \n" +
                                "    public MyClass(Component component) {\n" +
                                "        super(component);\n" +
                                "        someMethod();\n" +
                                "    }\n" +
                                "\n" +
                                "    private void someMethod() {\n" +
                                "        \n" +
                                "    }\n" +
                                "\n" +
                                "}\n", Language.java, "Java")
                )
                .withContributorNotice()
                .withDependencyNotice();
    }


    VerticalLayout getDeviceContent(String text) {
        Label label = new Label(text);
        label.setSizeFull();
        VerticalLayout content = new VerticalLayout(label);
        RadioButtonGroup<String> group = new RadioButtonGroup<String>();
        group.setItems("Test");
        content.add(new Button("Test"), group);
        content.setSizeFull();
        return content;
    }

}
