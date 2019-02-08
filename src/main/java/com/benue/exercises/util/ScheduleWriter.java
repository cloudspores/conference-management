package com.benue.exercises.util;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Write schedule to specified output file.
 * 
 * @author Ade Lucas
 */

public class ScheduleWriter {

	private PrintWriter writer;

	/**
	 * Open the output file for text writing.
	 *
	 * @param outputFileLocation is the location of file to write output to.
	 */
	public ScheduleWriter(String outputFileLocation){

		try{
			writer = new PrintWriter(outputFileLocation);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * Write text to opened file.
	 */
	public void write(String s){
		writer.print(s);
	}

	/**
	 * Close the text writer to the file and release resources.
	 */
	public void close(){
		writer.close();
	}
}
