package com.zhangrenhua.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResp implements Serializable {
	
	private static final long serialVersionUID = 7916960828081706276L;
	
	String id;
	
	String code;
	
	String name;
	
	String status;

}