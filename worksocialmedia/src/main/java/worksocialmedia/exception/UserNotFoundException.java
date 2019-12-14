package worksocialmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such User")
public class UserNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -8252953614783756469L;

  public UserNotFoundException() {
    super();
  }

  public UserNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public UserNotFoundException(String message) {
    super(message);
  }

  public UserNotFoundException(Throwable cause) {
    super(cause);
  }
}
