package com.benue.exercises;

import com.benue.exercises.util.Time;

import java.util.ArrayList;
import java.util.List;

import static com.benue.exercises.Talks.AM_SESSION_TIME_LIMIT;
import static com.benue.exercises.Talks.PM_SESSION_TIME_LIMIT;

/**
 * Represents a conference session.
 *
 * @author Ade Lucas
 */

class Session {

	// Morning starts at 9:00AM
	private static final int AM_SESSION_START = 9 * 60;
	// Afternoon starts at 1:00PM
	private static final int PM_SESSION_START = 13 * 60;

	private SessionType sessionType;
	private int sessionFreeTime;
	private List<Talk> talks;

	/**
	 * Create Session instance corresponding to the supplied type
	 *
	 * @param type of the session - MORNING or AFTERNOON
	 */
	Session(SessionType type) {

		this.talks  	= new ArrayList<>();
		sessionType 	= type;
		sessionFreeTime = type==SessionType.MORNING ? AM_SESSION_TIME_LIMIT : PM_SESSION_TIME_LIMIT;
	}

	/**
	 * Add a talk to session and adjust remaining time available in session
	 *
	 * @throws RuntimeException if available free space is smaller than duration talk.
	 */
	void add(Talk talk) {

		if (talk.getDuration() > sessionFreeTime) {
			throw new RuntimeException("Length of talk exceeds available time.");
		}

		talks.add(talk);
		sessionFreeTime -= talk.getDuration();
	}

	/**
	 * @return time available in the session.
	 */
	int getSessionFreeTime() {
		return sessionFreeTime;
	}

	/**
	 * @return a String representation of talks for printout.
	 */
	public String toString() {

		int start = sessionType.sessionStartTime();

		StringBuilder result = new StringBuilder();

		for (Talk talk : talks) {

			result.append(Time.minutes2HoursMinutes(start))
				  .append(' ')
				  .append(talk.getTitle())
			      .append(' ');

			if (talk.isLightning()) {
				result.append("lightning\n");
			}
			else {
				result.append(talk.getDuration()).append("min\n");
			}

			start += talk.getDuration();
		}

		return result.toString();
	}

	/**
	 * There are two types of sessions - morning and afternoon.
	 */
	enum SessionType {

		MORNING(AM_SESSION_START),
		AFTERNOON(PM_SESSION_START);

		private final int sessionStartTime;

		SessionType(int sessionStartTime) {
			this.sessionStartTime=sessionStartTime;
		}

		private int sessionStartTime() { return sessionStartTime; }
	}
}
