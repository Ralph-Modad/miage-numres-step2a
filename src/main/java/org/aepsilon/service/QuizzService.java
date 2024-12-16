package org.aepsilon.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aepsilon.dto.ProposalDto;
import org.aepsilon.dto.QuestionDto;
import org.aepsilon.orm.Proposal;
import org.aepsilon.orm.Question;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class QuizzService {

       public List<QuestionDto> listAllQuestions() {
        return Question.listAll().stream()
            .map(q -> new QuestionDto((Question) q))
            .collect(Collectors.toList());
    }

        public Long evaluateProposals(List<ProposalDto> proposalsInput) {
        List<Long> proposalIds = proposalsInput.stream()
            .map(p -> p.id)
            .collect(Collectors.toList());
        return Proposal.count("id in ?1 and correct = true", proposalIds);
    }
    
    public List<ProposalDto> listProposals(Long questionId) {
        return Proposal.list("question.id", questionId).stream()
                .map(p -> new ProposalDto((Proposal) p))
                .collect(Collectors.toList());
    }

}
