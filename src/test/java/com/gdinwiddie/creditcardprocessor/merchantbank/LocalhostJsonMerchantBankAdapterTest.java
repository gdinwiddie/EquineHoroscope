package com.gdinwiddie.creditcardprocessor.merchantbank;

import static com.github.dreamhead.moco.Moco.file;
import static com.github.dreamhead.moco.MocoJsonRunner.jsonHttpServer;
import static com.github.dreamhead.moco.Runner.running;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.gdinwiddie.creditcardprocessor.CreditCardInfo;
import com.gdinwiddie.creditcardprocessor.PaymentResult;
import com.github.dreamhead.moco.HttpServer;
import com.github.dreamhead.moco.Runnable;

public class LocalhostJsonMerchantBankAdapterTest {
	public final CreditCardInfo invalidCard = new CreditCardInfo("4222222222222220", "123", "12/2099");
	public final CreditCardInfo validCard = new CreditCardInfo("4111111111111111", "123", "12/2099");
	private JsonMerchantBankAdapter bankAdapter;
	private HttpServer server;

	@Before
	public void setUp() {
		server = jsonHttpServer(12345, file("bin/com/gdinwiddie/creditcardprocessor/merchantbank/moco_config.json"));
		bankAdapter = new JsonMerchantBankAdapter();
		bankAdapter.setBankURL("http://localhost:12345");
	}

	@Test
	public void testInvalidCard() throws Exception {
		running(server, new Runnable() {
			public void run() throws IOException {
				PaymentResult paymentResult = bankAdapter.processPayment(10, invalidCard);
				assertFalse(paymentResult.isSuccessful());
				assertEquals("invalid card", paymentResult.getReason());
			}
		});
	}

	@Test
	public void testValidCard() throws Exception {
		running(server, new Runnable() {
			public void run() throws IOException {
				PaymentResult paymentResult = bankAdapter.processPayment(10, validCard);
				assertEquals("", paymentResult.getReason());
				assertTrue(paymentResult.isSuccessful());
			}
		});
	}

}
