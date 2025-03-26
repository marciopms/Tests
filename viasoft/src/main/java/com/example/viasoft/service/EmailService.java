package com.example.viasoft.service;

import com.example.viasoft.dto.EmailAwsDTO;
import com.example.viasoft.dto.EmailDTO;
import com.example.viasoft.dto.EmailOciDTO;
import com.example.viasoft.utils.ValidatorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final ValidatorUtils validatorUtils;
    @Value("${mail.integracao}")
    private String integrationType;

    public EmailService(ValidatorUtils validatorUtils) {
        this.validatorUtils = validatorUtils;
    }

    public void sendEmail(EmailDTO dto) throws Exception {
        Object request;

        if (integrationType.equalsIgnoreCase("OCI")) {
            request = getOciEmail(dto);
        } else {
            request = getAwsEmail(dto);
        }

        validatorUtils.validateFields(request);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(request));
    }

    public EmailAwsDTO getAwsEmail(EmailDTO dto) {
        EmailAwsDTO awsDTO = new EmailAwsDTO();

        awsDTO.setRecipient(dto.recipient());
        awsDTO.setRecipientName(dto.recipientName());
        awsDTO.setSender(dto.sender());
        awsDTO.setSubject(dto.subject());
        awsDTO.setContent(dto.content());

        return awsDTO;
    }

    public EmailOciDTO getOciEmail(EmailDTO dto) {
        EmailOciDTO ociDTO = new EmailOciDTO();

        ociDTO.setRecipientEmail(dto.recipient());
        ociDTO.setRecipientName(dto.recipientName());
        ociDTO.setSenderEmail(dto.sender());
        ociDTO.setSubject(dto.subject());
        ociDTO.setBody(dto.content());

        return ociDTO;
    }
}
