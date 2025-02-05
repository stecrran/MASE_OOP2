package collections;

import java.util.Map;
import java.util.TreeMap;

public class MapsToMaps {
	
	public static void main(String[] args) {
		mapstoMaps();
	}

	public static void mapstoMaps() {
    Map<String, Integer> channelToSubscribers = new TreeMap<>(); // channelName, numSubscribers
    Map<String, String> channelToPublisher = new TreeMap<>(); // channelName, publisher
    Map<String, Integer> publisherToSubscribers = new TreeMap<>(); // publisher, numSubscribers
        
    // channel -> number of subscribers	(K, V1)
    channelToSubscribers.put("JustForLaughs", 120_000); 
    channelToSubscribers.put("JustForGags", 10_000); 
    channelToSubscribers.put("ContemplationTechniques", 10_000); 
    channelToSubscribers.put("A New Earth", 20_000); 
    
    // channel -> publisher	(K, V2)
    channelToPublisher.put("JustForLaughs", "Charlie Chaplin");
    channelToPublisher.put("JustForGags", "Charlie Chaplin");
    channelToPublisher.put("ContemplationTechniques", "Echhart Tolle");
    channelToPublisher.put("A New Earth", "Echhart Tolle");
    
    // publisher -> number of subscribers (V2, V1)
    channelToSubscribers.forEach((channel, numSubscribers) -> {
    	String publisher = channelToPublisher.get(channel);  // get the publisher for that channel
    	if (publisherToSubscribers.containsKey(publisher)) {
    		int currentSubscribers = publisherToSubscribers.get(publisher);
    		int newVal = currentSubscribers + numSubscribers;
    		publisherToSubscribers.put(publisher, newVal);
    	}
    	else {
    		publisherToSubscribers.put(publisher, numSubscribers);
    	}
    });

    publisherToSubscribers.forEach((publisher, numSubscribers) -> 
    System.out.println(publisher + " has " + numSubscribers + " number of subscribers."));
    
    
    }
}
