package se.kth.iv1350.pointofsale.integration;
import se.kth.iv1350.pointofsale.model.*;
import java.util.*;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExternalAccountingSystemTest {
	private ExternalAccountingSystem extAcc;
	private ExternalInventorySystem extInv;
	
	public ExternalAccountingSystemTest(){
		extAcc = new ExternalAccountingSystem();
		extInv = new ExternalInventorySystem();
	}
	

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
	void testExternalAccountingSystem() {
		
	}

	@Test
	void testRegisterSale() {
		Sale saleTest = new Sale(extInv,extAcc);
		LocalDateTime time = LocalDateTime.now();
		SaleDTO saleLogTest = new SaleDTO(10,5,saleTest.getItemList(),time,0);
		extAcc.registerSale(saleLogTest);
		assertTrue(extAcc.getListOfSales().get(0) == saleLogTest, "SaleDTO is expected to be registered at index 0");
		
		
	}

	

	@Test
	void testUpdateRegisterBalance() {
		System.out.println("testing register update");
		extAcc.updateRegisterBalance(500);
		double testResult = extAcc.getRegisterBalance();
		assertTrue(testResult == 2500, "expected result is that register balance is 2500");
	}

	@Test
	void testGetRegisterBalance() {
		System.out.println("another test");
		double result = extAcc.getRegisterBalance();
		assertTrue(result == 2000);
		
	}

}
