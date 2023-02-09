package org.yameida.worktool.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yameida.worktool.common.api.CommonResult;

import javax.servlet.http.HttpServletRequest;

/**
 * 群居异常处理
 *
 * @author genxm
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResult handle(Exception e, HttpServletRequest request) {
        e.printStackTrace();
        if (e instanceof HttpRequestMethodNotSupportedException) {
            String method = request.getMethod();
            return CommonResult.failed(String.format(
                    "请求方法错误，当前使用的是`%s`，请检查是否应为`%s`",
                    method, "GET".equals(method) ? "POST" : "GET"
            ));
        } else if (!"GET".equals(request.getMethod()) && (e instanceof HttpMediaTypeException || e instanceof HttpMessageConversionException)) {
            return CommonResult.failed("请求格式错误，请检查 Content-Type 以及 请求参数字段名/参数类型 是否正确");
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            return CommonResult.failed(exception.getBindingResult().getFieldError().getDefaultMessage());
        } else if (e instanceof IllegalArgumentException) {
            IllegalArgumentException exception = (IllegalArgumentException) e;
            return CommonResult.failed(exception.getMessage());
        } else if (e instanceof IllegalStateException) {
            IllegalStateException exception = (IllegalStateException) e;
            return CommonResult.failed(exception.getMessage());
        }

        if (StringUtils.isEmpty(e.getMessage())) {
            return CommonResult.failed("服务器异常");
        } else {
            return CommonResult.failed(e.getMessage());
        }
    }
}

