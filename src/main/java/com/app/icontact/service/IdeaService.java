package com.app.icontact.service;

import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.DTO.IdeaDTO3;

import java.util.List;

public interface IdeaService {

    public List<IdeaDTO2> getMostReadIdeas(Long ideaCategory);

    public List<IdeaDTO2> getPremiumIdeas(Long ideaCategory);

    public List<IdeaDTO3> getTopScrapIdeas();
}
