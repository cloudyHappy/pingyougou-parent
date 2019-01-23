package entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 返回结果
 */
@Getter
@Setter
public class Result implements Serializable {
    private boolean success;//是否成功
    private String message;//返回的信息

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
