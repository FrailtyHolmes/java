package com.admin.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @author Frailty
 * @date 2023年03月13日 21:19
 */
@Component
@Endpoint(id="myservice")
public class MyServiceEndPoint {
    @ReadOperation
    public Map getDockerInfo(){
        //端点的读操作  http://localhost:8080/actuator/myservice
        return Collections.singletonMap("dockerInfo","docker started.....");
    }
    
    @WriteOperation
    public void stopDocker(){
        System.out.println("docker stopped.....");
    }
}
