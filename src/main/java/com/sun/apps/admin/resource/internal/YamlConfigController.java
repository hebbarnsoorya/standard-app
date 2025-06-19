package com.sun.apps.admin.resource.internal;

import com.sun.apps.common.config.props.internal.AppYamlProps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/yaml-config")
public class YamlConfigController {

    private final AppYamlProps appYamlProps;

    public YamlConfigController(AppYamlProps appYamlProps) {
        this.appYamlProps = appYamlProps;
    }

    @GetMapping
    public AppYamlProps getYamlConfig() {
        return appYamlProps;
    }
}

