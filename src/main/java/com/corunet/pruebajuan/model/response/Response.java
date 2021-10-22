package com.corunet.pruebajuan.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(value = {"header", "response"})
public class Response implements Serializable {
    private HeaderRsp headerRsp;
    private BodyRsp bodyRsp;
}
