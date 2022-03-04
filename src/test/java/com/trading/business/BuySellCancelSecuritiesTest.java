package com.trading.business;

import static com.trading.utils.TradingConstants.QUIT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.trading.dto.TradeEvent;
import com.trading.dto.TradingEventType;
import com.trading.front.RealTimePosition;

/**
 * The Class BuySellCancelSecuritiesTest.
 * 
 * @author Ankur Sharma
 */
@ExtendWith(MockitoExtension.class)
public class BuySellCancelSecuritiesTest {

	/** The buy sell cancel securities. */
	@InjectMocks
	public BuySellCancelSecurities buySellCancelSecurities;

	/** The real time position. */
	RealTimePosition realTimePosition;

	/** The trade event. */
	TradeEvent tradeEvent;

	/** The list of trade events. */
	List<TradeEvent> listOfTradeEvents;

	/**
	 * Test get securities input.
	 */
	@Test
	public void testGetSecuritiesInput() {
		System.setIn(new ByteArrayInputStream(QUIT.getBytes()));
		String result = buySellCancelSecurities.getSecuritiesInput(1);
		assertEquals(QUIT, result);
	}

	/**
	 * Test cancel securities.
	 */
	@Test
	public void testCancelSecuritiesBuy() {
		prepareData(TradingEventType.BUY.name());
		buySellCancelSecurities.cancelSecurities(realTimePosition, tradeEvent, listOfTradeEvents);
		assertTrue(tradeEvent.getTradingEventType().equals(TradingEventType.BUY.name()));
	}

	/**
	 * Test cancel securities sell.
	 */
	@Test
	public void testCancelSecuritiesSell() {
		prepareData(TradingEventType.SELL.name());
		buySellCancelSecurities.cancelSecurities(realTimePosition, tradeEvent, listOfTradeEvents);
		assertTrue(tradeEvent.getTradingEventType().equals(TradingEventType.SELL.name()));
	}

	/**
	 * Test cancel securities with no trade event.
	 */
	@Test
	public void testCancelSecuritiesWithNoTradeEvent() {
		prepareData(TradingEventType.SELL.name());
		realTimePosition.listOfInputTradeEvents = new ArrayList<TradeEvent>();
		buySellCancelSecurities.cancelSecurities(realTimePosition, tradeEvent, listOfTradeEvents);
		assertTrue(tradeEvent.getTradingEventType().equals(TradingEventType.SELL.name()));
	}

	/**
	 * Test prepare trade event.
	 */
	@Test
	public void testPrepareTradeEvent() {
		String[] event = new String[5];
		event[0] = "1";
		event[1] = "BUY";
		event[2] = "ACC1";
		event[3] = "SEC1";
		event[4] = "50";
		TradeEvent tradeEvent = new TradeEvent();
		tradeEvent = buySellCancelSecurities.prepareTradeEvent(event);
		assertEquals(event[0], String.valueOf(tradeEvent.getId()));
		assertEquals(event[1], tradeEvent.getTradingEventType());
		assertEquals(event[2], tradeEvent.getTradingAccont());
		assertEquals(event[3], tradeEvent.getSecurityIdentifier());
		assertEquals(event[4], String.valueOf(tradeEvent.getNumberOfUnits()));
	}

	/**
	 * Test cancel securities no match.
	 */
	@Test
	public void testCancelSecuritiesNoMatch() {
		prepareData(TradingEventType.CANCEL.name());
		buySellCancelSecurities.cancelSecurities(realTimePosition, tradeEvent, listOfTradeEvents);
		assertTrue(tradeEvent.getTradingEventType().equals(TradingEventType.CANCEL.name()));
	}

	/**
	 * Prepare data.
	 *
	 * @param tradingEventType the trading event type
	 */
	private void prepareData(String tradingEventType) {
		realTimePosition = new RealTimePosition();
		tradeEvent = new TradeEvent(1, tradingEventType, "ACC1", "SEC1", 50);
		listOfTradeEvents = new ArrayList<>();
		listOfTradeEvents.add(tradeEvent);
		realTimePosition.realTimePositionMap.put("ACC1SEC1", listOfTradeEvents);
		realTimePosition.listOfInputTradeEvents.add(tradeEvent);
	}
}
