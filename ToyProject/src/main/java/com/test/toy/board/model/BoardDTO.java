package com.test.toy.board.model;

import lombok.Data;

@Data
public class BoardDTO {

	private String seq;
	private String subject;
	private String content;
	private String regdate;
	private int readcount; //산술 연산을 위해 integer로 선언
	private String id;
	
	private String name;
	private int isnew;
	//DTO = table이 아니다. table에 없는 데이터를 넣을 변수를 생성할 수 있다.
	//단 board와 관계가 있는 것이어야 한다. (터무니 없는 데이터는 안 된다.)
	
}
