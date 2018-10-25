package com.metroservice.ui.business.domain;

import java.util.Date;
import lombok.Data;

@Data
public class UserRegTO {
    private long   userId           ;
    private String userName         ;
    private String email            ;
    private String gender           ;
    private String password         ;
    private Date   lastModifiedDate ;
}
