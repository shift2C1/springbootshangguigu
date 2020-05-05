package com.pipichao.helloword.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @ConfigurationProperties: 将本类中的属性值由yaml配置文件提供
 * 默认从全局配置问家中加载（application.yaml）
 *
 * */

/**
 * @PropertySource:从指定的配置文件中加载
 *
 * */

/**
 * @ImportResource:导入spring.xml的配置文件
 * */


@Component
//@ConfigurationProperties(prefix = "user")
@PropertySource(value = {"classpath:user.properties"})

//@ImportResource
public class User {


    /**
     * 也可以通过@Value注解一个一个指定
     * */
//    @Value("${user.name}")
    private String name;
    private Integer age;
    private Map<String,Object> maps;
    private List<String> lists;

    public User(String name, Integer age, Map<String, Object> maps, List<String> lists) {
        this.name = name;
        this.age = age;
        this.maps = maps;
        this.lists = lists;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }


}
