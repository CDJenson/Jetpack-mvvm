package com.jenson.common.http;

import android.net.ParseException;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.LogUtils;
import com.google.gson.JsonParseException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import java.io.IOException;
import java.net.ConnectException;

import retrofit2.HttpException;

/**
 * author: CDJenson
 * date: 2020/5/22 11:33
 * version: 1.0
 * description: One-sentence description
 */
public class ApiException extends Exception {

    private int code;
    private String message;

    public ApiException(Throwable throwable) {
        super(throwable);
        LogUtils.e(throwable);
        parseThrowable(throwable);
    }

    public int getCode() {
        return code;
    }

    @Nullable
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public void parseThrowable(Throwable e) {
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            code = httpException.code();
            switch (code) {
                case HTTP.ERROR_REQUEST_PARMS:
                    message = "参数错误";
                    break;
                case HTTP.UNAUTHORIZED:
                    message = "操作未授权";
                    break;
                case HTTP.FORBIDDEN:
                    message = "请求被拒绝";
                    break;
                case HTTP.NOT_FOUND:
                    message = "资源不存在";
                    break;
                case HTTP.REQUEST_TIMEOUT:
                    message = "请求服务器超时";
                    break;
                case HTTP.INTERNAL_SERVER_ERROR:
                    message = "服务器内部错误";
                    break;
                case HTTP.SERVICE_UNAVAILABLE:
                    message = "服务器不可用";
                    break;
                default:
                    message = "网络请求异常";
                    break;
            }
        } else if (e instanceof ConnectException) {
            code = INNER.NETWORD_ERROR;
            message = "服务器连接异常";
        } else if (e instanceof ConnectTimeoutException || e instanceof java.net.SocketTimeoutException) {
            code = INNER.TIMEOUT_ERROR;
            message = "服务器连接超时";
        } else if (e instanceof javax.net.ssl.SSLException) {
            code = INNER.SSL_ERROR;
            message = "证书校验失败";
        } else if (e instanceof java.net.UnknownHostException) {
            code = INNER.UNKNOWN_HOST;
            message = "主机地址未知";
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException
                || e instanceof IOException
                || e instanceof IllegalArgumentException) {
            code = INNER.PARSE_ERROR;
            message = "数据解析错误";
        } else {
            code = INNER.UNKNOWN;
            message = "未知异常";
        }
    }

    public static class HTTP {
        //参数错误
        public static final int ERROR_REQUEST_PARMS = 400;
        //操作未授权
        public static final int UNAUTHORIZED = 401;
        //请求被拒绝
        public static final int FORBIDDEN = 403;
        //资源不存在
        public static final int NOT_FOUND = 404;
        //请求服务器超时
        public static final int REQUEST_TIMEOUT = 408;
        //服务器内部错误
        public static final int INTERNAL_SERVER_ERROR = 500;
        //服务器不可用
        public static final int SERVICE_UNAVAILABLE = 503;
    }

    public static class INNER {
        //未知错误
        public static final int UNKNOWN = 1000;
        //网络异常
        public static final int NETWORD_ERROR = 1001;
        //网络连接超时
        public static final int TIMEOUT_ERROR = 1002;
        //证书出错
        public static final int SSL_ERROR = 1003;
        //主机地址未知
        public static final int UNKNOWN_HOST = 1004;
        //解析错误
        public static final int PARSE_ERROR = 1005;
    }
}
