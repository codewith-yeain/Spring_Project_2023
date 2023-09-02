package com.app.icontact.service;

import com.app.icontact.DTO.*;

import java.util.List;
import java.util.Optional;

public interface IdeaService {

    public List<IdeaDTO4> getMostReadIdeas(Long ideaCategory);

    public List<IdeaDTO4> getPremiumIdeas(Long ideaCategory);

    public List<IdeaDTO4> getTopScrapIdeas();

    public void write(IdeaDTO4 ideaDTO4);

    //    아이디어 목록
    public List<IdeaDTO4> getList(Pagination pagination, Search search);

    public int getTotal(Search search);

    public Long getScraps(Long ideaId);

    public Optional<IdeaDTO5> read(Long id);

    public List<IdeaDTO4> findIdea(String keyword);
}
