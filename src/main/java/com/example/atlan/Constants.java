package com.example.atlan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Constants Class Storing all the global variables
 */
public class Constants {

	public static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	public static final String MOBILE_REGEX = "(0/91)?[7-9][0-9]{9}";
	public static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	public static final String API_KEY = "AIzaSyCxebiUD2XyTAXAJrOwK5oYNqXq-_7_PpU";
	public static final String ACCOUNT_SID = "AC7f5a9ac63791c4ce2cb9d9bcd1ca3645";
	public static final String AUTH_TOKEN = "9eb9c9749b30d0f12f93476677030667";
}
