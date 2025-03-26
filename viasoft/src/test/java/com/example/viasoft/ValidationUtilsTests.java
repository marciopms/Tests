package com.example.viasoft;

import com.example.viasoft.dto.EmailAwsDTO;
import com.example.viasoft.dto.EmailOciDTO;
import com.example.viasoft.utils.ValidatorUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTests {

    public ValidatorUtils validatorUtils = new ValidatorUtils();

    @Test
    public void validadeFields_ThrowException() {

        EmailAwsDTO awsDTO = new EmailAwsDTO("remetente@remetente.com", "Remetente",
                "destinaaaaaaaaaaaaaaaaaatario@destinatario.com", "Assunto", "conteudo");

        Assertions.assertThrows(Exception.class, () -> validatorUtils.validateFields(awsDTO));
    }

    @Test
    public void validateFields_DoesNotThrowException() throws Exception {
        EmailOciDTO ociDTO = new EmailOciDTO("remetente@remetente.com", "Remetente",
                "destinatario@destinatario.com", "Assunto", "conteudo");

        Assertions.assertDoesNotThrow(() -> validatorUtils.validateFields(ociDTO));
    }
}
