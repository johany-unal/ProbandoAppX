Feature: Funcionalidades de la aplicación X

  # Escenario de autenticación
  Scenario: Usuario inicia sesión con credenciales incorrectas
    Given La aplicación de X está abierta
    Then Se muestra la pantalla de inicio de sesión
    When Ingreso un nombre de usuario y contraseña erróneos
    Then Se muestra un error de autenticación

  Scenario: Usuario inicia sesión con credenciales correctas
    Given La aplicación de X está abierta
    When Ingreso un nombre de usuario y contraseña correctos
    Then Se ha iniciado sesión correctamente

  # Escenario de navegación a tendencias
  Scenario: Usuario navega y selecciona una tendencia
    Given El usuario ha iniciado sesión correctamente
    When Navego a la sección de tendencias
    And Realizo un scroll vertical
    And Selecciono una tendencia aleatoria
    Then Se ha cargado la página de la tendencia seleccionada

  # Escenario de interacción con un tweet
  Scenario: Usuario interactúa con un tweet en una tendencia
    Given Se ha cargado la página de la tendencia seleccionada
    When Abro un tweet aleatorio dentro de esa tendencia
    Then Se muestra el tweet correctamente
    When Le doy "Me gusta" al tweet
    Then El tweet ha recibido el "Me gusta" correctamente
x