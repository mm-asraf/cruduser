package com.indusnet.cruduserdetails.model.common;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponseModel {
	private String message;
	private HttpStatus statusCode;
	private Integer messageTypeId;
}
