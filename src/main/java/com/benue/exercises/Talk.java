package com.benue.exercises;

/**
 * Represents a Talk.
 *
 * @author Ade Lucas
 */

class Talk {

	private String title;
	private int duration;
	private boolean isLightning;
	private boolean isProcessed;

	/**
	 * @param title       talk title
	 * @param duration    talk duration
	 * @param isLightning true if a lightning talk
	 */
	Talk(String title, int duration, boolean isLightning) {

		this.title = title;
		this.duration = duration;
		this.isLightning = isLightning;
		this.isProcessed = false;
	}

	/**
	 * @return the duration of the talk
	 */
	int getDuration() { return duration; }

	/**
	 * @return the title of the talk
	 */
	String getTitle() { return title; }

	boolean isLightning() {
		return isLightning;
	}

	public boolean isProcessed() {
		return isProcessed;
	}

	public void setProcessed(boolean processed) {
		isProcessed = processed;
	}
}
