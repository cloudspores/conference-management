package com.benue.exercises;

import com.benue.exercises.util.ScheduleWriter;
import com.benue.exercises.util.ScheduleReader;

import java.util.List;

/**
 * Schedule the talks
 *
 * @author Ade Lucas
 */

public class Scheduler {

	private Conference conference;

	public Scheduler() {}

	/**
	 * Initiate conference scheduling.
	 * - read in and validate talks text from input file
	 * - create Conference instance
	 * - call out to Conference.schedule to calculate schedule
	 * @param inputFilePathname is the pathname of input file
	 */
	public void schedule(String inputFilePathname) {

		List<String> talksStrings = ScheduleReader.read(inputFilePathname);
		conference = new Conference(talksStrings);

		conference.schedule();
	}

	public void writeOutSchedule(String outputFilePathname) {

		// Generate output file and write out results
		ScheduleWriter writer = new ScheduleWriter(outputFilePathname);

		for(String schedule: conference.getConferenceSchedule()) {
			writer.write(schedule);
		}

		writer.close();
	}
}
