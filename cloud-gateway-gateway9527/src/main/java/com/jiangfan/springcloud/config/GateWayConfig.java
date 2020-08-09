package com.jiangfan.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    /**
     * @param routeLocatorBuilder
     * @return 路由定位器注册到IOC
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes(); //相当于cloud:gateway:routes:
        //path_route_jiangfan相当于路由ID   predicate断言    /songlist  匹配路由资源地址 uri("http://music.taihe.com/")
        return routes.route("path_route_jiangfan", e -> e.path("/songlist").uri("http://music.taihe.com"))
             //   .route("path_route_jiangfan2",e -> e.path("/artist").uri("http://music.taihe.com"))
                .build();
 //访问http://localhost:9527/songlist 会被转发到http://music.taihe.com/songlist
    }
}
