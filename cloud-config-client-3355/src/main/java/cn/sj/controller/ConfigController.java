package cn.sj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:类详情
 * @author: sj
 * @createDate: 2021/8/20 13:11
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String configinfo;

    public String getConfiginfo() {
        return configinfo;
    }

    public void setConfiginfo(String configinfo) {
        this.configinfo = configinfo;
    }

    @RequestMapping("/getinfo")
    private String getinfo(){
        return configinfo+"1111111";
    }
}
