package com.trading.business;

import java.util.List;

import com.trading.dto.TradeEvent;
import com.trading.front.RealTimePosition;

/**
 * The Interface Securities.
 */
public interface Securities {

	/**
	 * Gets the securities input.
	 *
	 * @param serialNo the serial no
	 * @return the securities input
	 */
	public String getSecuritiesInput(Integer serialNo);

	/**
	 * Cancel securities.
	 *
	 * @param realTimePosition the real time position
	 * @param tradeEvent       the trade event
	 * @param listOfTradevent  the list of tradevent
	 */
	public void cancelSecurities(RealTimePosition realTimePosition, TradeEvent tradeEvent,
			List<TradeEvent> listOfTradevent);

	/**
	 * Prepare trade event.
	 *
	 * @param input    the input
	 * @param rawInput the raw input
	 * @return the trade event
	 */
	public default TradeEvent prepareTradeEvent(String[] input, final String rawInput) {
		return new TradeEvent(Integer.valueOf(input[0].trim()), input[1].trim(), input[2].trim(), input[3].trim(),
				Integer.valueOf(input[4].trim()), "[" + rawInput + "]");
	}
}
