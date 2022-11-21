package org.example;

import javax.persistence.*;

@Entity
@Table(name = "mygarage")
public class Car {
    @Column
    private String name;
    @Column
    private int maxSpeed;
    @Id
    @GeneratedValue()
    @Column
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name ;
    }
}
