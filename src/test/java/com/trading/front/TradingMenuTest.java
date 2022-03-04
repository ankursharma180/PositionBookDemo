package com.trading.front;

import static com.trading.utils.TradingConstants.QUIT;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * The Class TradingMenuTest.
 */
@ExtendWith(MockitoExtension.class)
public class TradingMenuTest {

	/** The trading menu. */
	@InjectMocks
	TradingMenu tradingMenu;

	/**
	 * Test display trading option.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testDisplayTradingOptionQuit() {
		System.setIn(new ByteArrayInputStream(QUIT.getBytes()));
		tradingMenu.displayTradingOption();
	}

	/**
	 * Test display trading option happy flow.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testDisplayTradingOptionHappyFlow() {
		Exception exception = Assertions.assertThrows(Exception.class, () -> {
			System.setIn(new ByteArrayInputStream("1,BUY,ACC1,SEC1,50".getBytes()));
			tradingMenu.displayTradingOption();
		});
		Assertions.assertEquals("No line found", exception.getMessage());
	}

	/**
	 * Test display trading option happy flow multiple events.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testDisplayTradingOptionHappyFlowMultipleEvents() {
		Exception exception = Assertions.assertThrows(Exception.class, () -> {
			System.setIn(new ByteArrayInputStream(
					"1,BUY,ACC1,SEC1,50|2,BUY,ACC1,SEC1,25|3,SELL,ACC1,SEC1,10|4,CANCEL,ACC1,SEC1,0".getBytes()));
			tradingMenu.displayTradingOption();
		});
		Assertions.assertEquals("No line found", exception.getMessage());
	}

	/**
	 * Test display trading option invalid input for Trade Event.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testDisplayTradingOptionInvalidInput() {
		Exception exception = Assertions.assertThrows(Exception.class, () -> {
			System.setIn(new ByteArrayInputStream("1,BUY,ACC1,SEC1".getBytes()));
			tradingMenu.displayTradingOption();
		});
		Assertions.assertEquals("No line found", exception.getMessage());
	}
}
