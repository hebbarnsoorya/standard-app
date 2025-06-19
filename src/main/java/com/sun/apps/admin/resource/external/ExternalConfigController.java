package com.sun.apps.admin.resource.external;

import com.sun.apps.common.config.props.external.ExternalProps;
import com.sun.apps.common.config.props.external.LiveExternalProps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/external-config")
public class ExternalConfigController {

    private final ExternalProps staticProps;
    private final LiveExternalProps liveProps;

    public ExternalConfigController(ExternalProps staticProps, LiveExternalProps liveProps) {
        this.staticProps = staticProps;
        this.liveProps = liveProps;
    }

    @GetMapping("/static")
    public ExternalProps getStaticConfig() {
        return staticProps;
    }

    @GetMapping("/live")
    public LiveExternalProps getLiveConfig() {
        return liveProps;
    }
}

