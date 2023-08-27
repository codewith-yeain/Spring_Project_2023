package com.app.icontact.service;

import com.app.icontact.DTO.*;

import java.util.List;

public interface IdeaService {

    public List<IdeaDTO2> getMostReadIdeas(Long ideaCategory);

    public List<IdeaDTO2> getPremiumIdeas(Long ideaCategory);

    public List<IdeaDTO3> getTopScrapIdeas();

    public void write(IdeaDTO4 ideaDTO4);

    //    아이디어 목록
    public List<IdeaDTO4> getList(Pagination pagination, Search search);

    public int getTotal(Search search);

    public Long getScraps(Long ideaId);
}
