package com.example.backend.service.pdf;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.backend.exception.CannotSavePdfException;
import com.example.backend.service.aiservice.agentservice.PdfAnalyserService;
import com.example.backend.service.aiservice.agentservice.PdfServiceFactory;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PdfService {

    private PdfAnalyserService geminiPdfAnalyser;

    public PdfService(PdfServiceFactory pdfServiceFactory){
        this.geminiPdfAnalyser = pdfServiceFactory.createAnalyserService("gemini-pdf-analyser");
    }

    /**
     * Saves a PDF file uploaded by a user to the local file system.
     *
     * <p>This method stores the PDF inside the directory {@code UPLOADS/PDF}.
     * If the directory does not exist, it is created automatically.
     * If a file with the same name already exists, it will be replaced.</p>
     *
     * @param pdf     the uploaded PDF file as a {@link MultipartFile}
     * @param user_id the ID of the user uploading the PDF (currently unused, 
     *                but may be useful for creating user-specific directories)
     * @return the absolute file path of the saved PDF as a {@link String}
     * @throws CannotSavePdfException if any error occurs while saving the PDF
     */
    public String savePdf(MultipartFile pdf,String user_id){
        
        try{
            String uploadDir = "UPLOADS/PDF";
            Path uploadPath = Paths.get(uploadDir);

            if(!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
            }

            String fileName = pdf.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);

            Files.copy(pdf.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return filePath.toString();

        }catch(Exception ex){
            throw new CannotSavePdfException(ex.getMessage());
        }
    }
    public String testModel(){
        return geminiPdfAnalyser.getAgent().testModel();
    }
    public String getAnalysis(MultipartFile pdf){
        String filePath = "UPLOADS/PDF/"+ pdf.getOriginalFilename();
        String text = geminiPdfAnalyser.extractPdfContent(filePath);
        String res = geminiPdfAnalyser.processPdfContent(filePath);
        return res;
    }
}
