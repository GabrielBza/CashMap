package com.example.cashMap.jpaRepositories;

import com.example.cashMap.jpaModels.JpaCategory;
import com.example.cashMap.jpaRepositoriesDefault.JpaCategoryRepositoryDefault;
import com.example.cashMap.mappers.CategoryMapper;
import com.example.cashMap.models.Category;
import com.example.cashMap.repositories.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Repository
public class JpaCategoryRepository implements CategoryRepository {

    private final JpaCategoryRepositoryDefault categoryRepo;

    public JpaCategoryRepository(JpaCategoryRepositoryDefault categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category save(Category category) {
        notNull(category, "Category must not be null");
        JpaCategory saved = categoryRepo.save(CategoryMapper.toJpaCategory(category));
        return CategoryMapper.toCategory(saved);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        notNull(id, "id must not be null");
        return categoryRepo.findById(id).map(CategoryMapper::toCategory);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll().stream()
                .map(CategoryMapper::toCategory)
                .toList();
    }

    @Override
    public List<Category> searchByName(String namePart) {
        notNull(namePart, "namePart must not be null");

        return categoryRepo.findByNameContainingIgnoreCase(namePart).stream()
                .map(CategoryMapper::toCategory)
                .toList();
    }

    @Override
    public void deleteById(Integer id) {
        notNull(id, "id must not be null");
        categoryRepo.deleteById(id);
    }
}
