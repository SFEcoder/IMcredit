package com.example.common.config.handler;


import com.alibaba.fastjson.JSONObject;
import com.example.common.constant.ApiMsg;
import com.example.common.vo.ResponseVO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 *
 */
@RestControllerAdvice
public class CustomGlobalExceptionHandler {

    /**
     * 处理参数校验异常
     *
     * @param ex      ex
     * @param headers headers
     * @param status  status
     * @return ResponseEntity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> validationBodyException(MethodArgumentNotValidException ex,
                                                          HttpHeaders headers,
                                                          HttpStatus status) {
        // 获取所有异常信息
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        ResponseVO<List<String>> responseVO = new ResponseVO<>(errors, ApiMsg.KEY_SERVICE, ApiMsg.ERROR);
        return new ResponseEntity<>(responseVO, headers, status);
    }

    /**
     * 参数类型转换错误
     *
     * @param exception 错误
     * @return 错误信息 
     */
    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<ResponseVO<String>> parameterTypeException(HttpMessageConversionException exception) {
        ResponseVO<String> responseVO = new ResponseVO<>(exception.getMessage(), ApiMsg.KEY_PARAM_VALIDATE, ApiMsg.ERROR);
        return new ResponseEntity<>(responseVO, HttpStatus.OK);
    }

    /**
     * 处理CommonException
     *
     * @param e e
     * @return ResponseEntity
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseVO<String>> handleCommonException(Exception e) {
        ResponseVO<String> responseVO = new ResponseVO<>(e.getMessage(), ApiMsg.KEY_SERVICE, ApiMsg.ERROR);
        return new ResponseEntity<>(responseVO, HttpStatus.OK);
    }

    /**
     * 捕获@Validate校验抛出的异常
     *
     * @param e e
     * @return ResponseEntity
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<Object> validExceptionHandler(BindException e) {
        Exception ex = parseBindingResult(e.getBindingResult());
        ResponseVO<String> responseVO = new ResponseVO<>(ex.getMessage(), ApiMsg.KEY_PARAM_VALIDATE, ApiMsg.ERROR);
        return new ResponseEntity<>(responseVO, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseVO<String>> handleException(Exception e) {
        ResponseVO<String> responseVO = new ResponseVO<>(e.getMessage(), ApiMsg.KEY_ERROR, ApiMsg.ERROR);
        return new ResponseEntity<>(responseVO, HttpStatus.OK);
    }

    /**
     * 提取Validator产生的异常错误
     *
     * @param bindingResult bindingResult
     * @return Exception
     */
    private Exception parseBindingResult(BindingResult bindingResult) {
        Map<String, String> errorMsgs = new HashMap<>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            errorMsgs.put(error.getField(), error.getDefaultMessage());
        }
        if (errorMsgs.isEmpty()) {
            return new RuntimeException(ApiMsg.KEY_PARAM_VALIDATE + "");
        } else {
            return new RuntimeException(JSONObject.toJSONString(errorMsgs));
        }
    }
}
