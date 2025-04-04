package com.colegio.models.VO;

import com.colegio.exception.CharacterNotValidException;
import com.colegio.exception.InvalidLengthException;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class NameValidator {
    private String name;

    public NameValidator(String name) {
        String pattern = "^[A-Z]+$";
        if(name == null)
            return;
        if (!name.matches(pattern))
            throw new CharacterNotValidException("Caracteres no validos");
        if(name.length()>30)
            throw new InvalidLengthException("Invalidad Length, Max lenth is 30");
        this.name = name;
    }
}
