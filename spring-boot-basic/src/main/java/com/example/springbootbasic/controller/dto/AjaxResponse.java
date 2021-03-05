package com.example.springbootbasic.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gin
 * @date 2021/3/5
 * @description AjaxResponse
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AjaxResponse {
    private Integer code;
    private String message;
    private Object data;

    public static AjaxResponse success(Object obj) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求成功");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
}
