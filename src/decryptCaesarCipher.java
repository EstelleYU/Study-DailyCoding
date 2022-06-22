/* ------------------------------
19_decryptCaesarCipher
Daily Coding from CodeStates
Tue 21 June 2022

Input a encrypted string(alphabet only) and a secret key(number)
and return the decrypted string.
The Caesar cipher encrypts plaintext which is shifted by secret numbers.
Decryption refers to restoring an encrypted string to its original plaintext.

In case, 'hello' to encrypting with secret 3 = 'khoor'
In case, 'codestates' to encrypting with secret 11: 'nzopdelepd'

If an empty string is entered, return an empty string.
Spaces should be left as is.
Only lowercase letters are entered.


암호화된 문자열과 암호화 키를 입력받아 복호화된 문자열을 리턴해야 합니다.
카이사르 암호는 평문(plaintext)을 암호키 secret개만큼 (오른쪽으로) 평행이동시켜 암호화 합니다.
복호화는 암호화된 문자열을 원래의 평문으로 복원하는 것을 말합니다.

example
String output = decryptCaesarCipher("khoor", 3);
System.out.println(output); // --> hello
output = decryptCaesarCipher("zruog", 3);
System.out.println(output); // --> world

ASCII code a-z = 97-122

----------------------------- */


public class decryptCaesarCipher {
    public static void main(String[] args) {

        String str = "abcdxyzzz";
        int secret = 3;
        StringBuilder convertedWord = new StringBuilder();

        for (int i=0; i<str.length(); i++){
            int numAcs = str.charAt(i);
            if (numAcs+secret>122){
                convertedWord.append(Character.toString((char)((int)numAcs + secret - 26)));
            }
            convertedWord.append(Character.toString((char)((int)numAcs + secret)));
        }

        System.out.println(convertedWord);
        System.out.println(convertedWord.length());
        String match = "[^\uAC00-\uD7A30-9a-zA-Z]";
        convertedWord = new StringBuilder(convertedWord.toString().replaceAll(match, ""));
        System.out.println(convertedWord);
        System.out.println(convertedWord.length());
    }
}

/* ----------------------------- 동관님 코드
package com.codestates.coplit;

public class Solution {
  public String decryptCaesarCipher(String str, int secret) {
    // edge-case
    if (str.length() == 0) return "";

    StringBuilder result = new StringBuilder();

    // for-Loop
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != ' ') {
        int charNum = (int) str.charAt(i);
        // a ~ z : ASCII 97 ~ 122
        if (charNum - secret < 97) { // charNum = a : 97 보다 작아질때
          charNum = 122 + 1 - (97 - (charNum - secret));
          result.append((char) charNum);
        } else {  // charNum = a : 97 보다 클때
          result.append((char) ((int) str.charAt(i) - secret));
        }
      } else {  // 공백은 변환 X
        result.append(str.charAt(i));
      }
    }
    return result.toString();
  }
}
 -----------------------------*/

/* ----------------------------- 코플릿 레퍼런스코드

package com.codestates.coplit;
import java.util.*;

public class Solution {
	public String decryptCaesarCipher(String str, int secret) {
    //알파벳을 모두 String으로 선언, 할당합니다.
    String alpha = "abcdefghijklmnopqrstuvwxyz";

    //결과를 담을 String을 선언합니다.
    String result = "";

    //입력된 str만큼 순회하며
    for(int i = 0; i < str.length(); i++) {
      //해당 문자열이 공백일 경우
      if(str.charAt(i) == ' ') {
        //결과에 공백을 그대로 추가합니다.
        result = result + str.charAt(i);
      } else {
        //이외의 경우, alpha에서 현재 문자열의 index를 찾아준 이후,
        int asis = alpha.indexOf(str.charAt(i));
        //복호화는 반대 방향으로 이루어기 때문에 seceret을 빼주게 됩니다.
        //전체 길이를 더하고, 나머지를 구하는 이유는 해당 문자열의 index를 벗어날 경우를 고려한 계산식입니다.
        int tobe = (asis - secret + alpha.length()) % alpha.length();
        //복호화한 문자열을 result에 추가합니다.
        result = result + alpha.charAt(tobe);
      }
    }
    //복호화된 문자열이 저장된 변수를 리턴합니다.
    return result;
  }
}

알파벳 문자열을 선언한후에 조회해서 사용
동관님 코드의 경우 secret에 주어지는 숫자가 26(알파벳 개수)*2 를 넘어가면
테스트케이스에 대해서 대응하지 못 할 수 있어서
레퍼런스처럼 접근해야 된다고 함 (동관님 피드백)

----------------------------- */