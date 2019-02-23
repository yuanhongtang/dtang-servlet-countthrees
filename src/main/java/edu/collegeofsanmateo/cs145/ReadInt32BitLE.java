package edu.collegeofsanmateo.cs145;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;


public class ReadInt32BitLE {

	String fileName = "";
	Integer threesCount = 0;
	int totalBytesRead = 0;

	DataInputStream ins = null;
	FileInputStream fins = null;


	ReadInt32BitLE() {
		fileName = "";
		threesCount = 0;
		totalBytesRead = 0;
		ins = null;
		fins = null;
	}

	ReadInt32BitLE(String fName) {
		setName(fName);
		threesCount = 0;
		ins = null;
		fins = null;
	}

	public boolean EOF()
	{
		boolean result = false;
		int bytesAvailable = 0;
		try {
			if ((bytesAvailable = ins.available()) <= 0) {
				result = true;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public int read() {

		int result = 0;

		try {
			result = ins.readInt();
			if (3 == result) ++threesCount;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void setName(String fName) {
		fileName = new String(fName);
	}

	public Integer getThreesCount()
	{
		return new Integer(threesCount);
	}

	public int getCount() {
		return threesCount;
	}

	public void open()
	{
		if ((null != fileName) && (fileName.length() > 0)) {
			try {
				fins = new FileInputStream(fileName);
				ins = new DataInputStream(fins);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void close()
	{
		if ((null != ins) && (null != fins)) {
			try {
				ins.close();
				fins.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
