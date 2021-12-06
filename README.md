# demoProduct
1.-Actualmente se tiene la parte web de un sistema de registro de Productos y se desea
hacer un servicio que soporte sus funcionalidades.
2.- El servicio debe permitir INSERT (post), UPDATE (put) y GETBYID (get) de un maestro / detalle de productos.
-> Por el momento solo se implemento maestro, el cual es la collecion product
-> Los siguientes son los endpoints para el servicio
-> INSERT (post) http://localhost:8080/product 
    -> Body Ej: {"name":"Anything"}
-> UPDATE (put) http://localhost:8080/product 
    -> Body Ej: {"id":"61adafa0de985063e10a4859","name":"Wood"}
    -> Si id no es valido lanzara una respuesta 404 Product not found
-> GETBYID (get) hhttp://localhost:8080/product/get/{id}
    -> Ej: http://localhost:8080/product/get/61adafa0de985063e10a4859
    -> Si id no es valido lanzara una respuesta 404 Product not found

3.- Se debe poder loguear el tiempo de respuesta de cada servicio en un archivo de texto
plano.
-> los logs estan dentro de una carpeta logs archivo spring-boot-logger.log
  Como se puede apreciar en el ejemplo posterior despues de "request take time: " muestra el tiempo en millisegundos que tomo la llamada
  -> 2021-12-06 03:01:33,993 INFO com.example.demoProduct.interceptor.ApiLogger [http-nio-8080-exec-7] requestId c9f63b8c-8570-4279-bb34-d6726ea55453, Handle :com.example.demoProduct.controller.ProductController#getProducts() , request take time: 41

4.- Implementar un “health check” del servicio para verificar su disponibilidad
-> http://localhost:8080/actuator/health

5.- Se debe poder grabar la información del producto localmente (cualquier tipo de
persistencia)
a. La Lista de campos será definido por la persona evaluada (maestro y detalle).
  -> Se trabaja sobre una bd mongo dockerizada sobre la collecion de producto
b. Utilizar migraciones para la creación de los objetos de la BD (Opcional)
  -> aun no se hizo pero se pensaba usar Flyway

6.- 2 campos del objeto maestro debe venir del Cache de la aplicación.
a. Se puede usar Cache estándar o Lazy Cache (o cualquiera que crea
pertinente).
-> Se uso Cache estandar para el servicio de GETBYID

7.- Se debe poder traer información de un servicio externo para devolver información del
producto
-> Aun no se realizo pero se piensa usar FeignClient para la comunicacion externa

8.- Se debe demostrar el manejo de properties por ambiente. Ej. la url del servicio
externo de DEV es diferente a la de PROD.
-> Aun no se implemento

9.- El objeto response del método GetById
a. maestro: data bd local + data cache + data servicio externo
b. detalle: data bd local
-> Aun falta implementar

10.-Se debe desarrollar usando TDD (Unit tests y 1 unit test de integración)
  -> Adicionalmente se implemento un unit test para el controlador y se puede ejecutar el siguiente comando para ver el resultado
  Windows .\gradlew test Linux ./gradlew test
  -> para el test de integracion se planea utilizar Cucumber

----------------------------------------------------------------------------------------------------------------------------

Instrucciones para levantar el proyecto
-> Descargar el proyecto
-> tener el daemon de docker activado
-> en la carpeta raiz del proyecto levantar usar el siguiente comando
docker-compose up
-> una vez inicializado ejecutar el siguiente comando
.\gradlew bootRun



