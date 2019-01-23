package com.pinyougou.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TbSpecificationOption  implements Serializable {
    private Long id;

    private String optionName;

    private Long specId;

    private Integer orders;

}