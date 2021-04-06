package kr.wonyoungpark.api.hall.domain;


import javax.persistence.Column;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component @Lazy
public class HallDto {
    private long hallNum;
    private String hallName;
    private String hallLocation;
    private String hallTime;
    private String hallClosed;
    private String hallPnumber;
    private String hallInfo;
    private String hallImage;
}
