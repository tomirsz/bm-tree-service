package com.bonsaimanager.treeservice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "trees")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Tree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "latin_name")
    private String latinName;

    private LocalDate date;

    @OneToMany(mappedBy = "tree", cascade = CascadeType.REMOVE)
    private List<Irrigation> irrigations = new ArrayList<>();

    @OneToMany(mappedBy = "tree", cascade = CascadeType.REMOVE)
    private List<Fertilization> fertilizations = new ArrayList<>();

    @OneToMany(mappedBy = "tree", cascade = CascadeType.REMOVE)
    private List<Prune> prunings = new ArrayList<>();

    @OneToMany(mappedBy = "tree", cascade = CascadeType.REMOVE)
    private List<Repot> repottings = new ArrayList<>();

    @OneToMany(mappedBy = "tree", cascade = CascadeType.REMOVE)
    private List<Spraying> sprayings = new ArrayList<>();

    @JsonIgnore
    @Column(name = "user_id")
    private String userId;

}
