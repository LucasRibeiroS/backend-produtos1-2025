package lucas.ifmg.produtos.resources;

import lucas.ifmg.produtos.dto.EmailDto;
import lucas.ifmg.produtos.services.EmailService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email")
public class EmailResource {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody EmailDto dto){
        emailService.sendMail(dto);
        return ResponseEntity.noContent().build();
    }
}