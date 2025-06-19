package com.sun.apps.common.config.props.internal;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppYamlProps {

    private String name;
    private String version;
    private Feature feature = new Feature();
    private int timeout;

    public static class Feature {
        private boolean enabled;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "AppYamlProps{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", feature.enabled=" + feature.enabled +
                ", timeout=" + timeout +
                '}';
    }
}

