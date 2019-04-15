
/**
 * @author dream
 *
 */
package net.spring4.chap07;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventRepository{
	
	List<EventDAO> eventList = new ArrayList<>();
	
	public EventRepository() {
		EventDAO d1 = new EventDAO( new Date("2019-04-09"),	new Date("2019-04-09"),"eventTT","evetnContent");
		
	}
	
	public EventRepository(List<EventDAO> eventList) {
		this.eventList = eventList;
	}
	
	public void addEventList( List<EventDAO> eventList ) {
		this.eventList.addAll( eventList );
	}
	
	public void addEventList( EventDAO obj ) {
		this.eventList.add( obj);
	}
	
	
}