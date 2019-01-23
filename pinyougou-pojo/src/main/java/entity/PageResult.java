package entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果类
 */
@Getter
@Setter
public class PageResult implements Serializable {
    private long total;//总记录数

    private List rows;//当前页记录

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }
}
