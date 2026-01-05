package com.example.cashMap.mappers;

import com.example.cashMap.jpaModels.JpaCategory;
import com.example.cashMap.models.Category;

public class CategoryMapper {

    private CategoryMapper() {}

    public static Category toCategory(JpaCategory jpaCategory) {
        if (jpaCategory == null) return null;

        Category category = new Category();
        category.setId(jpaCategory.getId());
        category.setName(jpaCategory.getName());
        return category;
    }

    public static JpaCategory toJpaCategory(Category category) {
        if (category == null) return null;

        JpaCategory jpaCategory = new JpaCategory();
        jpaCategory.setId(category.getId());
        jpaCategory.setName(category.getName());
        return jpaCategory;
    }
}
