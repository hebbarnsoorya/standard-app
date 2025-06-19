package com.sun.apps.common.config.props.external;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class ExternalProps {

    private String env;
    private boolean serviceEnabled;
    private int timeoutMs;

    private Runtime runtime = new Runtime();

    public static class Runtime {
        private String mode;
        private String status;

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
    }

    // Getters and setters

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public boolean isServiceEnabled() {
        return serviceEnabled;
    }

    public void setServiceEnabled(boolean serviceEnabled) {
        this.serviceEnabled = serviceEnabled;
    }

    public int getTimeoutMs() {
        return timeoutMs;
    }

    public void setTimeoutMs(int timeoutMs) {
        this.timeoutMs = timeoutMs;
    }

    public Runtime getRuntime() {
        return runtime;
    }

    public void setRuntime(Runtime runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "ExternalProps{" +
                "env='" + env + '\'' +
                ", serviceEnabled=" + serviceEnabled +
                ", timeoutMs=" + timeoutMs +
                ", runtime=" + runtime.mode + " / " + runtime.status +
                '}';
    }
}

