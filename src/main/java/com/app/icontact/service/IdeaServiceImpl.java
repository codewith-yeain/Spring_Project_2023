package com.app.icontact.service;

import com.app.icontact.DAO.IdeaDAO;
import com.app.icontact.DAO.IdeaFileDAO;
import com.app.icontact.DTO.IdeaDTO2;
import com.app.icontact.DTO.IdeaDTO3;
import com.app.icontact.DTO.IdeaDTO4;
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
        log.info("서비스에서 확인1: {}", ideaDTO4.toString());
        log.info("파일 들어왔니? {}", ideaDTO4.getFiles());

        for(int i=0; i<ideaDTO4.getFiles().size(); i++){
            log.info("{}...........룰루", ideaDTO4.getId());
            ideaDTO4.getFiles().get(i).setIdeaId(ideaDTO4.getId());
            log.info("응 들어왔다 !! {}", ideaDTO4.getFiles());
            if(ideaDTO4.getFiles().get(i).getIdeaFileType() == null){
                ideaDTO4.getFiles().get(i).setIdeaFileType(FileType.NON_REPRESENTATIVE.name());
            }
            ideaFileDAO.save(ideaDTO4.getFiles().get(i));
        }

    }
}
