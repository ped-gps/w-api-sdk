
package br.com.grupoprosaudi.w_api_sdk.services;

import br.com.grupoprosaudi.w_api_sdk.dtos.requests.AudioMessageRequest;
import br.com.grupoprosaudi.w_api_sdk.dtos.requests.DocumentMessageRequest;
import br.com.grupoprosaudi.w_api_sdk.dtos.requests.ImageMessageRequest;
import br.com.grupoprosaudi.w_api_sdk.dtos.requests.MessageRequest;
import br.com.grupoprosaudi.w_api_sdk.dtos.requests.TextMessageRequest;
import br.com.grupoprosaudi.w_api_sdk.dtos.requests.VideoMessageRequest;
import br.com.grupoprosaudi.w_api_sdk.dtos.responses.MessageResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;

/**
 * Serviço para envio de mensagens através da API W-API.
 * <p>
 * Fornece métodos para envio de diferentes tipos de mensagens (texto, imagem)
 * de forma síncrona ou assíncrona, com opções para customização de headers
 * e parâmetros de consulta.
 * </p>
 */
@Service("WAPISDKMessageService")
public class MessageService {

    private static final String AUDIO_MESSAGE_PATH = "/message/send-audio";
    private static final String DOCUMENT_MESSAGE_PATH = "/message/send-document";
    private static final String IMAGE_MESSAGE_PATH = "/message/send-image";
    private static final String TEXT_MESSAGE_PATH = "/message/send-text";
    private static final String VIDEO_MESSAGE_PATH = "/message/send-video";

    private final WebClient webClient;

    public MessageService(@Qualifier("WAPISDKWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    // --- Métodos para envio de mensagens de audio ---

    /**
     * Envia uma mensagem com áudio de forma síncrona.
     *
     * @param accessToken         Token de acesso para autenticação na API
     * @param instanceId          ID da instância para envio da mensagem
     * @param audioMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Resposta da API com os dados da mensagem enviada
     */
    public MessageResponse sendAudioMessage(String accessToken,
                                            String instanceId,
                                            @Valid AudioMessageRequest audioMessageRequest) {
        return sendMessageAsync(
                AUDIO_MESSAGE_PATH,
                createAuthorizationHeader(accessToken),
                createInstanceIdQueryParam(instanceId),
                audioMessageRequest
        ).block();
    }

    /**
     * Envia uma mensagem com áudio de forma assíncrona.
     *
     * @param accessToken         Token de acesso para autenticação na API
     * @param instanceId          ID da instância para envio da mensagem
     * @param audioMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Mono com a resposta da API contendo os dados da mensagem enviada
     */
    public Mono<MessageResponse> sendAudioMessageAsync(String accessToken,
                                                       String instanceId,
                                                       @Valid AudioMessageRequest audioMessageRequest) {
        return sendMessageAsync(
                AUDIO_MESSAGE_PATH,
                createAuthorizationHeader(accessToken),
                createInstanceIdQueryParam(instanceId),
                audioMessageRequest
        );
    }

    /**
     * Método avançado para enviar uma mensagem com áudio com cabeçalhos e parâmetros personalizados.
     *
     * @param headers             Cabeçalhos para a requisição
     * @param queryParams         Parâmetros de consulta
     * @param audioMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Resposta da API com os dados da mensagem enviada
     */
    public MessageResponse sendAudioMessage(Map<String, String> headers,
                                            Map<String, String> queryParams,
                                            @Valid AudioMessageRequest audioMessageRequest) {
        return sendMessageAsync(AUDIO_MESSAGE_PATH, headers, queryParams, audioMessageRequest).block();
    }

    /**
     * Versão assíncrona do método avançado para enviar uma mensagem com áudio.
     *
     * @param headers             Cabeçalhos para a requisição
     * @param queryParams         Parâmetros de consulta
     * @param audioMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Mono com a resposta da API contendo os dados da mensagem enviada
     */
    public Mono<MessageResponse> sendAudioMessageAsync(Map<String, String> headers,
                                                       Map<String, String> queryParams,
                                                       @Valid AudioMessageRequest audioMessageRequest) {
        return sendMessageAsync(AUDIO_MESSAGE_PATH, headers, queryParams, audioMessageRequest);
    }

    // --- Métodos para envio de mensagens de documento ---

    /**
     * Envia uma mensagem com documento de forma síncrona.
     *
     * @param accessToken            Token de acesso para autenticação na API
     * @param instanceId             ID da instância para envio da mensagem
     * @param documentMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Resposta da API com os dados da mensagem enviada
     */
    public MessageResponse sendDocumentMessage(String accessToken,
                                               String instanceId,
                                               @Valid DocumentMessageRequest documentMessageRequest) {
        return sendMessageAsync(
                DOCUMENT_MESSAGE_PATH,
                createAuthorizationHeader(accessToken),
                createInstanceIdQueryParam(instanceId),
                documentMessageRequest
        ).block();
    }

    /**
     * Envia uma mensagem com documento de forma assíncrona.
     *
     * @param accessToken            Token de acesso para autenticação na API
     * @param instanceId             ID da instância para envio da mensagem
     * @param documentMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Mono com a resposta da API contendo os dados da mensagem enviada
     */
    public Mono<MessageResponse> sendDocumentMessageAsync(String accessToken,
                                                          String instanceId,
                                                          @Valid DocumentMessageRequest documentMessageRequest) {
        return sendMessageAsync(
                DOCUMENT_MESSAGE_PATH,
                createAuthorizationHeader(accessToken),
                createInstanceIdQueryParam(instanceId),
                documentMessageRequest
        );
    }

    /**
     * Método avançado para enviar uma mensagem com documento com cabeçalhos e parâmetros personalizados.
     *
     * @param headers                Cabeçalhos para a requisição
     * @param queryParams            Parâmetros de consulta
     * @param documentMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Resposta da API com os dados da mensagem enviada
     */
    public MessageResponse sendDocumentMessage(Map<String, String> headers,
                                               Map<String, String> queryParams,
                                               @Valid DocumentMessageRequest documentMessageRequest) {
        return sendMessageAsync(DOCUMENT_MESSAGE_PATH, headers, queryParams, documentMessageRequest).block();
    }

    /**
     * Versão assíncrona do método avançado para enviar uma mensagem com documento.
     *
     * @param headers                Cabeçalhos para a requisição
     * @param queryParams            Parâmetros de consulta
     * @param documentMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Mono com a resposta da API contendo os dados da mensagem enviada
     */
    public Mono<MessageResponse> sendDocumentMessageAsync(Map<String, String> headers,
                                                          Map<String, String> queryParams,
                                                          @Valid DocumentMessageRequest documentMessageRequest) {
        return sendMessageAsync(DOCUMENT_MESSAGE_PATH, headers, queryParams, documentMessageRequest);
    }

    // --- Métodos para envio de mensagens de imagem ---

    /**
     * Envia uma mensagem com imagem de forma síncrona.
     *
     * @param accessToken         Token de acesso para autenticação na API
     * @param instanceId          ID da instância para envio da mensagem
     * @param imageMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Resposta da API com os dados da mensagem enviada
     */
    public MessageResponse sendImageMessage(String accessToken,
                                            String instanceId,
                                            @Valid ImageMessageRequest imageMessageRequest) {
        return sendMessageAsync(
                IMAGE_MESSAGE_PATH,
                createAuthorizationHeader(accessToken),
                createInstanceIdQueryParam(instanceId),
                imageMessageRequest
        ).block();
    }

    /**
     * Envia uma mensagem com imagem de forma assíncrona.
     *
     * @param accessToken         Token de acesso para autenticação na API
     * @param instanceId          ID da instância para envio da mensagem
     * @param imageMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Mono com a resposta da API contendo os dados da mensagem enviada
     */
    public Mono<MessageResponse> sendImageMessageAsync(String accessToken,
                                                       String instanceId,
                                                       @Valid ImageMessageRequest imageMessageRequest) {
        return sendMessageAsync(
                IMAGE_MESSAGE_PATH,
                createAuthorizationHeader(accessToken),
                createInstanceIdQueryParam(instanceId),
                imageMessageRequest
        );
    }

    /**
     * Método avançado para enviar uma mensagem com imagem com cabeçalhos e parâmetros personalizados.
     *
     * @param headers             Cabeçalhos para a requisição
     * @param queryParams         Parâmetros de consulta
     * @param imageMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Resposta da API com os dados da mensagem enviada
     */
    public MessageResponse sendImageMessage(Map<String, String> headers,
                                            Map<String, String> queryParams,
                                            @Valid ImageMessageRequest imageMessageRequest) {
        return sendMessageAsync(IMAGE_MESSAGE_PATH, headers, queryParams, imageMessageRequest).block();
    }

    /**
     * Versão assíncrona do método avançado para enviar uma mensagem com imagem.
     *
     * @param headers             Cabeçalhos para a requisição
     * @param queryParams         Parâmetros de consulta
     * @param imageMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Mono com a resposta da API contendo os dados da mensagem enviada
     */
    public Mono<MessageResponse> sendImageMessageAsync(Map<String, String> headers,
                                                       Map<String, String> queryParams,
                                                       @Valid ImageMessageRequest imageMessageRequest) {
        return sendMessageAsync(IMAGE_MESSAGE_PATH, headers, queryParams, imageMessageRequest);
    }

    // --- Métodos para envio de mensagens de texto ---

    /**
     * Envia uma mensagem de texto de forma síncrona.
     *
     * @param accessToken        Token de acesso para autenticação na API
     * @param instanceId         ID da instância para envio da mensagem
     * @param textMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Resposta da API com os dados da mensagem enviada
     */
    public MessageResponse sendTextMessage(String accessToken,
                                           String instanceId,
                                           @Valid TextMessageRequest textMessageRequest) {
        return sendMessageAsync(
                TEXT_MESSAGE_PATH,
                createAuthorizationHeader(accessToken),
                createInstanceIdQueryParam(instanceId),
                textMessageRequest
        ).block();
    }

    /**
     * Envia uma mensagem de texto de forma assíncrona.
     *
     * @param accessToken        Token de acesso para autenticação na API
     * @param instanceId         ID da instância para envio da mensagem
     * @param textMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Mono com a resposta da API contendo os dados da mensagem enviada
     */
    public Mono<MessageResponse> sendTextMessageAsync(String accessToken,
                                                      String instanceId,
                                                      @Valid TextMessageRequest textMessageRequest) {
        return sendMessageAsync(
                TEXT_MESSAGE_PATH,
                createAuthorizationHeader(accessToken),
                createInstanceIdQueryParam(instanceId),
                textMessageRequest
        );
    }

    /**
     * Método avançado para enviar uma mensagem de texto com cabeçalhos e parâmetros personalizados.
     *
     * @param headers            Cabeçalhos para a requisição
     * @param queryParams        Parâmetros de consulta
     * @param textMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Resposta da API com os dados da mensagem enviada
     */
    public MessageResponse sendTextMessage(Map<String, String> headers,
                                           Map<String, String> queryParams,
                                           @Valid TextMessageRequest textMessageRequest) {
        return sendMessageAsync(TEXT_MESSAGE_PATH, headers, queryParams, textMessageRequest).block();
    }

    /**
     * Versão assíncrona do método avançado para enviar uma mensagem de texto.
     *
     * @param headers            Cabeçalhos para a requisição
     * @param queryParams        Parâmetros de consulta
     * @param textMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Mono com a resposta da API contendo os dados da mensagem enviada
     */
    public Mono<MessageResponse> sendTextMessageAsync(Map<String, String> headers,
                                                      Map<String, String> queryParams,
                                                      @Valid TextMessageRequest textMessageRequest) {
        return sendMessageAsync(TEXT_MESSAGE_PATH, headers, queryParams, textMessageRequest);
    }

    // --- Métodos para envio de mensagens de vídeo ---

    /**
     * Envia uma mensagem com vídeo de forma síncrona.
     *
     * @param accessToken         Token de acesso para autenticação na API
     * @param instanceId          ID da instância para envio da mensagem
     * @param videoMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Resposta da API com os dados da mensagem enviada
     */
    public MessageResponse sendVideoMessage(String accessToken,
                                            String instanceId,
                                            @Valid VideoMessageRequest videoMessageRequest) {
        return sendMessageAsync(
                VIDEO_MESSAGE_PATH,
                createAuthorizationHeader(accessToken),
                createInstanceIdQueryParam(instanceId),
                videoMessageRequest
        ).block();
    }

    /**
     * Envia uma mensagem com vídeo de forma assíncrona.
     *
     * @param accessToken         Token de acesso para autenticação na API
     * @param instanceId          ID da instância para envio da mensagem
     * @param videoMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Mono com a resposta da API contendo os dados da mensagem enviada
     */
    public Mono<MessageResponse> sendVideoMessageAsync(String accessToken,
                                                       String instanceId,
                                                       @Valid VideoMessageRequest videoMessageRequest) {
        return sendMessageAsync(
                VIDEO_MESSAGE_PATH,
                createAuthorizationHeader(accessToken),
                createInstanceIdQueryParam(instanceId),
                videoMessageRequest
        );
    }

    /**
     * Método avançado para enviar uma mensagem com vídeo com cabeçalhos e parâmetros personalizados.
     *
     * @param headers             Cabeçalhos para a requisição
     * @param queryParams         Parâmetros de consulta
     * @param videoMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Resposta da API com os dados da mensagem enviada
     */
    public MessageResponse sendVideoMessage(Map<String, String> headers,
                                            Map<String, String> queryParams,
                                            @Valid VideoMessageRequest videoMessageRequest) {
        return sendMessageAsync(VIDEO_MESSAGE_PATH, headers, queryParams, videoMessageRequest).block();
    }

    /**
     * Versão assíncrona do método avançado para enviar uma mensagem com vídeo.
     *
     * @param headers             Cabeçalhos para a requisição
     * @param queryParams         Parâmetros de consulta
     * @param videoMessageRequest Objeto contendo os detalhes da mensagem a ser enviada
     * @return Mono com a resposta da API contendo os dados da mensagem enviada
     */
    public Mono<MessageResponse> sendVideoMessageAsync(Map<String, String> headers,
                                                       Map<String, String> queryParams,
                                                       @Valid VideoMessageRequest videoMessageRequest) {
        return sendMessageAsync(VIDEO_MESSAGE_PATH, headers, queryParams, videoMessageRequest);
    }

    // --- Métodos utilitários privados ---

    /**
     * Método base para envio de mensagens.
     * Centraliza a lógica de requisição HTTP usando o WebClient.
     *
     * @param path           Caminho da API para o tipo de mensagem
     * @param headers        Cabeçalhos da requisição
     * @param queryParams    Parâmetros de consulta
     * @param messageRequest Objeto da requisição
     * @return Mono com a resposta da API
     */
    private Mono<MessageResponse> sendMessageAsync(String path,
                                                   Map<String, String> headers,
                                                   Map<String, String> queryParams,
                                                   MessageRequest messageRequest) {
        return webClient.post()
                .uri(builder -> {
                    builder.path(path);

                    if (queryParams != null) {
                        queryParams.forEach(builder::queryParam);
                    }

                    return builder.build();
                })
                .headers(httpHeaders -> {
                    if (headers != null) {
                        headers.forEach(httpHeaders::add);
                    }
                })
                .bodyValue(messageRequest)
                .retrieve()
                .bodyToMono(MessageResponse.class);
    }

    /**
     * Cria um mapa com o header de autorização.
     *
     * @param accessToken Token de acesso
     * @return Mapa contendo o header de autorização
     */
    private Map<String, String> createAuthorizationHeader(String accessToken) {
        return Collections.singletonMap(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
    }

    /**
     * Cria um mapa com o parâmetro de consulta instanceId.
     *
     * @param instanceId ID da instância
     * @return Mapa contendo o parâmetro instanceId
     */
    private Map<String, String> createInstanceIdQueryParam(String instanceId) {
        return Collections.singletonMap("instanceId", instanceId);
    }
}