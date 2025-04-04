package com.colegio.models.VO;

import com.colegio.exception.InvalidLengthException;
import lombok.*;

import java.util.List;


@Getter
public class Email{

    private String email;

    public Email(String email) {
        if(email==null)
            return;
        if(email.length()>100)
            throw new InvalidLengthException("Invalidad Length, Max lenth is 100");
        this.email = email;
    }

    public static Email generateEmail(String firstName, String lastName, String country){

        String FORMAT = "%s.%s@%s.%s";
        String DOMAIN = "FASTTRACK.com";

        return new Email(String.format(FORMAT,lastName.toUpperCase(),
                firstName.toUpperCase(), DOMAIN, country));
    }
    public static Email generateEmail(String firstName, String lastName, String country,int consecutive){

        String FORMAT = "%s.%s.%s@%s.%s";
        String DOMAIN = "FASTTRACK.com";

        return new Email(String.format(FORMAT,lastName.toUpperCase(),
                firstName.toUpperCase(), consecutive, DOMAIN,country));
    }


}
