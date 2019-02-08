package com.benue.exercises;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Encapsulates a collection of all the Talk objects as well as related Talks housekeeping attributes
 *
 * @author Ade Lucas
 */

class Talks {

	private static final Pattern LIGHTNING_PATTERN = Pattern.compile("^(.+)\\s(\\d+)?\\s?(lightning)$");

	// Up to 5 hours available in the afternoon
	static final int PM_SESSION_TIME_LIMIT = 4*60;
	// 3 hours available in the morning
	static final int AM_SESSION_TIME_LIMIT = 3*60;
	// Lightning time limit
	private static final int LIGHTNING_TIME_LIMIT  = 5;
	// Max afternoon session limit + morning duration
	private static final int TRACK_TIME_LIMIT = AM_SESSION_TIME_LIMIT + PM_SESSION_TIME_LIMIT;

	private final List<Talk> talks;

	// Total duration of all the talks
	private double talksTotalTime;

	// Number of conference tracks
	private int trackCount;

	/**
	 * Parse supplied talks strings into Talk objects
	 *
	 * @param talksStrings string representation of talks
	 */
	Talks(List<String> talksStrings) {

		// Parse talk text lines into corresponding list of Talk objects
		this.talks = parseTalks(talksStrings);

		// Determine the minimum number of tracks;
		this.trackCount = (int)Math.round((talksTotalTime / TRACK_TIME_LIMIT) + 0.5);
	}


	/**
	 * Parse talk text lines into corresponding list of Talk objects
	 *
	 * @return a list containing all the talk strings
	 * @throws RuntimeException if duration of any talk exceeds the duration of session.
	 */
	private List<Talk> parseTalks(List<String> talksStrings) {

		this.talksTotalTime = 0;

		return talksStrings
			.stream()
			.map(this::buildTalk).collect(Collectors.toList());
	}

	int getTrackCount() {
		return trackCount;
	}

	List<Talk> getTalks() {
		return talks;
	}

	void setTrackCount(int trackCount) {
		this.trackCount = trackCount;
	}

	/**
	 * Build Talk object from supplied talk string
	 * @param talkString talk string
	 * @return Talk object created from supplied talk string
	 */
	private Talk buildTalk(String talkString) {

		int titleIndexLimit = talkString.lastIndexOf(' ');

		Matcher matcher = LIGHTNING_PATTERN.matcher(talkString);

		if (matcher.find()) {

			this.talksTotalTime += LIGHTNING_TIME_LIMIT;
			return new Talk(talkString.substring(0, titleIndexLimit), LIGHTNING_TIME_LIMIT, true);
		} else {

			// Extract numeric value from talk duration text
			int duration = Integer.parseInt(talkString.substring(titleIndexLimit+1).replaceAll("\\D+", ""));

			// Validate talk duration value
			if (duration > PM_SESSION_TIME_LIMIT) {
				throw new RuntimeException("Talk duration: " + talkString + " exceeds session time limit!");
			}

			this.talksTotalTime += duration;

			return new Talk(talkString.substring(0, titleIndexLimit), duration, false);
		}
	}
}
