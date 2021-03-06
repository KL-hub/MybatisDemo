package com.example.entity;


import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private Long id;

    private String name;

    private Date age;

    private String sex;

    private static final long serialVersionUID = 1L;

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }
}