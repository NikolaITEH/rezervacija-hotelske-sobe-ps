/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Nikola
 */
public class Validator {

    private final List<String> validationErrors;

    private Validator() {
        validationErrors = new ArrayList();
    }

    public static Validator startValidation() {
        return new Validator();
    }

    public Validator validateNotNullOrEmpty(String value, String errorMessage) throws ValidationException {
        if (value == null || value.trim().isEmpty()) {
            this.validationErrors.add(errorMessage);
        }
        return this;
    }

    public Validator validateNotNull(Object value, String errorMessage) throws ValidationException {
        if (value == null) {
            this.validationErrors.add(errorMessage);
        }
        return this;
    }

    public Validator validateStringLength(String value, String errorMessage, Integer min, Integer max) {
        if ((min != null && value.trim().length() < min) || (max != null && value.trim().length() > max)) {
            this.validationErrors.add(errorMessage);
        }
        return this;
    }

    public Validator validateStringContains(String value, String errorMessage, String contains) {
        if (!value.trim().contains(contains)) {
            this.validationErrors.add(errorMessage);
        }
        return this;
    }

    public Validator validateStringStartsWith(String value, String errorMessage, String startsWith) {
        if (!value.trim().startsWith(startsWith)) {
            this.validationErrors.add(errorMessage);
        }
        return this;
    }

    public Validator validateDateFormat(String value, String errorMessage, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(value.trim());
        } catch (ParseException ex) {
            this.validationErrors.add(errorMessage);
        }
        return this;
    }

    public Validator validateBeforeToday(String value, String errorMessage) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        try {
            if (!dateFormat.parse(value).after(calendar.getTime())) {
                this.validationErrors.add(errorMessage);
            }
        } catch (ParseException ex) {
        }
        return this;
    }

    public Validator validateNumber(String value, String errorMessage) {
        try {
            Double.parseDouble(value.trim());
        } catch (Exception e) {
            this.validationErrors.add(errorMessage);
        }
        return this;
    }

    public Validator validateDoubleGreaterThan(String value, String errorMessage, Double min) {
        try {
            double doubleValue = Double.parseDouble(value.trim());
            if (doubleValue < min) {
                this.validationErrors.add(errorMessage);
            }
        } catch (Exception e) {
            this.validationErrors.add(errorMessage);
        }
        return this;
    }

    public Validator validateIntGreaterThan(String value, String errorMessage, int min) {
        try {
            int intValue = Integer.parseInt(value.trim());
            if (intValue < min) {
                this.validationErrors.add(errorMessage);
            }
        } catch (Exception e) {
            this.validationErrors.add(errorMessage);
        }
        return this;
    }

    public Validator validateIntLowerThan(String value, String errorMessage, int max) {
        try {
            int intValue = Integer.parseInt(value.trim());
            if (intValue > max) {
                this.validationErrors.add(errorMessage);
            }
        } catch (Exception e) {
            this.validationErrors.add(errorMessage);
        }
        return this;
    }

    public Validator validateListNotEmpty(List<?> list, String errorMessage) {
        if (list.isEmpty()) {
            this.validationErrors.add(errorMessage);
        }
        return this;
    }

    public void throwIfInvalid() throws ValidationException {
        if (!validationErrors.isEmpty()) {
            throw new ValidationException(this.validationErrors.stream().collect(Collectors.joining("\n")));
        }
    }

}
