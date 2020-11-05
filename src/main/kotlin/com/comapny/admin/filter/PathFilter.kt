package com.comapny.admin.filter

import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

@Component
class PathFilter : BaseFilter() {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        var path = exchange.request.uri.path
        if(isBasicResources(path)){
            return chain.filter(exchange)
        }
        if(isNoPageRequest(path)){
            return chain.filter(exchange)
        }
        return chain.filter(exchange.mutate().request(exchange.request.mutate().path("/index.html").build()).build())
    }
}
