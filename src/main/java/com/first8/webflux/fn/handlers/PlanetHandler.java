package com.first8.webflux.fn.handlers;

import com.first8.webflux.fn.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@AllArgsConstructor
public class PlanetHandler {

	private PlanetRepository planetRepository;

	public Mono<ServerResponse> getPlanets(ServerRequest request ) {
		String substring = request.pathVariables().getOrDefault("substring", "").toLowerCase();
		return ok().body(planetRepository.getPlanets()
				.filter( p -> p.toLowerCase().contains(substring)).map( p -> p + "\n"), String.class);
	}
}
