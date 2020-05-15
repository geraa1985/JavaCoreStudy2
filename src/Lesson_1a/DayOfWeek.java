package Lesson_1a;

public enum DayOfWeek {
	Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;

	public static String getWorkingHours(DayOfWeek day){
		switch (day){
			case Monday: return "Until the end of the work week 40 hours";
			case Tuesday: return "Until the end of the work week 32 hours";
			case Wednesday: return "Until the end of the work week 24 hours";
			case Thursday: return "Until the end of the work week 16 hours";
			case Friday: return "Until the end of the work week 8 hours";
		}
		return "Today is a day off";
	}
}
