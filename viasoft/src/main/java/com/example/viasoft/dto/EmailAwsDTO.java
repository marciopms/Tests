package com.example.viasoft.dto;

import jakarta.validation.constraints.Size;

public class EmailAwsDTO {
    @Size(max = 45, message = "AWS: O e-mail do destinatário excedeu o limite de caracteres.")
    private String recipient;
    @Size(max = 60, message = "AWS: O nome do destinatário excedeu o limite de caracteres.")
    private String recipientName;
    @Size(max = 45, message = "AWS: O e-mail do remetente excedeu o limite de caracteres.")
    private String sender;
    @Size(max = 120, message = "AWS: O assunto do e-mail excedeu o limite de caracteres.")
    private String subject;
    @Size(max = 256, message = "AWS: O conteúdo do e-mail excedeu o limite de caracteres")
    private String content;

    public EmailAwsDTO() {
    }

    public EmailAwsDTO(String recipient, String recipientName, String sender, String subject, String content) {
        this.recipient = recipient;
        this.recipientName = recipientName;
        this.sender = sender;
        this.subject = subject;
        this.content = content;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
