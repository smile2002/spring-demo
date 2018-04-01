package cn.xiao.entity;

import org.springframework.stereotype.Component;

/**
 * Created by Smile on 2018/3/31.
 */
@Component
public class SimpBean {
    private String name;

    public SimpBean() {
    }
    public SimpBean(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
