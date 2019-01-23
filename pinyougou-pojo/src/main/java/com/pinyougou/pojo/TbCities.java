package com.pinyougou.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TbCities  implements Serializable {
    private Integer id;

    private String cityid;

    private String city;

    private String provinceid;
}