package com.indusnet.cruduserdetails.model.common;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoggingResponseModel {
	private HttpStatus statusCode;
	private String message;
	private MessageTypeConst messageType;
}
