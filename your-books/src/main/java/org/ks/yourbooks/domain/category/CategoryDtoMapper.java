package org.ks.yourbooks.domain.category;

import org.ks.yourbooks.domain.category.dto.CategoryDto;

public class CategoryDtoMapper {
    static CategoryDto map(Category category){
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }
}
