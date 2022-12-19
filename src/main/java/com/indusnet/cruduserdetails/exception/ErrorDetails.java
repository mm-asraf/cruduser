package com.indusnet.cruduserdetails.exception;

import java.sql.Timestamp;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorDetails {
	private Timestamp timestamp;
	private Integer status;
	private Integer errorCode;
	private String errorMessage; 
	private Long traceID;
	private String errorDetails;
	private String path;    
}
