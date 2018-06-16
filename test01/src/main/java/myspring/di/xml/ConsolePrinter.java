package myspring.di.xml;

public class ConsolePrinter implements Printer {
	@Override
	public void print(String message) {	// 넘겨받은 문자열을 운영체제에서 설정된 표준출력장치(대부분 모니터)로 출력
		System.out.println(message);
	}
}
