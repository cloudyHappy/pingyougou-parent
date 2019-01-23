package com.pinyougou.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TbItemCat  implements Serializable {
    private Long id;

    private Long parentId;

    private String name;

    private Long typeId;

}