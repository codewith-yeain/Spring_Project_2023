package com.app.icontact.DAO;

import com.app.icontact.mapper.CommunityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CommunityDAO {
    private final CommunityMapper communityMapper;
}
