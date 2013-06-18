package ar.com.fernandospr.wns.exceptions;

public class WnsException extends RuntimeException {
	private static final long serialVersionUID = -2805144407471327141L;

	public WnsException()                      { super(); }
    public WnsException(String message)        { super(message); }
    public WnsException(Throwable cause)       { super(cause); }
    public WnsException(String m, Throwable c) { super(m, c); }
}