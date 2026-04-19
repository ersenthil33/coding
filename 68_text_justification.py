from typing import List

class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        res = []
        i = 0
        
        while i < len(words):
            line_words = []
            line_len = 0
            
            # Greedily add words while they fit
            while i < len(words) and line_len + len(words[i]) + len(line_words) <= maxWidth:
                line_words.append(words[i])
                line_len += len(words[i])
                i += 1
            
            spaces = maxWidth - line_len
            gaps = len(line_words) - 1
            
            # Last line OR single word → left justified
            if i == len(words) or gaps == 0:
                line = " ".join(line_words)
                line += " " * (maxWidth - len(line))
            
            else:
                base_spaces = spaces // gaps
                extra_spaces = spaces % gaps
                
                line = ""
                for j in range(gaps):
                    line += line_words[j]
                    line += " " * (base_spaces + (1 if j < extra_spaces else 0))
                
                line += line_words[-1]
            
            res.append(line)
        
        return res