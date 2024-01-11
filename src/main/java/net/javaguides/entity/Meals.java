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
@Table(name = "meals")
public class Meals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEALS_ID")
    private Long mealsId;
    @Column(name = "MEAL_CATEGORIES_ID")
    private Long mealCategoriesId;
    @Column(name = "MEAL_NAME")
    private String mealName;
    @Column(name = "PRICE")
    private String price;

    @ManyToOne
    @JoinColumn(name = "MEAL_CATEGORIES_ID",referencedColumnName = "MEAL_CATEGORIES_ID", insertable = false, updatable = false)
    private MealCategories mealCategories;
}
