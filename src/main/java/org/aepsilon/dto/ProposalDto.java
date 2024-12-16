package org.aepsilon.dto;

import org.aepsilon.orm.Category;
import org.aepsilon.orm.Proposal;

import java.util.ArrayList;
import java.util.List;

public class ProposalDto {
    public Long id;
    public String label;

    public QuestionDto question;

    public ProposalDto(){}

    public ProposalDto(Proposal p) {
        this.id = p.id;
        this.label = p.label;
        this.question = new QuestionDto(p.question);
    }
}
