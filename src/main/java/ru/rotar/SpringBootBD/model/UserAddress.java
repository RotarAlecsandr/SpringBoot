package ru.rotar.SpringBootBD.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_address")
public class UserAddress  {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name="city")
    private String city;

    @Column(name= "street")
    private String street;

    @Column(name="house")
    private int house;

    @OneToOne(mappedBy = "userAddress", orphanRemoval = true)
    private User user;
}
