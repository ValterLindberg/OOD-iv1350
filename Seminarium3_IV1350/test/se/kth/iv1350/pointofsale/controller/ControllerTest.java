package se.kth.iv1350.pointofsale.controller;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pointofsale.integration.ExternalAccountingSystem;
import se.kth.iv1350.pointofsale.integration.ExternalInventorySystem;
import se.kth.iv1350.pointofsale.model.Sale;

class ControllerTest {
	private ExternalInventorySystem extInv = new ExternalInventorySystem();
	private ExternalAccountingSystem extAcc= new ExternalAccountingSystem();
	private Controller contr = new Controller(extInv,extAcc);
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testScanItem() {
		Sale saleTest = new Sale(extInv,extAcc);
		int itemID = 0;
		String expectedItem = "Arvid Nordquist mellanrost";
	    contr.startSale();
		contr.scanItem(itemID);
		String fetchFirstItem = saleTest.getItemList().get(itemID).getItemDescription();
		System.out.println(fetchFirstItem);
		assertTrue(expectedItem == fetchFirstItem, "Result not correct");
	}

	@Test
	void testEndSale() {
		
	}

	@Test
	void testPay() {
		double amountPayed = 500;
		double change = contr.pay(amountPayed, "cash");
		assertTrue(change == 500, "Result not what was expected");
	}

}
