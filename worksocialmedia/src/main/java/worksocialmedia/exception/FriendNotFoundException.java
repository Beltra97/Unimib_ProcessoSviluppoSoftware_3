package worksocialmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such Friend")
public class FriendNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -8252953614783756469L;

  public FriendNotFoundException() {
    super();
  }

  public FriendNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public FriendNotFoundException(String message) {
    super(message);
  }

  public FriendNotFoundException(Throwable cause) {
    super(cause);
  }
}
