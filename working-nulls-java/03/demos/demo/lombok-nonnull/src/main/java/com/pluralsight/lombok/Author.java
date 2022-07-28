package com.pluralsight.lombok;

import lombok.Data;
import lombok.NonNull;

@Data
public class Author {
    @NonNull
    private String name;

    @NonNull
    private String email;

    private String company;
}
