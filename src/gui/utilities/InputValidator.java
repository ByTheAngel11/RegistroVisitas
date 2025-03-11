package gui.utilities;

import Exceptions.InvalidDateFormat;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputValidator {
    public static Timestamp convertStringToTimestamp(String date) throws InvalidDateFormat {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date parsedDate = dateFormat.parse(date);
            return new Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            throw new InvalidDateFormat("Formato de fecha incorrecto. Use yyyy/MM/dd HH:mm:ss", e);
        }
    }
}