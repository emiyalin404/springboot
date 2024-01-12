package net.javaguides.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "mealCategories")
public class MealCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEAL_CATEGORIES_ID")
    private Long mealCategoriesId;
    @Column(name = "MEAL_CATEGORIES_NAME")
    private String mealCategoriesName;
    @Column(name = "CAPTION")
    private String caption;

}
