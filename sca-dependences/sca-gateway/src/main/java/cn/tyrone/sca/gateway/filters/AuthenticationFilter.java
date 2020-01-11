package cn.tyrone.sca.gateway.filters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;


@Component
public class AuthenticationFilter implements GlobalFilter, Ordered {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String token = exchange.getRequest().getQueryParams().getFirst("token");

        if (token == null || "".equals(token)) {
            ServerHttpResponse response = exchange.getResponse();

            Map<String, Object> responseMap = new HashMap<String, Object>();
            responseMap.put("success", Boolean.FALSE);
            responseMap.put("message", "非法请求");

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                byte[] bytes = objectMapper.writeValueAsBytes(responseMap);
                DataBuffer dataBuffer = response.bufferFactory().wrap(bytes);

                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");

                return response.writeWith(Mono.just(dataBuffer));

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }

        return chain.filter(exchange);
    }

    public int getOrder() {
        return 0;
    }
}
