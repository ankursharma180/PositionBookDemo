package com.trading.front;

import static com.trading.utils.TradingConstants.COMMA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	 * This method will display the trading options for each trading event type
	 * (Buy, Sell and Cancel). User needs to enter the number for each trading
	 * event, 1 - Buy, 2 - Sell and 3 - Cancel. To quit trading program, Select
	 * Option : 4 - Quit.
	 */
	public static void displayTradingOption() {
		RealTimePosition realTimePosition = new RealTimePosition();
		Integer serialNo = 0;
		boolean quit = false;
		System.out.println("**************************************************************");
		System.out.println("*************Welcome to JP Morgan Trading Platform.***********");
		System.out.println("**************************************************************");
		do {
			serialNo = buySellCancelSecurities(realTimePosition, serialNo, null);
			realTimePosition.displayRealTimePosition();
		} while (!quit);
	}

	/**
	 * This method is to Handle Buy, Sell or Cancel securities.
	 *
	 * @param realTimePosition the real time position
	 * @param serialNo         the serial no
	 * @param buySecurities    the buy securities
	 * @return the integer
	 */
	private static Integer buySellCancelSecurities(RealTimePosition realTimePosition, final Integer serialNo,
			Securities securities) {
		int newSerialNo = serialNo;
		if (securities == null) {
			securities = new BuySellCancelSecurities();
		}
		String inputSecurityStrig = securities.getSecuritiesInput(++newSerialNo);
		String[] input = inputSecurityStrig.split(COMMA);
		if (input.length == 5) {
			TradeEvent tradeEvent = securities.prepareTradeEvent(input, inputSecurityStrig);
			String aggKey = tradeEvent.getTradingAccont() + tradeEvent.getSecurityIdentifier();
			if (realTimePosition.realTimePositionMap.get(aggKey) != null) {
				List<TradeEvent> listOfTradeEvent = realTimePosition.realTimePositionMap.get(aggKey);
				if (TradingEventType.valueOf(tradeEvent.getTradingEventType()) == TradingEventType.BUY) {
					listOfTradeEvent.get(0).setNumberOfUnits(
							listOfTradeEvent.get(0).getNumberOfUnits() + tradeEvent.getNumberOfUnits());
				} else if (TradingEventType.valueOf(tradeEvent.getTradingEventType()) == TradingEventType.SELL) {
					listOfTradeEvent.get(0).setNumberOfUnits(
							listOfTradeEvent.get(0).getNumberOfUnits() - tradeEvent.getNumberOfUnits());
				} else {
					securities.cancelSecurities(realTimePosition, tradeEvent, listOfTradeEvent);
				}
				listOfTradeEvent.get(0).setRawInputFromUser(
						listOfTradeEvent.get(0).getRawInputFromUser() + ",[" + inputSecurityStrig + "]");
			} else {
				List<TradeEvent> tradeEventList = new ArrayList<>();
				tradeEventList.add(tradeEvent);
				realTimePosition.realTimePositionMap.put(aggKey, tradeEventList);
			}
			realTimePosition.listOfInputTradeEvents.add(tradeEvent);
		} else {
			System.out.println("Invalid Data, please provide input again");
			buySellCancelSecurities(realTimePosition, --newSerialNo, securities);
		}
		return newSerialNo;
	}
}
