package com.example.mask;

import com.example.mask.enums.MaskingStyle;
import lombok.Data;
import lombok.ToString;

@Data
public class User {

    private String name;
    @Mask(style = MaskingStyle.PARTIAL)
    @ToString.Exclude
    private String ssn;
    @Mask
    @ToString.Exclude
    private String msisdn;
    private String password;
}
