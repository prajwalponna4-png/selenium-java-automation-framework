package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class E2ETest extends BaseTest {

	@Test
	public void testFlow() {

		LoginPage login = new LoginPage(driver);
		ProductsPage products = new ProductsPage(driver);
		CartPage cart = new CartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);

		login.login("standard_user", "secret_sauce");
		products.addItemToCart();
		products.goToCart();
		cart.clickCheckout();
		checkout.enterDetails("Test", "User", "500001");
		checkout.completeCheckout();

		// Validation
		Assert.assertEquals(checkout.getConfirmationMessage(), "Thank you for your order!");
	}
}