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
public class VideoMessageRequest extends MessageRequest implements Serializable {

    @NotEmpty(message = "Video can not be empty!")
    @JsonProperty("video")
    private String video;
}