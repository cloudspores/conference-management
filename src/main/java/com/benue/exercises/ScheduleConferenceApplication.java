package com.benue.exercises;

/**
 * Schedule a conference.
 *
 * You are planning a code campaigning conference and have received many entries for presentations which have passed the
 * entry criteria but you're having trouble slotting them into the time constraints of the day
 * -- there are so many possibilities!
 *
 * So, you write a program to do it for you.
 *
 * - The conference has multiple tracks each of which has a morning and afternoon session.
 * - Each session contains multiple talks.
 * - First sessions begin at 9am and must finish by 12 noon, for lunch.
 * - Second sessions begin at 1pm and must finish in time for the networking event.
 * - The networking event can start no earlier than 4:00 and no later than 5:00.
 * - No presentation topic has numbers in it.
 * - All talk lengths are either in minutes (not hours) or lightning (5 minutes).
 * - Presenters will be very punctual; there needs to be no gap between sessions.
 *
 * Note that depending on how you choose to complete this problem, your solution may give a different ordering or
 * combination of talks into tracks.
 * This is acceptable; you don’t need to exactly duplicate the sample output given here.
 *
 * @author Ade Lucas
 */

public class ScheduleConferenceApplication {

	public static void main(String[] args) {

		// Parse input file and create conference
		Scheduler scheduler = new Scheduler();
		scheduler.schedule(args[0]);

		// Generate output file and write out results
		scheduler.writeOutSchedule(args[1]);
	}
}
