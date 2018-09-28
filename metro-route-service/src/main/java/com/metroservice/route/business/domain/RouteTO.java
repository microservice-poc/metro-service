package com.metroservice.route.business.domain;

import java.util.Date;
import lombok.Data;

//@Getter @Setter 
@Data
public class RouteTO {
    private long   routeId             ;
    private String routeNumber         ;
    private long   startingStationId   ;
    private long   endStationId        ;
    private Date   lastModifiedDate    ;
}
