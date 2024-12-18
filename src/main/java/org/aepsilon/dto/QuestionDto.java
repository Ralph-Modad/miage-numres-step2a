package org.aepsilon.dto;

import org.aepsilon.orm.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionDto {
    public Long id;
    public String label;
    
    public CategoryDto category;

    public QuestionDto(){}

    public QuestionDto(Question q) {
        this.id = q.id;
        this.label = q.label;
        this.category = new CategoryDto(q.category);
    }
}
