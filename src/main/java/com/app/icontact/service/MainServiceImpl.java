package com.app.icontact.service;

import com.app.icontact.DAO.IdeaDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {
    private final IdeaDAO ideaDAO;



}
