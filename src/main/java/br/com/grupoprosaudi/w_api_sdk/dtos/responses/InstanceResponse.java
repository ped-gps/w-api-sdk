
package br.com.grupoprosaudi.w_api_sdk.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Objeto de resposta para informações de uma instância da W-API.
 * <p>
 * Contém detalhes sobre o estado, configuração e estatísticas de uma instância.
 * </p>
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstanceResponse implements Serializable {

    @JsonProperty("instanceId")
    private String instanceId;

    @JsonProperty("instanceName")
    private String instanceName;

    @JsonProperty("token")
    private String token;

    @JsonProperty("connected")
    private Boolean connected;

    @JsonProperty("connectedPhone")
    private String connectedPhone;

    @JsonProperty("contacts")
    private Long contacts;

    @JsonProperty("chats")
    private Long chats;

    @JsonProperty("messagesSent")
    private Long messagesSent;

    @JsonProperty("messagesReceived")
    private Long messagesReceived;

    @JsonProperty("webhookConnectedUrl")
    private String webhookConnectedUrl;

    @JsonProperty("webhookDeliveryUrl")
    private String webhookDeliveryUrl;

    @JsonProperty("webhookDisconnectedUrl")
    private String webhookDisconnectedUrl;

    @JsonProperty("webhookStatusUrl")
    private String webhookStatusUrl;

    @JsonProperty("webhookPresenceUrl")
    private String webhookPresenceUrl;

    @JsonProperty("webhookReceivedUrl")
    private String webhookReceivedUrl;

    @JsonProperty("automaticReading")
    private Boolean automaticReading;

    @JsonProperty("rejectCalls")
    private Boolean rejectCalls;

    @JsonProperty("callMessage")
    private String callMessage;

    @JsonProperty("created")
    private Long created;

    @JsonProperty("isTrial")
    private Boolean isTrial;

    @JsonProperty("paymentStatus")
    private String paymentStatus;

    @JsonProperty("expires")
    private Long expires;
}