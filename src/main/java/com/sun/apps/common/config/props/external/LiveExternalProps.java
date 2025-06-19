package com.sun.apps.common.config.props.external;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
@ConfigurationProperties(prefix = "live")
public class LiveExternalProps {

    private String mode;
    private String status;

    // Getters and Setters

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LiveExternalProps{" +
                "mode='" + mode + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

