package com.benue.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.benue.exercises.Session.SessionType.AFTERNOON;
import static com.benue.exercises.Session.SessionType.MORNING;

/**
 * Conference encapsulates talks and tracks and has logic to calculate the conference schedule
 *
 * @author Ade Lucas
 */
public class Conference {

	private Talks 			talks;
	private Track[] 		tracks;

	public Conference(List<String> talksStrings) {
		init(talksStrings);
	}

	/**
	 * Construct housekeeping data structures for Talks and Tracks
	 * - construct Talks object from parsed talks strings, determine track count
	 * - construct corresponding tracks structures from trackcount
	 * @param talksStrings string representation of talks
	 */
	private void init(List<String> talksStrings) {

		this.talks 		= new Talks(talksStrings);
		int numberOfTracks 	= talks.getTrackCount();
		this.tracks 		= new Track[numberOfTracks];

		IntStream.range(0, numberOfTracks).forEach(i -> tracks[i] = new Track());
	}


	/**
	 * Calculate the conference schedule
	 * The talks have deliberately not been sorted to allow some control over how talks are distributed by size.
	 * Sorting the talks by size before scheduling will result in a lopsided distribution of talks by size in the sessions.
	 */
	void schedule() {

		int trackCount 		= talks.getTrackCount();
		List<Talk> talksList 	= talks.getTalks();

		for (Talk talk : talksList) {

			for (int i = 0; i < trackCount; i++) {

				if (tracks[i].getMorningSession().getSessionFreeTime() >= talk.getDuration()) {

					tracks[i].getMorningSession().add(talk);
					talk.setProcessed(true);
					break;
				} else if (tracks[i].getAfternoonSession().getSessionFreeTime() >= talk.getDuration()) {

					tracks[i].getAfternoonSession().add(talk);
					talk.setProcessed(true);
					break;
				}
			}
		}

		boolean done = true;

		for (Talk talk : talks.getTalks()) {
			if (!talk.isProcessed()) { done=false; break;}
		}

		if(!done) {

			// Bump up number of tracks by one and try all over
			// - simpler /more reliable code worth the cost of extra processing, data set so small - not an issue
			trackCount++;

			this.tracks = new Track[trackCount];

			IntStream.range(0, trackCount).forEach(i -> tracks[i] = new Track());

			this.talks.setTrackCount(trackCount);

			schedule();
		}
	}


	/**
	 * @return the calculated conference schedule for writing to text file
	 */
	List<String> getConferenceSchedule() {

		List<String> schedule 	= new ArrayList<>();
		int trackCount 		= talks.getTrackCount();

		IntStream.range(0, trackCount).forEach(i -> {
			schedule.add("Track " + (i + 1) + ":\n");
			schedule.add(tracks[i].getMorningSession().toString());
			schedule.add("12:00PM Lunch\n");
			schedule.add(tracks[i].getAfternoonSession().toString());
			schedule.add("05:00PM Networking Event\n\n");
		});

		return schedule;
	}


	/**
	 * Represents a conference track
	 */
	static class Track {

		private final Session morningSession;
		private final Session afternoonSession;

		Track() {
			this.morningSession 	= new Session(MORNING);
			this.afternoonSession 	= new Session(AFTERNOON);
		}

		Session getMorningSession() {
			return morningSession;
		}

		Session getAfternoonSession() {
			return afternoonSession;
		}
	}
}
