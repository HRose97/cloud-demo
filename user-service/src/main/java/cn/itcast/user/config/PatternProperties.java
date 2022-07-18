package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 *
 * nacos热部署第二种方式  方式二
 *
 *  nacos属性注入配置类
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    private String dateformat;
    //userservice环境共享属性
    private String envSharedValue;
    private String name;
}
