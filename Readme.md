##Proyecto M4 con Selenium

Consistirá en testear pantallas de paginas web 

1) carpeta `drivers` donde estaran los 4 navegadores:

    a)chromedriver: Driver de Google Chrome

    b)geckodriver: Driver de Firefox 

    c)msedgedriver: Driver de Microsoft Edge

    d)operadriver: Driver de Opera


2) En el directorio `src\test\java\com\example\selenium` hay dos directorios:

    a)El primero en `src\test\java\com\example\selenium\driversTest`:

         1)ChromeTest
         2)FireFoxTest
         3)MicrosoftEdgeTest
         4)OperaTest
   b)Estos test comprueban si van los 4 navegadores 

3. En el directorio `src\test\java\com\example\selenium\WebPagesTest`
   
a)Tenemos tres directorios:

      1)demoqa
a) BaseTest: Donde estara la configuración del driver

b)DatePickerTest: Primera pantalla de test

c)FormTest: Segunda pantalla de test con un formulario

d)ProgressBarTest: Tercera pantalla del test con una barra de progreso

      2)opencart
a)BaseTest: Donde estará la configuración del driver

b)ButtonsTest: Donde estará la primera pantalla a  testear

c)ListOpenCart: Donde estará la segunda pantalla a testear

      3)orangehrm

a)BaseTest: Donde estara la configuración del driver y el test de login

b)ViewSystemUsersTest: Donde estará la primera pantalla del test.

c)AddUserTest: Donde estará la segunda pantalla de añadir un usuario.


4) También habrá una imagen de selenium con extension png que esto servirá
   para el FormTest para completar esta pantalla.