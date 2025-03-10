class Solution {
    public int compress(char[] chars) {

    int write=0; // pointer for writing into chars
    int i=0; // pointer for reading chars
    char currentChar;

    while(i<chars.length) {
        currentChar = chars[i];

        int count=0; // zero because the count is incremented in below while loop
        chars[write++] = currentChar;

        while(i<chars.length && currentChar==chars[i]){ // this helps detect change in character
            i++;
            count++; 
        }

        if(count>1) {

            for (char c: Integer.toString(count).toCharArray()) {
                chars[write++] = c;
            }

        }

    }

    return write;

    }
}
