package org.sojuton.paper.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaperDto {
    private Integer paperSeq;
    private String title;
    private Integer createUserSeq;
    private String paperText;
}
