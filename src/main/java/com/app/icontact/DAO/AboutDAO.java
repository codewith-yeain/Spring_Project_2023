package com.app.icontact.DAO;

import com.app.icontact.mapper.AboutMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AboutDAO {
    private final AboutMapper aboutMapper;
}
