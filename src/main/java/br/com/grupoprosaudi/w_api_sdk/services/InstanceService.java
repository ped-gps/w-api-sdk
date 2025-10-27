
package br.com.grupoprosaudi.w_api_sdk.services;

import br.com.grupoprosaudi.w_api_sdk.dtos.responses.InstanceResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Serviço para gerenciamento de instâncias através da API W-API.
 * <p>
 * Fornece métodos para consulta e gerenciamento de instâncias
 * de forma síncrona ou assíncrona.
 * </p>
 * <p>
 * Este serviço utiliza o {@link WebClient} configurado para fazer requisições
 * aos endpoints da API relacionados a instâncias.
 * </p>
 */
@Service("WAPISDKInstanceService")
public class InstanceService {

    private final WebClient webClient;

    /**
     * Construtor para injeção do WebClient configurado.
     *
     * @param webClient Cliente HTTP configurado para comunicação com a W-API
     */
    public InstanceService(@Qualifier("WAPISDKWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Busca uma instância pelo seu ID de forma síncrona.
     * <p>
     * Este método bloqueia a thread atual até que a resposta seja recebida.
     * </p>
     *
     * @param instanceId ID da instância a ser consultada
     * @return Objeto contendo os dados da instância
     */
    public InstanceResponse findById(String accessToken,
                                     String instanceId) {
        return findByIdAsync(accessToken, instanceId).block();
    }

    /**
     * Busca uma instância pelo seu ID de forma assíncrona.
     * <p>
     * Este método retorna um {@link Mono} que será completado quando
     * a resposta da API for recebida, sem bloquear a thread atual.
     * </p>
     *
     * @param instanceId ID da instância a ser consultada
     * @return Mono contendo o objeto com os dados da instância
     */
    public Mono<InstanceResponse> findByIdAsync(String accessToken,
                                                String instanceId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/instance/fetch-instance")
                        .queryParam("instanceId", instanceId)
                        .build())
                .headers(httpHeaders ->
                        httpHeaders.add("Authorization", "Bearer " + accessToken)
                )
                .retrieve()
                .bodyToMono(InstanceResponse.class);
    }
}