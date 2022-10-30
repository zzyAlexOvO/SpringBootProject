package com.utakata.VO;

import lombok.Data;

/**
 * http请求返回最外层的对象
 * Created by Utakata
 * 2022/10/18 17:38
 */
@Data
public class ResultVo<T> {

    /**错误代码 */
    private Integer code;
    /**信息 */
    private String msg;
    /**返回内容 */
    private T data;


}
