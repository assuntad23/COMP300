package stringmatching;

public class NaiveStringMatcher extends AbstractStringMatcher {

	public NaiveStringMatcher(String pattern) {
		super(pattern);
		//TODO
	}
	
	@Override
	public int match(String text) {
		for (int position = 0;
				position + getPattern().length() <= text.length();
				position++){
			if (matchAt(text,position))
				return position;
		}
		return -1;
	}

}
