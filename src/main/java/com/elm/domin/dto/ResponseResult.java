package com.elm.domin.dto;





import com.elm.domin.enums.AppHttpCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用的结果返回类
 * @param <T>
 */
@Data
public class ResponseResult<T> implements Serializable {

    private Integer code;

    private String Message;

    private T data;

    public ResponseResult() {
        this.code = 200;
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.Message = msg;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.Message = msg;
    }

    public static ResponseResult errorResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.error(code, msg);
    }

    public static ResponseResult okResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.ok(code, null, msg);
    }

    public static ResponseResult okResult(Object data) {
        ResponseResult result = setAppHttpCodeEnum(AppHttpCodeEnum.SUCCESS, AppHttpCodeEnum.SUCCESS.getErrorMessage());
        if(data!=null) {
            result.setData(data);
        }
        return result;
    }

    public static ResponseResult errorResult(AppHttpCodeEnum enums){
        return setAppHttpCodeEnum(enums,enums.getErrorMessage());
    }

    public static ResponseResult errorResult(AppHttpCodeEnum enums, String errorMessage){
        return setAppHttpCodeEnum(enums,errorMessage);
    }

    public static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums){
        return okResult(enums.getCode(),enums.getErrorMessage());
    }

    private static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums, String errorMessage){
        return okResult(enums.getCode(),errorMessage);
    }

    public ResponseResult<?> error(Integer code, String msg) {
        this.code = code;
        this.Message = msg;
        return this;
    }

    public ResponseResult<?> ok(Integer code, T data) {
        this.code = code;
        this.data = data;
        return this;
    }

    public ResponseResult<?> ok(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.Message = msg;
        return this;
    }

    public ResponseResult<?> ok(T data) {
        this.data = data;
        return this;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.Message = message;
    }

    public void setData(T data) {
        this.data = data;
    }




    public static void main(String[] args) {
        //前置
        AppHttpCodeEnum success = AppHttpCodeEnum.SUCCESS;
        System.out.println(success.getCode());
        System.out.println(success.getErrorMessage());

        //查询一个对象
//        Map map = new HashMap();
//        map.put("name","zhangsan");
//        map.put("age",18);
//        ResponseResult result = ResponseResult.okResult(map);
//        System.out.println(JSON.toJSONString(result));


        //新增，修改，删除  在项目中统一返回成功即可
       /* ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.SUCCESS);
        System.out.println(JSON.toJSONString(result));


        //根据不用的业务返回不同的提示信息  比如：当前操作需要登录、参数错误
        /*ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        System.out.println(JSON.toJSONString(result));*/

//        //查询分页信息
//        PageResponseResult responseResult = new PageResponseResult(1,5,50);
//        List list = new ArrayList();
//        list.add("itcast");
//        list.add("itheima");
//        responseResult.setData(list);
//        System.out.println(JSON.toJSONString(responseResult));

    }

}
