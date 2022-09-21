package com.exam.tourdefrance.lib;

import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public final class TimeUtils {

  private TimeUtils() {}

  public static String DurationToStr(Duration duration) {
    return duration == null
        ? null
        : "%d:%02d:%02d:%02d"
            .formatted(
                duration.toHoursPart(),
                duration.toMinutesPart(),
                duration.toSecondsPart(),
                duration.toMillisPart());
  }

  public static Duration StrToDuration(String string) {
    if (string == null) {
      return null;
    } else {
      var parts =
              Arrays.stream(string.split(":", 4)).map(Long::parseLong).collect(Collectors.toList());
      return Duration.ofHours(parts.get(0))
              .plusMinutes(parts.get(1))
              .plusSeconds(parts.get(2))
              .plusMillis(parts.get(3));
    }
  }
}
