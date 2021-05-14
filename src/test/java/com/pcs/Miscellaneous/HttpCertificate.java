package com.pcs.Miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HttpCertificate {
  @Test
	public void HttpCert() {

		// SSl certificates

		// Desired capabilities=
		// general chrome profile
		DesiredCapabilities ch = DesiredCapabilities.chrome();
		// ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		// Belows to your local browser
		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		System.setProperty("webdriver.chrome.driver", "");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(c);
		/**
		 * Start your code from here as this we use to pass the Http certification.
		 * Above both Desired Capabilities and ChromeOptions class is different but work
		 * together. ChromeOptions class use for local browser setting and Desired
		 * Capabilities class is for general profile. Use the above script for where we
		 * use SSL or HTTP certification validatoin require.
		 */

  }
}
