package com.app.icontact.DAO;

import com.app.icontact.mapper.IdeaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class IdeaDAO {
    private final IdeaMapper ideaMapper;
}
