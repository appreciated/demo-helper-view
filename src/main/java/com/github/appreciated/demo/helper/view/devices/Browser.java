package com.github.appreciated.demo.helper.view.devices;

import com.github.appreciated.demo.helper.component.IFrame;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.WebBrowser;

import java.util.ArrayList;
import java.util.List;

public class Browser extends VerticalLayout {
    private final TextField url;
    private final IFrame browserWindow;
    private final Button backButton;
    private final Button forwardButton;
    private final Button refreshButton;
    private final HorizontalLayout navigationBar;

    private final List<String> history = new ArrayList<>();
    private int historyMarker = 0;

    public Browser(Class<? extends Component> route) {
        setSizeUndefined();
        browserWindow = new IFrame(route);
        browserWindow.setSizeFull();
        url = new TextField();
        url.getStyle().set("flex", "1 1");
        String urlPath = UI.getCurrent().getRouter().getUrl(route);
        url.setValue(urlPath);
        history.add(urlPath);
        historyMarker = 0;
        url.addKeyPressListener(Key.ENTER, event -> browserWindow.setSrc(url.getValue()));
        url.getStyle()
                .set("padding-left", "var(--lumo-space-s)")
                .set("--lumo-border-radius", "var(--lumo-size-m)");

        WebBrowser browser = UI.getCurrent().getSession().getBrowser();
        Label prefixLabel = new Label((browser.isSecureConnection() ? "https://" : "http://") + browser.getAddress() + "/");
        url.setPrefixComponent(prefixLabel);

        backButton = new Button(VaadinIcon.ARROW_LEFT.create());
        backButton.setThemeName("tertiary");
        backButton.setEnabled(false);

        forwardButton = new Button(VaadinIcon.ARROW_RIGHT.create());
        forwardButton.setThemeName("tertiary");
        forwardButton.setEnabled(false);

        backButton.addClickListener(event -> {
            browserWindow.back();
            historyMarker--;
            updateButtons();
        });

        forwardButton.addClickListener(event -> {
            browserWindow.forward();
            historyMarker++;
            updateButtons();
        });

        refreshButton = new Button(VaadinIcon.REFRESH.create(), event -> browserWindow.reload());
        refreshButton.setThemeName("tertiary");

        navigationBar = new HorizontalLayout(
                backButton,
                forwardButton,
                refreshButton,
                this.url
        );
        navigationBar.getChildren().forEach(component -> component.getElement().getStyle().set("flex-shrink", "0"));
        navigationBar.setAlignItems(Alignment.CENTER);
        navigationBar.setWidth("100%");
        navigationBar.setPadding(false);
        navigationBar.getStyle()
                .set("border-bottom", "1px solid var(--lumo-contrast-40pct)")
                .set("--lumo-primary-text-color", "var(--lumo-contrast-70pct)")
                .set("padding", "var(--lumo-space-s)");
        navigationBar.setSpacing(false);
        add(navigationBar);
        add(browserWindow);
        setSpacing(false);
        setMargin(false);
        setPadding(false);
        browserWindow.addOnUrlChangedListener(path -> {
            history.add(path);
            url.setValue(path);
            historyMarker++;
            updateButtons();
        });
    }

    private void updateButtons() {
        backButton.setEnabled(history.size() > 0 && historyMarker > 0);
        forwardButton.setEnabled(historyMarker < history.size() - 1);
    }

    public IFrame getBrowserWindow() {
        return browserWindow;
    }

    public TextField getUrl() {
        return url;
    }

    public Button getBackButton() {
        return backButton;
    }

    public Button getForwardButton() {
        return forwardButton;
    }

    public Button getRefreshButton() {
        return refreshButton;
    }

    public HorizontalLayout getNavigationBar() {
        return navigationBar;
    }
}
