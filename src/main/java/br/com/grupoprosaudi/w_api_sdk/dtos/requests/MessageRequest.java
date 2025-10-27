package br.com.grupoprosaudi.w_api_sdk.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public abstract class MessageRequest implements Serializable {

    @Pattern(regexp = "^[1-9]\\d{1,2}\\d{2}\\d{8,9}$", message = "Phone must be in format: country code + area code + number (e.g. 5511999999999)")
    @NotEmpty(message = "Phone can not be empty!")
    @JsonProperty("phone")
    private String phone;

    @JsonProperty("delayMessage")
    private Integer delayMessage;
}
