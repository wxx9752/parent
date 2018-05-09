package com.jk.login.model;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class User_Role {
    @Id
    @Column(name = "ur_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer ur_id;
    @Column
    private Integer u_id;
    @Column
    private Integer r_id;

    public Integer getUr_id() {
        return ur_id;
    }

    public void setUr_id(Integer ur_id) {
        this.ur_id = ur_id;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    @Override
    public String toString() {
        return "User_Role{" +
                "ur_id=" + ur_id +
                ", u_id=" + u_id +
                ", r_id=" + r_id +
                '}';
    }
}
