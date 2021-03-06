package com.github.appreciated.demo.helper;

import com.github.appreciated.card.Card;
import com.github.appreciated.card.RippleClickableCard;
import com.github.appreciated.demo.helper.component.browser.Browser;
import com.github.appreciated.demo.helper.component.iframe.IFrame;
import com.github.appreciated.demo.helper.entity.*;
import com.github.appreciated.demo.helper.external.ContributorParser;
import com.github.appreciated.demo.helper.external.ProjectParser;
import com.github.appreciated.demo.helper.external.github.GithubContributorParser;
import com.github.appreciated.demo.helper.external.github.GithubProjectParser;
import com.github.appreciated.demo.helper.view.components.layout.SinglePageLayout;
import com.github.appreciated.demo.helper.view.devices.Device;
import com.github.appreciated.demo.helper.view.devices.DeviceSwitchView;
import com.github.appreciated.demo.helper.view.devices.IPhoneXView;
import com.github.appreciated.demo.helper.view.other.CodeExampleView;
import com.github.appreciated.demo.helper.view.other.ThemeSwitchView;
import com.github.appreciated.demo.helper.view.paragraph.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.dependency.StyleSheet;

import java.util.Arrays;

@StyleSheet("./com/github/appreciated/demo-helper/demo-helper.css")
public class DemoHelperView extends SinglePageLayout {

    private ProjectParser projectParser;
    private ContributorParser contributorParser;
    private String projectUrl;
    private int counter = 1;
    private Dependencies dependencies;

    public DemoHelperView(GithubUrl url, GithubDependencies dependencies) {
        this(url.getUrl(), dependencies, GithubContributorParser.getInstance(url.getUrl()), new GithubProjectParser(dependencies));
    }

    public DemoHelperView(String projectUrl, Dependencies dependencies, ContributorParser parser, ProjectParser projectParser) {
        this(parser, projectParser);
        this.dependencies = dependencies;
        this.projectUrl = projectUrl;
    }

    public DemoHelperView(ContributorParser contributorParser, ProjectParser projectParser) {
        this(contributorParser);
        if (projectParser != null) {
            this.projectParser = projectParser;
        }
    }

    public DemoHelperView(ContributorParser parser) {
        this();
        if (parser != null) {
            contributorParser = parser;
        }
    }

    public DemoHelperView() {
        getElement().setAttribute("theme", "spacing-xl");
        getElement().getStyle().set("--flex-layout-space", "3rem");
    }

    public DemoHelperView(String projectUrl) {
        this(projectUrl.startsWith("https://github.com/") ? GithubContributorParser.getInstance(projectUrl) : null);
        this.projectUrl = projectUrl;
    }

    public DemoHelperView withVerticalHeader(String header) {
        return withVerticalHeader(header, null, null);
    }

    public DemoHelperView withVerticalHeader(String header, String description, String image) {
        addHeader(new VerticalHeaderView(header, description, image));
        return this;
    }

    private void addHeader(Component component) {
        addFullHeightComponent(component).getElement().getClassList().add("content-wrapper-small");
    }

    public DemoHelperView withHorizontalHeader(String header, String description) {
        return withHorizontalHeader(header, description, null);
    }

    public DemoHelperView withHorizontalHeader(String header, String description, String image) {
        addHeader(new HorizontalHeaderParagraphView(header, description, image));
        return this;
    }

    public DemoHelperView withHorizontalHeader(String header) {
        return withHorizontalHeader(header, null, null);
    }

    public DemoHelperView withDevice(Device device, String s) {
        addParagraph(new DeviceParagraphView(device, s));
        return this;
    }

    private void addParagraph(Component component) {
        add(component);
        component.getElement().getClassList().add("content-wrapper-small");
    }

    @Override
    public void add(Component... components) {
        super.add(components);
        Arrays.stream(components).forEach(component -> {
            component.getElement().getStyle().set("flex-shrink", "0");
        });
    }

    public DemoHelperView withHorizontalHeader(String header, String description, String image, Component... components) {
        addHeader(new HorizontalHeaderParagraphView(header, description, image, components));
        return this;
    }

    public DemoHelperView withDevice(Device device) {
        add(new DeviceParagraphView(device));
        return this;
    }

    public DemoHelperView withStylableDevice(Component content, CssVariable... cssVariables) {
        return withStylableDevice(new IPhoneXView(content), cssVariables);
    }

    public DemoHelperView withStylableDevice(Device device, CssVariable... cssVariables) {
        DeviceSwitchView view = new DeviceSwitchView(device);
        if (cssVariables.length > 0) {
            view.withStyleableVariables(cssVariables);
            if (device.getContent() instanceof Browser) {
                view.withStyleableView(((Browser) device.getContent()).getBrowserWindow());
            }
            if (device.getContent() instanceof IFrame) {
                view.withStyleableView((HasStyle) device.getContent());
            }
        }
        //view.setDeviceType(type);
        add(view);
        return this;
    }

    public DemoHelperView withThemeableAndStylableDevice(Component content, CssVariable... cssVariables) {
        return withThemeableAndStylableDevice(new IPhoneXView(content), cssVariables);
    }

    public DemoHelperView withThemeableAndStylableDevice(Device device, CssVariable... cssVariables) {
        DeviceSwitchView view = new DeviceSwitchView(device);
        if (cssVariables.length > 0) {
            view.withStyleableVariables(cssVariables);
        }
        //view.setDeviceType(type);
        add(new ThemeSwitchView(view));
        return this;
    }

    public DemoHelperView withDevices(Device device1, Device device2) {
        addLargeParagraph(new DevicesParagraphView(device1, device2));
        return this;
    }

    private void addLargeParagraph(Component component) {
        add(component);
        component.getElement().getClassList().add("content-wrapper");
    }

    public DemoHelperView withParagraph(String header) {
        addParagraph(new ParagraphView(header));
        return this;
    }

    public DemoHelperView withParagraph(String header, Component... components) {
        addParagraph(new ParagraphView(header, components));
        return this;
    }

    public DemoHelperView withParagraph(String header, String description) {
        addParagraph(new ParagraphView(header, description));
        return this;
    }

    public DemoHelperView withParagraph(String header, String description, Component... components) {
        addParagraph(new ParagraphView(header, description, components));
        return this;
    }

    public DemoHelperView withImage(String header, String description, String resource) {
        addParagraph(new ImageParagraphView(header, description, resource));
        return this;
    }

    public DemoHelperView withStep(String title, String description, CodeExample... codeExamples) {
        addParagraph(new StepView(counter++, title, description, codeExamples));
        return this;
    }

    public DemoHelperView withCounterStep(int c) {
        counter = c;
        return this;
    }

    public DemoHelperView resetCounterStep() {
        counter = 1;
        return this;
    }

    public DemoHelperView with(Component component) {
        add(component);
        return this;
    }

    /**
     * requires the url constructor to be used
     */
    public DemoHelperView withContributorNotice() {
        if (contributorParser == null) {
            throw new IllegalStateException("Please set the project URL or a ContributorParser by using the DemoHelperView constructor");
        }
        addParagraph(new ContributorView(contributorParser.getContributors()));
        return this;
    }

    /**
     * requires the url constructor to be used
     */
    public DemoHelperView withDependencyNotice() {
        if (projectParser == null) {
            throw new IllegalStateException("Please set the project dependency URL or a ProjectParser by using the DemoHelperView constructor");
        }
        Project[] projects = projectParser.getProjects();

        if (projects != null && projects.length > 0) {
            addParagraph(new ProjectDependencyView(projects));
        }
        return this;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public Dependencies getDependencies() {
        return dependencies;
    }

    public DemoHelperView withCodeExample(CodeExample codeExample) {
        CodeExampleView codeExampleView = new CodeExampleView(codeExample);
        RippleClickableCard card = new RippleClickableCard(codeExampleView);
        card.setWidth("100%");
        card.getStyle().set("user-select", "none");
        addParagraph(card);
        return this;
    }

    public DemoHelperView withCodeExample(Component componentExample, CodeExample codeExample) {
        CodeExampleView codeExampleView = new CodeExampleView(codeExample);
        codeExampleView.getElement().getStyle().set("background", "var(--lumo-contrast-5pct)");
        RippleClickableCard wrapper = new RippleClickableCard(codeExampleView);
        wrapper.setElevation(0);
        wrapper.setWidthFull();
        wrapper.getTemplateDiv().getStyle().set("border-radius", "0px");
        Card card = new Card(componentExample, wrapper);
        card.setWidth("100%");
        card.getStyle().set("user-select", "none");
        addParagraph(card);
        return this;
    }

}
