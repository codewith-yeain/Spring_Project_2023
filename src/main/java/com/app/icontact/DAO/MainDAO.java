package com.app.icontact.DAO;

import com.app.icontact.mapper.MainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MainDAO {
    private final MainMapper mainMapper;
}
