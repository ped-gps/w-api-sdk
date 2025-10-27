package br.com.grupoprosaudi.w_api_sdk.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse implements Serializable {

    @JsonProperty("instanceId")
    private String instanceId;

    @JsonProperty("messageId")
    private String messageId;

    @JsonProperty("insertedId")
    private String insertedId;
}
