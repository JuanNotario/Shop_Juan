package com.corunet.pruebajuan.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface BodyRsp extends Serializable, ObjResp {
}
