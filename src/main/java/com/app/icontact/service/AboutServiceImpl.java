package com.app.icontact.service;

import com.app.icontact.DAO.AboutDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {
    private final AboutDAO aboutDAO;
}
