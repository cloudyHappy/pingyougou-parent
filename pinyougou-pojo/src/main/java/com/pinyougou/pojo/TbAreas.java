package com.pinyougou.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TbAreas implements Serializable {
    private Integer id;

    private String areaid;

    private String area;

    private String cityid;

}