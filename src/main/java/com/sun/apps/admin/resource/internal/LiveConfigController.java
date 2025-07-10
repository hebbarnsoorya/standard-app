package com.sun.apps.admin.resource.internal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.apps.common.config.props.internal.LiveProps;
import com.sun.apps.common.config.props.internal.LivePropsDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/live")
public class LiveConfigController {

    private final LiveProps liveProps;

    private final ObjectMapper objectMapper;

    public LiveConfigController(LiveProps liveProps, ObjectMapper mapper) {
        this.liveProps = liveProps;
        this.objectMapper = mapper;
    }

    @GetMapping
    public String getLiveConfig() {

            return "" +
                    "" +liveProps.getMessage() +" : "+liveProps.getStatus()+": "+
                    "";
            //String livePropsAsString = objectMapper.writeValueAsString(this.liveProps);
            //return objectMapper.readValue(livePropsAsString, LivePropsDTO.class);



    }
}

