package com.sun.apps.admin.resource.internal;

import com.sun.apps.common.config.props.internal.LiveProps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/live")
public class LiveConfigController {

    private final LiveProps liveProps;

    public LiveConfigController(LiveProps liveProps) {
        this.liveProps = liveProps;
    }

    @GetMapping
    public LiveProps getLiveConfig() {
        return liveProps;
    }
}

