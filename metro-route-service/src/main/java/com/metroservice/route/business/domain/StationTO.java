package com.metroservice.route.business.domain;

import java.util.Date;
import lombok.Data;

//@Getter @Setter 
@Data
public class StationTO {
    private long   stationId           ;
    private String stationName         ;
    private Date   lastModifiedDate    ;
}
