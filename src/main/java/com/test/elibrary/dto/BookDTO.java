package com.test.elibrary.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private String category;
    private int availableCopies;
}
