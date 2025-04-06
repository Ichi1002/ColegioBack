package com.colegio.models;

import com.colegio.exception.CharacterNotValidException;
import com.colegio.exception.InvalidLengthException;
import com.colegio.models.VO.Email;
import com.colegio.models.VO.NameValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class StudentTest {

    @Test
    public void should_create_a_student(){
        Student student = Student.builder()
                .id(1L)
                .firstName(new NameValidator("JHOE"))
                .lastName(new NameValidator("PEREZ"))
                .email(new Email("PEREZ.JHOE@FASTTRACK.COM.CO"))
                .country("CO")
                .build();

        assertEquals(1L,student.getId());
        assertEquals("JHOE",student.getFirstName().getName());
        assertEquals("PEREZ",student.getLastName().getName());
        assertEquals("CO", student.getCountry());
        assertEquals("PEREZ.JHOE@FASTTRACK.COM.CO",student.getEmail().getEmail());
    }

    @Test
    public void should_not_create_a_student_if_name_length_is_bigger_than_30(){
        Student student = new Student();
        assertThrows(
                InvalidLengthException.class,()->
                student.setFirstName(new NameValidator("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE")));
    }

    @Test
    public void should_not_create_a_student_if_name_is_lower_case(){
        Student student = new Student();
        assertThrows(
                CharacterNotValidException.class,()->
                        student.setFirstName(new NameValidator("asda")));
    }

    @Test
    public void should_not_create_a_student_if_name_has_number(){
        Student student = new Student();
        assertThrows(
                CharacterNotValidException.class,()->
                        student.setFirstName(new NameValidator("asda")));
    }

    @Test
    public void should_not_create_a_student_if_email_lenth_is_bigger_than_100(){
        Student student = new Student();
        assertThrows(
                InvalidLengthException.class,()->
                        student.setEmail(new Email("EREREDFESDERFDEDDSASDERSADASDASDDDDDDDDDDDDDDDDDVC" +
                                "VCVEERDDDDDDDDDDDDDDDDDDDDDDDDDDDDFDFDFDFEDDDDDDDDDDDDDDDDDDDDDDDDDDD")));
    }

    @Test
    public void should_generate_a_email(){
        Email email = Email.generateEmail("JHOE","PEREZ","CO");
        assertEquals("PEREZ.JHOE@FASTTRACK.COM.CO",email.getEmail());
    }

    @Test
    public void should_generate_a_email_with_number(){
        Email email = Email.generateEmail("JHOE","PEREZ","CO",1);
        assertEquals("PEREZ.JHOE.1@FASTTRACK.COM.CO",email.getEmail());
    }

}