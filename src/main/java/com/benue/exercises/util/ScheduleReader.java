package com.benue.exercises.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Read and validate lines from supplied text file to yield list of talks
 *
 * @author Ade Lucas
 */

public class ScheduleReader {

	private static final Pattern TALK_PATTERN = Pattern.compile("^(.+)\\s(\\d+)?\\s?((min)|(lightning))$");

	/**
	 * Read and validate lines from supplied text file to yield list of talks
	 *
	 * @param inputFilePathname is the location of file to read input from
	 * @return a list of talks parsed from the input file.
	 */
	public static List<String> read(String inputFilePathname) {

		try (Stream<String> stream = Files.lines(Paths.get(inputFilePathname))) {

			return stream
					.filter(line -> !("".equals(line)))		// Filter out any empty string lines
					.peek(ScheduleReader::validateLine)		// Validate format of line - throw exception if invalid line
					.collect(Collectors.toList());          // Stash results into List of Strings
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Validate line from supplied text file.
	 * @param line line
	 * @throws RuntimeException if unexpected format encountered.
	 */
	private static void validateLine(String line) {

		Matcher matcher = TALK_PATTERN.matcher(line);

		// Invalid format detected in input file
		if (!matcher.find()) {
			throw new RuntimeException("Unexpected format found in input file: ->" + line + "<-");
		}
	}
}
