package com.jk.login.model;

import javax.persistence.*;

@Entity
@Table(name="role")
public class Role {
    @Id
    @Column(name = "r_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer r_id;
    @Column(name = "r_name")
    private String r_name;


    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "r_id=" + r_id +
                ", r_name='" + r_name + '\'' +
                '}';
    }
}
