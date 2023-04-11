package task06;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class FacebookLocator extends TestBase {
    //    1. "https://facebook.com" Adresine gidin
    //2. “create new account” butonuna basin
    //3. “firstName” giris kutusuna bir isim yazin
    //4. “surname” giris kutusuna bir soyisim yazin
    //5. “email” giris kutusuna bir email yazin
    //6. “email” onay kutusuna emaili tekrar yazin
    //7. Bir sifre girin
    //8. Tarih icin gun secin
    //9. Tarih icin ay secin
    //10. Tarih icin yil secin
    //11. Cinsiyeti secin
    //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test
    //    edin.
    //13.Sayfayı kapatin
    @Test
    public void test01() {
        Faker faker = new Faker();


        //    1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        bekle(2);

        //2. “create new account” butonuna basin
        driver.findElement(By.xpath("//*[text()='Yeni hesap oluştur']")).click();

        //3. “firstName” giris kutusuna bir isim yazin
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());
        bekle(2);

        //4. “surname” giris kutusuna bir soyisim yazin
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());

        //5. “email” giris kutusuna bir email yazin
        driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[3]")).sendKeys("kulaksiz@gmail.com");


        //6. “email” onay kutusuna emaili tekrar yazin
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("kulaksiz@gmail.com");

        //7. Bir sifre girin
        driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys(faker.internet().password());

        //8. Tarih icin gun secin
        driver.findElement(By.id("day")).sendKeys("12");
        bekle(1);

        //9. Tarih icin ay secin
        driver.findElement(By.id("month")).sendKeys("Mayıs");
        bekle(1);

        //10. Tarih icin yil secin
        driver.findElement(By.id("year")).sendKeys("2023");
        bekle(1);

        //11. Cinsiyeti secin
        WebElement cinsiyet = driver.findElement(By.xpath("(//input[@name='sex'])[2]"));
        cinsiyet.click();
        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin
        Assert.assertTrue(cinsiyet.isSelected());
        bekle(3);

        //13.Sayfayı kapatin
        driver.close();


    }
}