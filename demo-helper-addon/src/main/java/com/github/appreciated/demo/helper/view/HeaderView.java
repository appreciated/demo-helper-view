package com.github.appreciated.demo.helper.view;

import com.github.appreciated.demo.helper.view.design.HeaderDesign;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;

public class HeaderView extends HeaderDesign {
    public HeaderView(String header, String url) {
        getHeaderLabel().setValue(header);
        getUrl().setResource(new ExternalResource(url));
    }

    public HeaderView(String header, Resource url) {
        getUrl().setResource(url);
    }

    public HeaderView(String title) {
        getHeaderLabel().setValue(title);
        getUrl().setVisible(false);
    }
}
