package com.app.icontact.service;

import com.app.icontact.DAO.IdeaDAO;
import com.app.icontact.DAO.IdeaFileDAO;
import com.app.icontact.DAO.SubCategoryDAO;
import com.app.icontact.DAO.UserDAO;
import com.app.icontact.DTO.*;
import com.app.icontact.type.FileType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class IdeaServiceImpl implements IdeaService {
    private final IdeaDAO ideaDAO;
    private final IdeaFileDAO ideaFileDAO;
    private final UserDAO userDAO;
    private final SubCategoryDAO subCategoryDAO;

    @Override
    public List<IdeaDTO4> getMostReadIdeas(Long ideaCategory) {
        List<IdeaDTO4> mostReadIdeas = ideaDAO.findMostReadIdeasByIdeaCategory(ideaCategory);
        mostReadIdeas.forEach(mostReadIdea -> mostReadIdea.setFiles(ideaFileDAO.findAll(mostReadIdea.getId())));
        mostReadIdeas.forEach(mostReadIdea -> mostReadIdea.setIdeaScarpCount(ideaDAO.findCountOfScraps(mostReadIdea.getId())));
        mostReadIdeas.forEach(mostReadIdea -> mostReadIdea.setIdeaCount(ideaDAO.findFinishUserCountOfIdea(mostReadIdea.getId())));

        return mostReadIdeas;
    }

    @Override
    public List<IdeaDTO4> getPremiumIdeas(Long ideaCategory) {
        List<IdeaDTO4> premiumIdeas = ideaDAO.findPremiumIdeaByIdeaCategory(ideaCategory);
        premiumIdeas.forEach(premiumIdea -> premiumIdea.setFiles(ideaFileDAO.findAll(premiumIdea.getId())));
        premiumIdeas.forEach(premiumIdea -> premiumIdea.setIdeaScarpCount(ideaDAO.findCountOfScraps(premiumIdea.getId())));
        premiumIdeas.forEach(premiumIdea -> premiumIdea.setIdeaCount(ideaDAO.findFinishUserCountOfIdea(premiumIdea.getId())));

        return premiumIdeas;
    }

    @Override
    public List<IdeaDTO4> getTopScrapIdeas() {
        List<IdeaDTO4> topScrapIdeas = ideaDAO.findIdeaByScrap();
        topScrapIdeas.forEach(topScrapIdea -> topScrapIdea.setFiles(ideaFileDAO.findAll(topScrapIdea.getId())));
        topScrapIdeas.forEach(topScrapIdea -> topScrapIdea.setIdeaScarpCount(ideaDAO.findCountOfScraps(topScrapIdea.getId())));
        topScrapIdeas.forEach(topScrapIdea -> topScrapIdea.setIdeaCount(ideaDAO.findFinishUserCountOfIdea(topScrapIdea.getId())));

        return topScrapIdeas;
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
        ideas.forEach(idea -> idea.setIdeaCount(ideaDAO.findFinishUserCountOfIdea(idea.getId())));
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

    @Override
    public Optional<IdeaDTO5> read(Long id) {
        final Optional<IdeaDTO5> foundIdea = ideaDAO.findById(id);
        if(foundIdea.isPresent()){
            foundIdea.get().setFiles(ideaFileDAO.findAll(foundIdea.get().getId()));
            foundIdea.get().setIdeaScarpCount(ideaDAO.findCountOfScraps(foundIdea.get().getId()));
            foundIdea.get().setIdeaCount(ideaDAO.findFinishUserCountOfIdea(foundIdea.get().getId()));
            foundIdea.get().setUserVO(userDAO.findById(foundIdea.get().getUserId()).get());
            foundIdea.get().setInterests(subCategoryDAO.findSubCategoryName(foundIdea.get().getUserId()));
            foundIdea.get().setIdeaCategoryNames(subCategoryDAO.findSubCategoryNameAndTopCategoryNameByIdeaId(foundIdea.get().getId()));
            foundIdea.get().setTotalIdeas(ideaDAO.getCountOfIdeasByUserId(foundIdea.get().getUserId()));

            List<IdeaDTO4> otherIdeas = ideaDAO.findIdeasByUserId(foundIdea.get().getUserId());
            otherIdeas.forEach(otherIdea -> otherIdea.setFiles(ideaFileDAO.findAll(otherIdea.getId())));
            otherIdeas.forEach(otherIdea -> otherIdea.setIdeaScarpCount(ideaDAO.findCountOfScraps(otherIdea.getId())));
            otherIdeas.forEach(otherIdea -> otherIdea.setIdeaCount(ideaDAO.findFinishUserCountOfIdea(otherIdea.getId())));
            foundIdea.get().setOtherIdeas(otherIdeas);
        }
        ideaDAO.updateReadCount(id);
        return foundIdea;
    }
}
