package com.app.icontact.mapper;

import com.app.icontact.domain.IdeaFileVO;
import com.app.icontact.type.FileType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

@SpringBootTest
@Slf4j
public class IdeaFileMapperTests {
    @Autowired
    private IdeaFileMapper ideaFileMapper;

    @Test
    public void insertTest(){
        IdeaFileVO ideaFileVO = new IdeaFileVO();
        ideaFileVO.setIdeaFileName("테스트1.png");
        ideaFileVO.setIdeaFileSize(1231231L);
        ideaFileVO.setIdeaFileUuid(UUID.randomUUID().toString());
        ideaFileVO.setIdeaFilePath("2023/05/18");
        ideaFileVO.setIdeaFileType(FileType.REPRESENTATIVE.name());
        ideaFileVO.setIdeaId(41L);
        ideaFileMapper.insert(ideaFileVO);
    }

//    @Test
//    public void selectAllTest(){
//        fileMapper.selectAll(22L).stream().map(FileVO::toString).forEach(log::info);
//    }
//
//    @Test
//    public void deleteTest(){
//        fileMapper.delete(1L);
//        assertThat(fileMapper.selectAll(22L)).hasSize(0);
//    }
//
//    @Test
//    public void deleteAllTest(){
//        fileMapper.deleteAll(22L);
//        assertThat(fileMapper.selectAll(22L)).hasSize(0);
//    }
//
//    @Test
//    public void selectYesterdayTest(){
//        final File file = Paths.get("C:/upload", "2023/05/31").toFile();
//
//        Arrays.stream(file.listFiles()).forEach(f -> log.info(f.getAbsolutePath()));
//        Arrays.stream(file.listFiles()).forEach(f -> log.info(f.getName()));
//
////        log.info(fileMapper.selectYesterday().toString());
//    }
}
