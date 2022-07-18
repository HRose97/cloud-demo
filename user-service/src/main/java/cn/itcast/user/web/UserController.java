package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
// @RefreshScope        nacos热配置的开关----自动刷新   方式一
public class UserController {

    @Autowired
    private UserService userService;

    //属性注解
    //@NacosValue("${pattern.dateformat}")
    //private String dateformat;

    //nacos  方式二  属性注入方式  一般使用方式二
    @Autowired
    private PatternProperties properties;

    //测试nacos环境共享属性
    @GetMapping("prop")
    public PatternProperties properties(){
        return properties;
    }

    @GetMapping("now")
    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
    }

    /**
     * 路径： /user/110
     * @RequestHeader 请求头是由spirng geteaway提供的过滤器  该过滤器是在请求中添加字段
     * required = false  可以传可以不传
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,
                          @RequestHeader(value = "Truth", required = false) String truth) {
        System.out.println("truth: " + truth);
        return userService.queryById(id);
    }
}
