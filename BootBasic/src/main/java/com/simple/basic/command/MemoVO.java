package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemoVO {

    private Long mno;
    @Size(min=5)
    private String memo;
    @Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}")
    private String phone;
    @Pattern(regexp = "[0-9]{4}")
    private String pw;
    private String secret = "n";
}
