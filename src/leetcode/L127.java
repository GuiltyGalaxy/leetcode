package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L127 {
	public static void main(String[] args) {
		new L127();
	}

	L127() {
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		System.out.println(ladderLength("hit", "cog", wordList));
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();  
        Set<String> endSet = new HashSet<>(); 
        if(!wordSet.contains(endWord)){
            return 0;
        }
        beginSet.add(beginWord);
        endSet.add(endWord);
        return bfs(beginSet,endSet,wordSet,1);
    }
    
    private int bfs(Set<String> startSet,Set<String> endSet,Set<String> wordSet,int curLen){
        if(startSet.size()==0){
            return 0;
        }
        if(startSet.size()>endSet.size()){
            return bfs(endSet,startSet,wordSet,curLen);
        }
        Set<String> nextLevel = new HashSet<>();
        wordSet.removeAll(startSet);
        for(String word:startSet){
            char[] letters = word.toCharArray();
            for(int i=0;i<letters.length;i++){
                char origChar = letters[i];
                for(char c='a';c<='z';c++){
                    if(c==origChar){
                        continue;
                    }
                    letters[i]=c;
                    String nextWord = new String(letters);
              
                    if(wordSet.contains(nextWord)){
                        if(endSet.contains(nextWord)){
                            return curLen+1;
                        }
                        nextLevel.add(nextWord);
                    }
                }
                letters[i] = origChar;
            }
        }
        
        return bfs(nextLevel,endSet,wordSet,curLen+1);
    }
}
