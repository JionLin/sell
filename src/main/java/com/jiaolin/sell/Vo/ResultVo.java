package com.jiaolin.sell.Vo;

import lombok.Data;

/*
最外层返回的参数
 */
@Data
public class ResultVo<T> {
    //错误码
    private Integer code;
    //信息
    private String message;
    //返回的参数
    private T data;

}
