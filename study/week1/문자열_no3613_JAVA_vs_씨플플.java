package baekjoon.study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_no3613_JAVA_vs_씨플플 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		br.close();
		
		int type = 0; // 0: C++, 1: JAVA, 2: ERROR
		if (str.charAt(0)!='_' && str.charAt(0)<'a') { // 첫글자 대문자면 error
			type = 2;
		}
		else if (str.contains("_")) {
			type = 0; // C++
			if (str.charAt(0)=='_' || str.charAt(str.length()-1)=='_' || str.contains("__")) { // 단어구분자가 연속으로 등장하는경우
				type = 2; // ERROR
			}
			else {
				boolean errorFlag = false;
				for(int i=0; i<str.length()-1; i++) {
					if (str.charAt(i)!='_' && str.charAt(i)<'a') { // 대문자 포함이면 C++타입이 아니게 되므로 에러
						type = 2;
						errorFlag = true;
						break;
					}
				}
				if (!errorFlag) { // 정상적인 C++타입의 경우 JAVA타입으로 변환
					StringBuilder sb = new StringBuilder(str);
					for(int i=0; i<sb.length()-1; i++) {
						if (sb.charAt(i)=='_') {
							sb.setCharAt(i+1, (char)(sb.charAt(i+1)-('a'-'A')));
						}
					}
					str = sb.toString();
					str = str.replaceAll("_", "");		
				}
			}
		} else {
			type = 1; // _가 없다면 JAVA타입(변화없는것 포함)
			StringBuilder sb = new StringBuilder(str);
			StringBuilder answer = new StringBuilder();
			int cur_index = 0;
			for(int i=0; i<sb.length(); i++) {
				if (sb.charAt(i)<'a') { // 대문자의 경우에
					sb.setCharAt(i, (char)(sb.charAt(i)+('a'-'A'))); // 소문자로 변경해주고
					answer.append(sb.substring(cur_index, i)); // 변경된 문자 전 인덱스까지 새로운 문자열에 넣어준뒤
					answer.append('_'); // _ 추가해준다.
					cur_index = i; // 어디까지 진행했는지 저장
//					sb.insert(i, '_'); // for문에서 length가 늘어나서 정상적으로 반복함
				}
//				if (i==sb.length()-1) { // 이런식으로 코드가 되면 마지막부분에서 insert가 되면서 무한히 length가 늘어나고 무한loop에 빠지게 된다
//					sb.insert(i, '_'); // 해당 문제의 경우 마지막위치에 추가되는경우는 없으므로 이런경우는 발생하지 않는다.
//				}
			}
			answer.append(sb.substring(cur_index));
			str = answer.toString();
		}
		
		if (type==2) {
			System.out.println("Error!");
		} else {
			System.out.println(str);
		}
		
	}

}
