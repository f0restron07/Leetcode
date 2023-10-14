class MagicDictionary {
    private Set<String> words;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        words = new HashSet<>();
    }
    
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            words.add(word);
        }
    }
    
    public boolean search(String searchWord) {
        char[] chars = searchWord.toCharArray();
        
        // Try to change every character of searchWord to check if it matches any word in the dictionary
        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != original) {
                    chars[i] = c;
                    if (words.contains(new String(chars))) {
                        return true;
                    }
                    chars[i] = original; // revert the change
                }
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
