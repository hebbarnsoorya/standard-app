package com.sun.apps.admin.resource.internal;

import com.sun.apps.common.config.props.internal.AppProps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/config")
public class ConfigController {

    private final AppProps appProps;

    public ConfigController(AppProps appProps) {
        this.appProps = appProps;
    }

    @GetMapping
    public AppProps getConfig() {
        return appProps;
    }
}

