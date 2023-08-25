package com.app.icontact.controller;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/idea-files/*")
public class IdeaFileController {
//    파일 업로드
    @PostMapping("upload")
    @ResponseBody
    public List<String> upload(@RequestParam("uploadFile") List<MultipartFile> uploadFiles) throws IOException {
        String path = "C:/upload/idea/" + getPath();
        List<String> uuids = new ArrayList<>();
        File file = new File(path);
        if(!file.exists()){file.mkdirs();}

        for (int i=0; i<uploadFiles.size(); i++){
            uuids.add(UUID.randomUUID().toString());
            uploadFiles.get(i).transferTo(new File(path, uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
            if(uploadFiles.get(i).getContentType().startsWith("image")){
                FileOutputStream out = new FileOutputStream(new File(path, "t_" + uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
                Thumbnailator.createThumbnail(uploadFiles.get(i).getInputStream(), out, 360, 360);
                out.close();
            }
        }
        return uuids;
    }

    public String getPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

//    파일 불러오기
//    @GetMapping("display")
//    @ResponseBody
//    public byte[] display(String fileName) throws IOException {
//        return FileCopyUtils.copyToByteArray(new File("C:/upload/idea/", fileName));
//    }
    @GetMapping("display")
    @ResponseBody
    public byte[] display(String fileName) throws IOException {
        Path filePath = Paths.get("C:/upload/idea/", fileName);

        if (!Files.exists(filePath)) {
            throw new FileNotFoundException("Requested " + fileName + " does not exist.");
        }

        byte[] fileBytes = Files.readAllBytes(filePath);

        // 아래의 코드는 모든 이미지를 jpeg로 간주합니다.
        // 실제 환경에서는 파일 확장자나 MIME 타입을 확인하여 적절한 타입을 반환해야 합니다.
        ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(fileBytes);

        return fileBytes;
    }



    //    파일 다운로드
    @GetMapping
    public ResponseEntity<Resource> download(String fileName) throws UnsupportedEncodingException {
        Resource resource = new FileSystemResource("C:/upload/idea/" + fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + new String(fileName.substring(fileName.indexOf("_") + 1).getBytes("UTF-8"), "ISO-8859"));
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}





















