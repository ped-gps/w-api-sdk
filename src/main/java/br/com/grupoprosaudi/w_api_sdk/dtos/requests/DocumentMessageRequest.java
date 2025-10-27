package br.com.grupoprosaudi.w_api_sdk.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentMessageRequest extends MessageRequest implements Serializable {

    @NotEmpty(message = "Document can not be empty!")
    @JsonProperty("document")
    private String document;

    @NotEmpty(message = "Extension can not be empty!")
    @JsonProperty("extension")
    private String extension;
}