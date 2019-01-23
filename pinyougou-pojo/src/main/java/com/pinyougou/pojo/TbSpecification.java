package com.pinyougou.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TbSpecification  implements Serializable {
    private Long id;

    private String specName;

}