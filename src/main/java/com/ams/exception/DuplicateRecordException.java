package com.ams.exception;

@SuppressWarnings("serial")
public class DuplicateRecordException  extends Exception
{
	public DuplicateRecordException(String msg) {
		super(msg);
	}
}
