package com.example.notion_ex.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int age; //based on age, show ads
    //further details: recommended -> recommend books based on the names of authors given
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;
}
