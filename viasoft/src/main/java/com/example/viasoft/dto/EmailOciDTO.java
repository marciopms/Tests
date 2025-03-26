package com.example.viasoft.dto;

import jakarta.validation.constraints.Size;

public class EmailOciDTO {
    @Size(max = 40, message = "OCI: O e-mail do destinatário excedeu o limite de caracteres.")
    private String recipientEmail;
    @Size(max = 50, message = "OCI: O nome do destinatário excedeu o limite de caracteres.")
    private String recipientName;
    @Size(max = 40, message = "OCI: O e-mail do remetente excedeu o limite de caracteres.")
    private String senderEmail;
    @Size(max = 100, message = "OCI: O assunto do e-mail excedeu o limite de caracteres.")
    private String subject;
    @Size(max = 250, message = "OCI: O conteúdo do e-mail excedeu o limite de caracteres.")
    private String body;

    public EmailOciDTO() {
    }

    public EmailOciDTO(String recipientEmail, String recipientName, String senderEmail, String subject, String body) {
        this.recipientEmail = recipientEmail;
        this.recipientName = recipientName;
        this.senderEmail = senderEmail;
        this.subject = subject;
        this.body = body;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
