package com.zlx.reverce.domain;


import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "r_order")
public class ReserveOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String reserve_phone;

    @Column
    private String address;

    @Column
    private String join_number;

    @Column
    private String reserve_type;

    @Column
    private Long start_date;

    @Column
    private Long end_date;


    @Column
    private String budget;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJoin_number() {
        return join_number;
    }

    public void setJoin_number(String join_number) {
        this.join_number = join_number;
    }

    public String getReserve_type() {
        return reserve_type;
    }

    public void setReserve_type(String reserve_type) {
        this.reserve_type = reserve_type;
    }

    public Long getStart_date() {
        return start_date;
    }

    public void setStart_date(Long start_date) {
        this.start_date = start_date;
    }

    public Long getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Long end_date) {
        this.end_date = end_date;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getReserve_phone() {
        return reserve_phone;
    }

    public void setReserve_phone(String reserve_phone) {
        this.reserve_phone = reserve_phone;
    }
}
