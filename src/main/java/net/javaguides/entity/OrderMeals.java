package net.javaguides.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "orderMeals")
public class OrderMeals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long orderId;
    @Column(name = "MEALS_ID")
    private Long mealsId;
    @Column(name = "COUNT")
    private String count;
    @Column(name = "SUBTOTAL")
    private String subtotal;
    @Column(name = "DISCOUNT")
    private String discount;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID",referencedColumnName = "ORDER_ID", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "MEALS_ID",referencedColumnName = "MEALS_ID", insertable = false, updatable = false)
    private Meals meals;
}
