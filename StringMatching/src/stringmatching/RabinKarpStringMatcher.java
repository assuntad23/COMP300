package stringmatching;

public class RabinKarpStringMatcher extends AbstractStringMatcher {

	public static final int MODULUS = 65521;
	
	public static final int RADIX = (Character.MAX_VALUE + 1) % MODULUS;
	
	public RabinKarpStringMatcher(String pattern) {
		super(pattern);
	}
	
	@Override
	public int match(String text) {
		// TODO Auto-generated method stub
		return 0;
	}

}
