package collections;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MapsToMaps_repeat {

	public static void main(String[] args) {
		mapstoMaps();
	}

	public static void mapstoMaps() {
		Map<String, Integer> channelToSubscribers = new TreeMap<>(); // channelName, numSubscribers
		Map<String, String> channelToPublisher = new TreeMap<>(); // channelName, publisher
		Map<String, Integer> publisherToSubscribers = new TreeMap<>(); // publisher, numSubscribers

		// channel -> number of subscribers (K, V1)
		channelToSubscribers.put("JustForLaughs", 120_000);
		channelToSubscribers.put("JustForGags", 10_000);
		channelToSubscribers.put("ContemplationTechniques", 10_000);
		channelToSubscribers.put("A New Earth", 20_000);

		// channel -> publisher (K, V2)
		channelToPublisher.put("JustForLaughs", "Charlie Chaplin");
		channelToPublisher.put("JustForGags", "Charlie Chaplin");
		channelToPublisher.put("ContemplationTechniques", "Echhart Tolle");
		channelToPublisher.put("A New Earth", "Echhart Tolle");

		channelToSubscribers.forEach((channel, subscribers) -> {
			String publisher = channelToPublisher.get(channel);
			if (publisherToSubscribers.containsKey(publisher)) {
				int currentSubscribers = publisherToSubscribers.get(publisher);
				int numSubs = subscribers + currentSubscribers;
				publisherToSubscribers.put(publisher, numSubs);
			} else {
				publisherToSubscribers.put(publisher, subscribers);
			}

		});
		
		publisherToSubscribers.forEach((publisher, subscribers) -> {
			System.out.println("Publisher: " + publisher + " has " + subscribers + " subscribers.");
		});
		
	   	int min = Collections.min(publisherToSubscribers.values());
	   	int max = Collections.max(publisherToSubscribers.values());
//	   	System.out.println(min);
//	   	System.out.println(max);
	   	
	   	// if you want to loop through and display publisher and min / max subscribers
	   	publisherToSubscribers.forEach((publisher, subscribers) -> {
	   		if (publisherToSubscribers.get(publisher) == max) {
	   			System.out.println("Publisher " + publisher + " has max subscribers (" + subscribers + ")");
	   		}
	   		else if (publisherToSubscribers.get(publisher) == min){
	   			System.out.println("Publisher " + publisher + " has min subscribers (" + subscribers + ")");
	   		}
	   	});
	}

}
