package my.boot.template.common.api;

/**
 * 通用返回对象
 */
public class CommonResult<T> {
    private long code;
    private String message;
    private T result;

    private boolean success;

    protected CommonResult() {
    }

    protected CommonResult(long code, String message, T result, boolean success) {
        this.code = code;
        this.message = message;
        this.result = result;
        this.success = success;
    }

    protected CommonResult(long code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    /**
     * 成功返回结果
     *
     * @param result 获取的数据
     */
    public static <T> CommonResult<T> success(T result) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), result, true);
    }

    /**
     * 成功返回结果
     *
     * @param result 获取的数据
     * @param  message 提示信息
     */
    public static <T> CommonResult<T> success(T result, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, result);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode,String message) {
        return new CommonResult<T>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> CommonResult<T> unauthorized(T result) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), result);
    }

    /**
     * 未授权返回结果
     */
    public static <T> CommonResult<T> forbidden(T result) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), result);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
