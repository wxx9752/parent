package com.jk.login.model;

import javax.persistence.*;

@Entity
@Table(name = "role_power")
public class Role_Power {
    @Id
    @Column(name = "rp_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rp_id;
    @Column
    private Integer r_id;
    @Column
    private Integer p_id;

    public Integer getRp_id() {
        return rp_id;
    }

    public void setRp_id(Integer rp_id) {
        this.rp_id = rp_id;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    @Override
    public String toString() {
        return "User_Role{" +
                "rp_id=" + rp_id +
                ", r_id=" + r_id +
                ", p_id=" + p_id +
                '}';
    }
}
