package stringmatching;

public abstract class AbstractStringMatcher {
	
	private String pattern;
	
	public AbstractStringMatcher(String pattern) {
		this.pattern = pattern;
		
	}
	
	public String getPattern(){
		return pattern;
	}
	
	protected boolean matchAt(String text, int position){
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) != text.charAt(i+position))
				return false;
			}
		return true;
	}
	
	public abstract int match(String text);

}
