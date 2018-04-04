package cn.aop.service;

import org.springframework.stereotype.Service;

/**
 * Created by Smile on 2018/4/4.
 */
@Service
public class SampleService {

    public void service(String param) {
        System.out.println("Service running ... " + param);
    }
}
