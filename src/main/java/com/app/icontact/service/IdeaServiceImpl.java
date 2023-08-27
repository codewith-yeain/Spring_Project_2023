package com.app.icontact.service;

import com.app.icontact.DAO.IdeaDAO;
import com.app.icontact.DAO.IdeaFileDAO;
import com.app.icontact.DTO.*;
import com.app.icontact.type.FileType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IdeaServiceImpl implements IdeaService {
    private final IdeaDAO ideaDAO;
    private final IdeaFileDAO ideaFileDAO;

    @Override
    public List<IdeaDTO2> getMostReadIdeas(Long ideaCategory) {
        return ideaDAO.findMostReadIdeasByIdeaCategory(ideaCategory);
    }

    @Override
    public List<IdeaDTO2> getPremiumIdeas(Long ideaCategory) {
        return ideaDAO.findPremiumIdeaByIdeaCategory(ideaCategory);
    }

    @Override
    public List<IdeaDTO3> getTopScrapIdeas() {
        return ideaDAO.findIdeaByScrap();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void write(IdeaDTO4 ideaDTO4) {
        ideaDAO.save(ideaDTO4);
//        log.info("서비스에서 확인1: {}", ideaDTO4.toString());
//        log.info("파일 들어왔니? {}", ideaDTO4.getFiles());

        for(int i=0; i<ideaDTO4.getFiles().size(); i++){
//            log.info("{}...........룰루", ideaDTO4.getId());
            ideaDTO4.getFiles().get(i).setIdeaId(ideaDTO4.getId());
//            log.info("응 들어왔다 !! {}", ideaDTO4.getFiles());
            if(ideaDTO4.getFiles().get(i).getIdeaFileType() == null){
                ideaDTO4.getFiles().get(i).setIdeaFileType(FileType.NON_REPRESENTATIVE.name());
            }
            ideaFileDAO.save(ideaDTO4.getFiles().get(i));
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<IdeaDTO4> getList(Pagination pagination, Search search) {
//        아이디어 전체 목록
        final List<IdeaDTO4> ideas = ideaDAO.findAll(search, pagination);
//        아이디어 하나씩 첨부파일 목록 담기
        ideas.forEach(idea -> idea.setFiles(ideaFileDAO.findAll(idea.getId())));
        ideas.forEach(idea -> idea.setIdeaScarpCount(ideaDAO.findCountOfScraps(idea.getId())));
        return ideas;
    }

    @Override
    public int getTotal(Search search) {
        return ideaDAO.findCountOfIdeas(search);
    }

    @Override
    public Long getScraps(Long ideaId) {
        return ideaDAO.findCountOfScraps(ideaId);
    }
}
