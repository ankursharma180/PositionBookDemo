package com.trading.front;

import static com.trading.utils.TradingConstants.COMMA;
import static com.trading.utils.TradingConstants.PIPE;
import static com.trading.utils.TradingConstants.QUIT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.trading.business.BuySellCancelSecurities;
import com.trading.business.Securities;
import com.trading.dto.TradeEvent;
import com.trading.dto.TradingEventType;

/**
 * The Class TradingMenu.
 * 
 * @author Ankur Sharma
 */
public class TradingMenu {
	/**
	 * This method will accept trading input. anytime, you want to exit, type QUIT.
	 */
	public static void displayTradingOption() {
		RealTimePosition realTimePosition = new RealTimePosition();
		Integer serialNo = 0;
		boolean quit = false;
		System.out.println("**************************************************************");
		System.out.println("*************Welcome to JP Morgan Trading Platform.***********");
		System.out.println("**************************************************************");
		do {
			String decision = buySellCancelSecurities(realTimePosition, serialNo, null);
			if (decision.startsWith("true")) {
				quit = true;
				System.out.println("Exit from Position Book ");
			} else {
				serialNo = Integer.valueOf(decision.split(PIPE)[1]);
				realTimePosition.displayRealTimePosition();
			}
		} while (!quit);
	}

	/**
	 * This method is to Handle Buy, Sell or Cancel securities.
	 *
	 * @param realTimePosition the real time position
	 * @param serialNo         the serial no
	 * @param securities       the securities
	 * @return the integer
	 */
	private static String buySellCancelSecurities(RealTimePosition realTimePosition, final Integer serialNo,
			Securities securities) {
		int newSerialNo = serialNo;
		if (securities == null) {
			securities = new BuySellCancelSecurities();
		}
		String inputSecurityStrig = securities.getSecuritiesInput(++newSerialNo);
		if (inputSecurityStrig.equals(QUIT)) {
			return "true|" + newSerialNo;
		}
		List<String> inputList = Arrays.asList(inputSecurityStrig.split(PIPE));
		for (String event : inputList) {
			String[] input = event.split(COMMA);
			if (input.length == 5) {
				TradeEvent tradeEvent = securities.prepareTradeEvent(input);
				String aggKey = tradeEvent.getTradingAccont() + tradeEvent.getSecurityIdentifier();
				List<TradeEvent> listOfTradeEvent = realTimePosition.realTimePositionMap.get(aggKey);
				if (realTimePosition.realTimePositionMap.get(aggKey) != null) {
					if (TradingEventType.valueOf(tradeEvent.getTradingEventType()) == TradingEventType.BUY) {
						listOfTradeEvent.get(0).setNumberOfUnits(
								listOfTradeEvent.get(0).getNumberOfUnits() + tradeEvent.getNumberOfUnits());
					} else if (TradingEventType.valueOf(tradeEvent.getTradingEventType()) == TradingEventType.SELL) {
						listOfTradeEvent.get(0).setNumberOfUnits(
								listOfTradeEvent.get(0).getNumberOfUnits() - tradeEvent.getNumberOfUnits());
					} else {
						securities.cancelSecurities(realTimePosition, tradeEvent, listOfTradeEvent);
					}
				} else {
					List<TradeEvent> tradeEventList = new ArrayList<>();
					tradeEventList.add(tradeEvent);
					realTimePosition.realTimePositionMap.put(aggKey, tradeEventList);
				}
				addTradeEventForRealTimeDisplay(realTimePosition, securities, inputSecurityStrig, input);
			} else {
				System.out.println("Invalid Data, please provide input again");
				buySellCancelSecurities(realTimePosition, --newSerialNo, securities);
			}
		}
		newSerialNo += (inputList.size() - 1);
		return "false|" + newSerialNo;
	}

	/**
	 * Adds the trade event for real time display.
	 *
	 * @param realTimePosition   the real time position
	 * @param securities         the securities
	 * @param inputSecurityStrig the input security strig
	 * @param input              the input
	 * @return the trade event
	 */
	private static TradeEvent addTradeEventForRealTimeDisplay(RealTimePosition realTimePosition, Securities securities,
			String inputSecurityStrig, String[] input) {
		TradeEvent tradeEvent = securities.prepareTradeEvent(input);
		realTimePosition.listOfInputTradeEvents.add(tradeEvent);
		return tradeEvent;
	}
}
