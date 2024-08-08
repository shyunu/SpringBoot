package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor //모든 멤버변수를 받는 생성자
@NoArgsConstructor //기본 생성자
@Data //getter, setter 생성, toString 오버라이딩 자듕
@Builder
public class TestVO {

    private int num;
    private String name;
    private int age;
    private String addr;
}
