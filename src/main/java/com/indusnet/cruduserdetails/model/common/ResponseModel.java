package com.indusnet.cruduserdetails.model.common;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * this class contains fields which is used to response success message
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponseModel {
	private String message;
	private HttpStatus statusCode;
	private Integer messageTypeId;
}
