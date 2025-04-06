APP para proyecto para Colegio

Para correr el api correctamente deberas segir los siguientes pasos
1. Hacer git pull de la rama main
2. Correr el siguiente comando .\gradlew genJaxb
3. Correr el siguiente comando .\gradlew build
4. Correr el siguiente comando docker build -t colegio .


Para correr el front correctamente deberas segir los siguientes pasos
1. Hacer git pull del siguiente repositorio https://github.com/Ichi1002/colegioFront
2. Correr el siguiente comando docker build -t colegiofront .

Una vez tengas los dos imagenes construidas deberas segir los siguientes pasos
1. Ir al carpeta donde esta el backend (Colgeio)
2. Correr el siguiente comando docker compose up
3. Cuando el comando anterior hata terminado deberas seguir los siguientes pasos
4. Con el usuario compose-postgres y la contraseña compose-postgres y la cadena de
   conexion jdbc:postgresql://db:5432/postgres entrar en tu gestor de bases de datos
   predileco, ten presente que la base de datos es POSTGRES
5. Una vez en la base de datos deberas correr el archivo Init.sql que se encuentra en la
   carpeta del backend
6. Y desde el navegador podras visitar la siguiente direccion: http://localhost/student/index
