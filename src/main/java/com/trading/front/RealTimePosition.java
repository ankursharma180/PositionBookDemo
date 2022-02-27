package com.trading.front;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.trading.dto.TradeEvent;

/**
 * The Class RealTimePosition.
 */
public class RealTimePosition {

	/** The real time position map. */
	Map<String, List<TradeEvent>> realTimePositionMap = new HashMap<>();

	/** The list of input trade events. */
	public List<TradeEvent> listOfInputTradeEvents = new ArrayList<>();

	/**
	 * Display real time position.
	 */
	public void displayRealTimePosition() {
		System.out.println("\n\n<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>");
		realTimePositionMap.entrySet()
				.forEach(realTime -> System.out.println(displayTradeEventAsString(realTime.getValue())));
		System.out.println("<<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>\n");
	}

	/**
	 * Display trade event as string.
	 *
	 * @param tradeEventList the trade event list
	 * @return the string
	 */
	private String displayTradeEventAsString(List<TradeEvent> tradeEventList) {
		StringBuilder builder = new StringBuilder();
		for (TradeEvent tradeEvent : tradeEventList) {
			List<TradeEvent> collectedEvent = listOfInputTradeEvents.stream()
					.filter(event -> (event.getTradingAccont().equals(tradeEvent.getTradingAccont())
							&& event.getSecurityIdentifier().equals(tradeEvent.getSecurityIdentifier())))
					.collect(Collectors.toList());
			builder.append(" || ").append(tradeEvent.getTradingAccont()).append(" || ")
					.append(tradeEvent.getSecurityIdentifier()).append(" || ");
			builder.append(tradeEventList.stream().mapToInt(event -> event.getNumberOfUnits()).sum()).append(" || ");
			collectedEvent.stream().forEach(event -> {
				builder.append(event.toString()).append(" ");
			});
		}
		builder.append("||");
		return builder.toString();
	}
}
