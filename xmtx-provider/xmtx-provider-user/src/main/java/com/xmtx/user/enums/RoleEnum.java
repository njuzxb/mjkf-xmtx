package com.xmtx.user.enums;

import lombok.Getter;


@Getter
public enum RoleEnum {
	BUYER(1, "用户"),
	SELLER(2, "企业"),
	;

	private Integer code;

	private String message;

	RoleEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
