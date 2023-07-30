package com.example.atlan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Global {

	public static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	public static final String MOBILE_REGEX = "(0/91)?[7-9][0-9]{9}";
	public static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	public static final String API_KEY = "AIzaSyCxebiUD2XyTAXAJrOwK5oYNqXq-_7_PpU";
}
