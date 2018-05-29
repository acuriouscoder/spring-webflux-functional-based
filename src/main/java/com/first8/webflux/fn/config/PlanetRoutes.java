package com.first8.webflux.fn.config;

import com.first8.webflux.fn.handlers.PlanetHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@AllArgsConstructor
public class PlanetRoutes {

	private PlanetHandler planetHandler;

	@Bean
	public RouterFunction<?> planetRouter() {
		return route(GET("/planets")
				.or(GET("/planets/{substring}")), planetHandler::getPlanets);
	}
}