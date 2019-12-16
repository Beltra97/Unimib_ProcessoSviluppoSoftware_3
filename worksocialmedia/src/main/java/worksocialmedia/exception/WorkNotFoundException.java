package worksocialmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such Work")
public class WorkNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -8252953614783756469L;

  public WorkNotFoundException() {
    super();
  }

  public WorkNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public WorkNotFoundException(String message) {
    super(message);
  }

  public WorkNotFoundException(Throwable cause) {
    super(cause);
  }
}
