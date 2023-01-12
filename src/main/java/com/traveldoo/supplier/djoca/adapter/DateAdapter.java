package com.traveldoo.supplier.djoca.adapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class DateAdapter {
  private final static DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

  public static Date unmarshal(final String date) {
    return Optional
        .ofNullable(date)
        .map(d -> {
          try {
            return FORMATTER.parse(date);
          } catch (ParseException e) {
            throw new IllegalArgumentException(e);
          }
        }).orElse(null);
  }

  public static String marshal(final Date date) {
    return Optional.ofNullable(date)
        .map(d -> FORMATTER.format(date))
        .orElse(null);
  }
}
