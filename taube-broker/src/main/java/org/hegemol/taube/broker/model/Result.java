package org.hegemol.taube.broker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一结果包装
 *
 * @author KevinClair
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 状态信息
     */
    private String message;

    /**
     * 结果
     */
    private T data;

    /**
     * 成功
     *
     * @param data 返回数据
     * @return 成功的返回数据
     * @param <T> data的泛型类型
     */
    public static <T> Result success(T data){
        return new Result(200, "success", data);
    }
}
