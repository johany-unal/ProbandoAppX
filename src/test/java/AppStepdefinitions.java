import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppStepdefinitions  {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    public AppSteps() {
        this.driver = AppiumDriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, 10);
    }

    // Pasos de autenticación
    @Given("La aplicación de X está abierta")
    public void la_aplicacion_de_X_esta_abierta() {
        // Verifica que la aplicación esté abierta.
    }

    @Then("Se muestra la pantalla de inicio de sesión")
    public void se_muestra_la_pantalla_de_inicio_de_sesion() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_screen_id")));
    }

    @When("Ingreso un nombre de usuario y contraseña erróneos")
    public void ingreso_un_nombre_de_usuario_y_contrasena_erroneos() {
        MobileElement usernameField = driver.findElement(By.id("username_field_id"));
        MobileElement passwordField = driver.findElement(By.id("password_field_id"));
        MobileElement loginButton = driver.findElement(By.id("login_button_id"));

        usernameField.sendKeys("wrongUser");
        passwordField.sendKeys("wrongPassword");
        loginButton.click();
    }

    @Then("Se muestra un error de autenticación")
    public void se_muestra_un_error_de_autenticacion() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_message_id")));
    }

    @When("Ingreso un nombre de usuario y contraseña correctos")
    public void ingreso_un_nombre_de_usuario_y_contrasena_correctos() {
        MobileElement usernameField = driver.findElement(By.id("username_field_id"));
        MobileElement passwordField = driver.findElement(By.id("password_field_id"));
        MobileElement loginButton = driver.findElement(By.id("login_button_id"));

        usernameField.sendKeys("correctUser");
        passwordField.sendKeys("correctPassword");
        loginButton.click();
    }

    @Then("Se ha iniciado sesión correctamente")
    public void se_ha_iniciado_sesion_correctamente() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home_screen_id")));
    }

    // Pasos de navegación a tendencias
    @When("Navego a la sección de tendencias")
    public void navego_a_la_seccion_de_tendencias() {
        MobileElement trendingTab = driver.findElement(By.id("trending_tab_id"));
        trendingTab.click();
    }

    @And("Realizo un scroll vertical")
    public void realizo_un_scroll_vertical() {
        driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));
    }

    @And("Selecciono una tendencia aleatoria")
    public void selecciono_una_tendencia_aleatoria() {
        MobileElement randomTrend = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='trend_item_id']"));
        randomTrend.click();
    }

    @Then("Se ha cargado la página de la tendencia seleccionada")
    public void se_ha_cargado_la_pagina_de_la_tendencia_seleccionada() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trend_page_id")));
    }

    // Pasos de interacción con un tweet
    @When("Abro un tweet aleatorio dentro de esa tendencia")
    public void abro_un_tweet_aleatorio_dentro_de_esa_tendencia() {
        MobileElement randomTweet = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='tweet_item_id']"));
        randomTweet.click();
    }

    @Then("Se muestra el tweet correctamente")
    public void se_muestra_el_tweet_correctamente() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tweet_detail_id")));
    }

    @When("Le doy \"Me gusta\" al tweet")
    public void le_doy_me_gusta_al_tweet() {
        MobileElement likeButton = driver.findElement(By.id("like_button_id"));
        likeButton.click();
    }

    @Then("El tweet ha recibido el \"Me gusta\" correctamente")
    public void el_tweet_ha_recibido_el_me_gusta_correctamente() {
        MobileElement likeCount = driver.findElement(By.id("like_count_id"));
        String likes = likeCount.getText();
        // Asegúrate de que el conteo de "Me gusta" ha incrementado
        // Puedes implementar la lógica de verificación aquí
    }
}
