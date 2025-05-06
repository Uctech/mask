package com.example.mask;

import lombok.Data;
import lombok.ToString;

@Data
public class User {

    private String name;
    @Mask(partial = true)
    @ToString.Exclude
    private String ssn;
    @Mask
    @ToString.Exclude
    private String msisdn;
    private String password;
}
