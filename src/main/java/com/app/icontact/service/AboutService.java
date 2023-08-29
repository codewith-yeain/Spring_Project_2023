package com.app.icontact.service;

import com.app.icontact.DTO.IdeaDTO2;

import java.util.List;

public interface AboutService {
    //회사소개 배너
    public List<IdeaDTO2> getMostReadIdeas(Long ideaCategory);
}
