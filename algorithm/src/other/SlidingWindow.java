package other;

//找字符串中不重复的最大子串
//acdfegcdase=>fegcdas=>7
public class SlidingWindow {

	int lengthOfLongestSubString(String string){
		char[] s = string.toCharArray();
		int l=0,r=-1;//滑动窗口[r..l]
		int[] freq = new int[256];//存放当前滑动窗口元素，256位ASCII码(0为没有)
		int result=0;
		while(l<s.length){
			if(r+1<s.length&&freq[s[r+1]]==0)
				freq[s[++r]]++;
			else 
				freq[s[l++]]--;
			if(result<(r-l+1)){ 
				result=r-l+1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		SlidingWindow sw=new SlidingWindow();
		int i = sw.lengthOfLongestSubString("acdfegcdase");
		System.out.println(i);
	}
}
