CREATE TABLE student (
    id BIGSERIAL PRIMARY KEY,
    firstName VARCHAR(30),
    lastName VARCHAR(30),
    email VARCHAR(100) UNIQUE,
    country VARCHAR (2)
);

CREATE TABLE course (
    id BIGSERIAL PRIMARY KEY,
    courseName VARCHAR(30) UNIQUE
);

CREATE TABLE Student_Course (
    id_student INT,
    id_course INT,
    PRIMARY KEY (id_student, id_course),  -- Combinación de las claves foráneas como clave primaria
    FOREIGN KEY (id_student) REFERENCES student(id),
    FOREIGN KEY (id_course) REFERENCES course(id)
);

CREATE TABLE country (
    id BIGSERIAL PRIMARY KEY,
    countryName VARCHAR(255),
    code VARCHAR(3) UNIQUE
);


ALTER TABLE student
ADD CONSTRAINT FK_country_student
FOREIGN KEY (country)
REFERENCES country (code);


INSERT INTO country (countryName, code) VALUES ('Afghanistan', 'AF');
INSERT INTO country (countryName, code) VALUES ('Åland Islands', 'AX');
INSERT INTO country (countryName, code) VALUES ('Albania', 'AL');
INSERT INTO country (countryName, code) VALUES ('Algeria', 'DZ');
INSERT INTO country (countryName, code) VALUES ('American Samoa', 'AS');
INSERT INTO country (countryName, code) VALUES ('Andorra', 'AD');
INSERT INTO country (countryName, code) VALUES ('Angola', 'AO');
INSERT INTO country (countryName, code) VALUES ('Anguilla', 'AI');
INSERT INTO country (countryName, code) VALUES ('Antarctica', 'AQ');
INSERT INTO country (countryName, code) VALUES ('Antigua and Barbuda', 'AG');
INSERT INTO country (countryName, code) VALUES ('Argentina', 'AR');
INSERT INTO country (countryName, code) VALUES ('Armenia', 'AM');
INSERT INTO country (countryName, code) VALUES ('Aruba', 'AW');
INSERT INTO country (countryName, code) VALUES ('Australia', 'AU');
INSERT INTO country (countryName, code) VALUES ('Austria', 'AT');
INSERT INTO country (countryName, code) VALUES ('Azerbaijan', 'AZ');
INSERT INTO country (countryName, code) VALUES ('Bahamas', 'BS');
INSERT INTO country (countryName, code) VALUES ('Bahrain', 'BH');
INSERT INTO country (countryName, code) VALUES ('Bangladesh', 'BD');
INSERT INTO country (countryName, code) VALUES ('Barbados', 'BB');
INSERT INTO country (countryName, code) VALUES ('Belarus', 'BY');
INSERT INTO country (countryName, code) VALUES ('Belgium', 'BE');
INSERT INTO country (countryName, code) VALUES ('Belize', 'BZ');
INSERT INTO country (countryName, code) VALUES ('Benin', 'BJ');
INSERT INTO country (countryName, code) VALUES ('Bermuda', 'BM');
INSERT INTO country (countryName, code) VALUES ('Bhutan', 'BT');
INSERT INTO country (countryName, code) VALUES ('Bolivia', 'BO');
INSERT INTO country (countryName, code) VALUES ('Bosnia and Herzegovina', 'BA');
INSERT INTO country (countryName, code) VALUES ('Botswana', 'BW');
INSERT INTO country (countryName, code) VALUES ('Bouvet Island', 'BV');
INSERT INTO country (countryName, code) VALUES ('Brazil', 'BR');
INSERT INTO country (countryName, code) VALUES ('British Indian Ocean Territory', 'IO');
INSERT INTO country (countryName, code) VALUES ('Brunei Darussalam', 'BN');
INSERT INTO country (countryName, code) VALUES ('Bulgaria', 'BG');
INSERT INTO country (countryName, code) VALUES ('Burkina Faso', 'BF');
INSERT INTO country (countryName, code) VALUES ('Burundi', 'BI');
INSERT INTO country (countryName, code) VALUES ('Cambodia', 'KH');
INSERT INTO country (countryName, code) VALUES ('Cameroon', 'CM');
INSERT INTO country (countryName, code) VALUES ('Canada', 'CA');
INSERT INTO country (countryName, code) VALUES ('Cape Verde', 'CV');
INSERT INTO country (countryName, code) VALUES ('Cayman Islands', 'KY');
INSERT INTO country (countryName, code) VALUES ('Central African Republic', 'CF');
INSERT INTO country (countryName, code) VALUES ('Chad', 'TD');
INSERT INTO country (countryName, code) VALUES ('Chile', 'CL');
INSERT INTO country (countryName, code) VALUES ('China', 'CN');
INSERT INTO country (countryName, code) VALUES ('Christmas Island', 'CX');
INSERT INTO country (countryName, code) VALUES ('Cocos (Keeling) Islands', 'CC');
INSERT INTO country (countryName, code) VALUES ('Colombia', 'CO');
INSERT INTO country (countryName, code) VALUES ('Comoros', 'KM');
INSERT INTO country (countryName, code) VALUES ('Congo', 'CG');
INSERT INTO country (countryName, code) VALUES ('Congo, The Democratic Republic of the', 'CD');
INSERT INTO country (countryName, code) VALUES ('Cook Islands', 'CK');
INSERT INTO country (countryName, code) VALUES ('Costa Rica', 'CR');
INSERT INTO country (countryName, code) VALUES ('Cote DeIvoire', 'CI');
INSERT INTO country (countryName, code) VALUES ('Croatia', 'HR');
INSERT INTO country (countryName, code) VALUES ('Cuba', 'CU');
INSERT INTO country (countryName, code) VALUES ('Cyprus', 'CY');
INSERT INTO country (countryName, code) VALUES ('Czech Republic', 'CZ');
INSERT INTO country (countryName, code) VALUES ('Denmark', 'DK');
INSERT INTO country (countryName, code) VALUES ('Djibouti', 'DJ');
INSERT INTO country (countryName, code) VALUES ('Dominica', 'DM');
INSERT INTO country (countryName, code) VALUES ('Dominican Republic', 'DO');
INSERT INTO country (countryName, code) VALUES ('Ecuador', 'EC');
INSERT INTO country (countryName, code) VALUES ('Egypt', 'EG');
INSERT INTO country (countryName, code) VALUES ('El Salvador', 'SV');
INSERT INTO country (countryName, code) VALUES ('Equatorial Guinea', 'GQ');
INSERT INTO country (countryName, code) VALUES ('Eritrea', 'ER');
INSERT INTO country (countryName, code) VALUES ('Estonia', 'EE');
INSERT INTO country (countryName, code) VALUES ('Ethiopia', 'ET');
INSERT INTO country (countryName, code) VALUES ('Falkland Islands (Malvinas)', 'FK');
INSERT INTO country (countryName, code) VALUES ('Faroe Islands', 'FO');
INSERT INTO country (countryName, code) VALUES ('Fiji', 'FJ');
INSERT INTO country (countryName, code) VALUES ('Finland', 'FI');
INSERT INTO country (countryName, code) VALUES ('France', 'FR');
INSERT INTO country (countryName, code) VALUES ('French Guiana', 'GF');
INSERT INTO country (countryName, code) VALUES ('French Polynesia', 'PF');
INSERT INTO country (countryName, code) VALUES ('French Southern Territories', 'TF');
INSERT INTO country (countryName, code) VALUES ('Gabon', 'GA');
INSERT INTO country (countryName, code) VALUES ('Gambia', 'GM');
INSERT INTO country (countryName, code) VALUES ('Georgia', 'GE');
INSERT INTO country (countryName, code) VALUES ('Germany', 'DE');
INSERT INTO country (countryName, code) VALUES ('Ghana', 'GH');
INSERT INTO country (countryName, code) VALUES ('Gibraltar', 'GI');
INSERT INTO country (countryName, code) VALUES ('Greece', 'GR');
INSERT INTO country (countryName, code) VALUES ('Greenland', 'GL');
INSERT INTO country (countryName, code) VALUES ('Grenada', 'GD');
INSERT INTO country (countryName, code) VALUES ('Guadeloupe', 'GP');
INSERT INTO country (countryName, code) VALUES ('Guam', 'GU');
INSERT INTO country (countryName, code) VALUES ('Guatemala', 'GT');
INSERT INTO country (countryName, code) VALUES ('Guernsey', 'GG');
INSERT INTO country (countryName, code) VALUES ('Guinea', 'GN');
INSERT INTO country (countryName, code) VALUES ('Guinea-Bissau', 'GW');
INSERT INTO country (countryName, code) VALUES ('Guyana', 'GY');
INSERT INTO country (countryName, code) VALUES ('Haiti', 'HT');
INSERT INTO country (countryName, code) VALUES ('Heard Island and Mcdonald Islands', 'HM');
INSERT INTO country (countryName, code) VALUES ('Holy See (Vatican City State)', 'VA');
INSERT INTO country (countryName, code) VALUES ('Honduras', 'HN');
INSERT INTO country (countryName, code) VALUES ('Hong Kong', 'HK');
INSERT INTO country (countryName, code) VALUES ('Hungary', 'HU');
INSERT INTO country (countryName, code) VALUES ('Iceland', 'IS');
INSERT INTO country (countryName, code) VALUES ('India', 'IN');
INSERT INTO country (countryName, code) VALUES ('Indonesia', 'ID');
INSERT INTO country (countryName, code) VALUES ('Iran, Islamic Republic Of', 'IR');
INSERT INTO country (countryName, code) VALUES ('Iraq', 'IQ');
INSERT INTO country (countryName, code) VALUES ('Ireland', 'IE');
INSERT INTO country (countryName, code) VALUES ('Isle of Man', 'IM');
INSERT INTO country (countryName, code) VALUES ('Israel', 'IL');
INSERT INTO country (countryName, code) VALUES ('Italy', 'IT');
INSERT INTO country (countryName, code) VALUES ('Jamaica', 'JM');
INSERT INTO country (countryName, code) VALUES ('Japan', 'JP');
INSERT INTO country (countryName, code) VALUES ('Jersey', 'JE');
INSERT INTO country (countryName, code) VALUES ('Jordan', 'JO');
INSERT INTO country (countryName, code) VALUES ('Kazakhstan', 'KZ');
INSERT INTO country (countryName, code) VALUES ('Kenya', 'KE');
INSERT INTO country (countryName, code) VALUES ('Kiribati', 'KI');
INSERT INTO country (countryName, code) VALUES ('Korea, Democratic People Republic of', 'KP');
INSERT INTO country (countryName, code) VALUES ('Korea, Republic of', 'KR');
INSERT INTO country (countryName, code) VALUES ('Kuwait', 'KW');
INSERT INTO country (countryName, code) VALUES ('Kosovo', 'XK');
INSERT INTO country (countryName, code) VALUES ('Kyrgyzstan', 'KG');

