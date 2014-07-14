package edu.ishop.acessor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class FileDatasourceAccessor {

	public FileDatasourceAccessor() {
	}

	public BufferedReader getReader() throws FileNotFoundException {
		return new BufferedReader(new FileReader(getDatasourceName()));
	}

	public BufferedWriter getWriter() throws IOException {
		return new BufferedWriter(new FileWriter(getDatasourceName(), true));
	}

	public abstract String getDatasourceName();

}
