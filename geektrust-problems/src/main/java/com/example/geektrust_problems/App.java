package com.example.geektrust_problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.example.processor.AbstractProcessor;
import com.example.processor.RequestProcessor;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		AbstractProcessor processor = new RequestProcessor();
		BufferedReader bufferReader = null;
		String input = null;
		//take input from command line
		File inputFile = new File(args[0]);
		//directly take input from file
		//File inputFile = new File("/Users/sivadeep.nallana/git/workspaces/demo/navi/geektrust-problems/src/main/resources/input");

		try {
			bufferReader = new BufferedReader(new FileReader(inputFile));
			while ((input = bufferReader.readLine()) != null) {
				input = input.trim();
				processor.execute(input);
			}
		} catch (Exception e) {
			throw new Exception("Input Exception", e);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException e) {
			}
		}
	}
}
