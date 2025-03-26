package com.example.viasoft.controller;

import com.example.viasoft.dto.EmailDTO;
import com.example.viasoft.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@Tag(name = "email")
public class EmailController {
    private final EmailService emailService;
    public EmailController(EmailService emailService) {
         this.emailService = emailService;
    }
    @PostMapping
    @Operation(summary = "Enviar e-mail", description = "Método para realizar o envio de e-mail")
    @ApiResponse(responseCode = "204", description = "E-mail enviado")
    @ApiResponse(responseCode = "400", description = "Se os caracteres excederem o limite da interface configurada")
    public ResponseEntity<?> sendEmail(@RequestBody EmailDTO dto) {
        try {
            emailService.sendEmail(dto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
