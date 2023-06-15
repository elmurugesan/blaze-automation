package com.frm.testdata;

import com.creditdatamw.zerocell.annotation.Column;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Getter
@ToString
@NoArgsConstructor
public class NewMessage {
	
	@Column(name = "Email", index = 1)
	private String email;
	
	@Column(name = "Name", index = 2)
	private String name;
	
	@Column(name = "Message", index = 3)
	private String message;
}
