package com.sun.apps.common.config.props.internal;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class LiveProps {

    @Value("${live.message:Default Live Message}")
    private String message;

    @Value("${live.status:inactive}")
    private String status;

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "LiveProps{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

