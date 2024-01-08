package com.sample.sample.common.config.websocket

import com.sample.sample.location.adapter.`in`.websocket.GetFriendLocationHandler
import com.sample.sample.location.adapter.`in`.websocket.UpdateLocationHandler
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class WebSocketConfig(
    private val updateLocationHandler: UpdateLocationHandler,
    private val getFriendLocationHandler: GetFriendLocationHandler,
    private val handshakeWithAuthInterceptor: HandshakeWithAuthInterceptor,
) : WebSocketConfigurer {
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.apply {
            addHandler(updateLocationHandler, "/update-location")
                .setAllowedOrigins("*")
                .addInterceptors(handshakeWithAuthInterceptor)
            addHandler(getFriendLocationHandler, "/request-location")
                .setAllowedOrigins("*")
                .addInterceptors(handshakeWithAuthInterceptor)
        }
    }
}
