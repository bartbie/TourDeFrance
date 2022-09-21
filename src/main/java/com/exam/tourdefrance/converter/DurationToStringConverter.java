package com.exam.tourdefrance.converter;

import com.exam.tourdefrance.lib.TimeUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Duration;

@Converter
public final class DurationToStringConverter implements AttributeConverter<Duration, String> {

  @Override
  public String convertToDatabaseColumn(Duration duration) {
    return TimeUtils.DurationToStr(duration);
  }

  @Override
  public Duration convertToEntityAttribute(String dbData) {
    return TimeUtils.StrToDuration(dbData);
  }
}
