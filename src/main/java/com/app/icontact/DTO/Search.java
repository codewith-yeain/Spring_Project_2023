package com.app.icontact.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Search {
//    String type;
//    String keyword;
    Long ideaCategory;
    Long ideaPrice;
    Long ideaMax;
    String order;

//    public String[] getTypes(){
//        return type.split("");
//    }
}
