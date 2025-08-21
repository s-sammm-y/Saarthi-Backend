package com.example.backend.controller.pdf;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.backend.service.pdf.PdfService;

@RestController
@RequestMapping("/pdf/")
public class PdfController {
    private PdfService service;

    public PdfController(PdfService service){
        this.service = service;
    }

    @PostMapping("upload-pdf")
    public ResponseEntity<Map<String,Object>> processPdf(@RequestParam("pdf") MultipartFile pdf,@RequestParam("user_id") String user_id){
        String fileName = pdf.getOriginalFilename();
        long size = pdf.getSize();

        System.out.println(fileName);
        service.testResponse();
        return ResponseEntity.ok().body(Map.of("message","Succesfully"));
    }
}
