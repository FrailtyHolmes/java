package com.admin.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author Frailty
 * @date 2023年03月13日 21:22
 */
@Component
public class InfoContributor implements org.springframework.boot.actuate.info.InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg","你好")
                .withDetails(Collections.singletonMap("world","666666666"));
    }
}
