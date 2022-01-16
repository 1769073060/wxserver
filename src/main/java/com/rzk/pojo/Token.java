package com.rzk.pojo;

import lombok.Data;

@Data
public class Token {
    private String accessToken;
    private String  expiresIn;
}
