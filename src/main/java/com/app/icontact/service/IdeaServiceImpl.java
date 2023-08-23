package com.app.icontact.service;

import com.app.icontact.DAO.IdeaDAO;
import com.app.icontact.DTO.IdeaDTO2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IdeaServiceImpl implements IdeaService {
    private final IdeaDAO ideaDAO;

    @Override
    public List<IdeaDTO2> getMostReadIdeas(Long ideaCategory) {
        return ideaDAO.findMostReadIdeasByIdeaCategory(ideaCategory);
    }

    @Override
    public List<IdeaDTO2> getPremiumIdeas(Long ideaCategory) {
        return ideaDAO.findPremiumIdeaByIdeaCategory(ideaCategory);
    }
}
