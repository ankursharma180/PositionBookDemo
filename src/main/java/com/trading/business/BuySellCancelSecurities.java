package com.trading.business;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.trading.dto.TradeEvent;
import com.trading.dto.TradingEventType;
import com.trading.front.RealTimePosition;

/**
 * The Class BuySecurities.
 */
public class BuySellCancelSecurities implements Securities {

	/**
	 * Buy.
	 *
	 * @param serialNo the serial no
	 * @return the string
	 */
	@SuppressWarnings("resource")
	@Override
	public String getSecuritiesInput(final Integer serialNo) {
		String buyInput = "";
		System.out.println("\n**********************GET SECURITIES INPUT********************");
		System.out.print(
				"If the input security is one, then enter input like this: " + serialNo + ",BUY,ACC1,SEC1,50 : \n");
		System.out.println(
				"If you have more than one security input, add a pipe character(|) in between input securities. \nExample: "
						+ (serialNo + ",BUY,ACC1,SEC1,50|") + ((serialNo + 1) + ",SELL,ACC1,SEC1,10"));
		System.out.print("If you want to quit, type QUIT");
		System.out.print("Please provide your input: ");
		Scanner scanner = new Scanner(System.in);
		buyInput = scanner.nextLine();
		return buyInput;
	}

	/**
	 * Cancel securities.
	 *
	 * @param realTimePosition the real time position
	 * @param tradeEvent       the trade event
	 * @param listOfTradeEvent the list of trade event
	 */
	public void cancelSecurities(final RealTimePosition realTimePosition, final TradeEvent tradeEvent,
			final List<TradeEvent> listOfTradeEvent) {
		if (realTimePosition.listOfInputTradeEvents.size() > 0) {
			Optional<TradeEvent> lastAddedEvent = realTimePosition.listOfInputTradeEvents.stream()
					.filter(event -> event.getTradingAccont().equals(tradeEvent.getTradingAccont())
							&& event.getSecurityIdentifier().equals(tradeEvent.getSecurityIdentifier()))
					.reduce((first, second) -> second);
			if (TradingEventType.valueOf(lastAddedEvent.get().getTradingEventType()) == TradingEventType.BUY) {
				listOfTradeEvent.get(0).setNumberOfUnits(
						listOfTradeEvent.get(0).getNumberOfUnits() - lastAddedEvent.get().getNumberOfUnits());
			} else if (TradingEventType.valueOf(lastAddedEvent.get().getTradingEventType()) == TradingEventType.SELL) {
				listOfTradeEvent.get(0).setNumberOfUnits(
						listOfTradeEvent.get(0).getNumberOfUnits() + lastAddedEvent.get().getNumberOfUnits());
			}
		}
	}
}
