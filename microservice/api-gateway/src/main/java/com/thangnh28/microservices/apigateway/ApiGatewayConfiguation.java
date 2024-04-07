package com.thangnh28.microservices.apigateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguation {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeader", "MyURI")
                                .addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80"))

 /* Đây là điều kiện định tuyến, chỉ định rằng bất kỳ yêu cầu nào có path bắt đầu bằng "/currency-exchange"
 sẽ được ánh xạ.*/
                .route(p -> p.path("/currency-exchange/**")
/* Đây là URI đích mà các yêu cầu sẽ được định tuyến đến nếu thỏa mãn điều kiện định tuyến.
Trong trường hợp này, nó sử dụng LoadBalancer (lb://) để định tuyến đến dịch vụ có tên là "currency-exchange"
trong Service Discovery.*/
                        .uri("lb://currency-exchange"))
                .route(p -> p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion-new/**")
                        .filters(f -> f.rewritePath(
                                "/currency-conversion-new/(?<segment>.*)",
                                "/currency-conversion-feign/${segment}"
                        ))
                        .uri("lb://currency-conversion"))
                .build();
    }
}
