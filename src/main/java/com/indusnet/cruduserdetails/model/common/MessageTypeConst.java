package com.indusnet.cruduserdetails.model.common;

import lombok.Getter;

@Getter
public enum MessageTypeConst {
	ERROR(0),
	SUCCESS(1);	
	private Integer message;
	private MessageTypeConst(Integer messageType) {
		this.message = messageType;
	}	
}
