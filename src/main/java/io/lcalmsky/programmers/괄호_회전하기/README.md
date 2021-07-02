## 문제

[코딩테스트 연습 > 월간 코드 챌린지 시즌2 > 괄호 회전하기](https://programmers.co.kr/learn/courses/30/lessons/76502)

### 문제 설명

다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.

`()`, `[]`, `{}`는 모두 올바른 괄호 문자열입니다.

만약 `A`가 올바른 괄호 문자열이라면, `(A)`, `[A]`, `{A}` 도 올바른 괄호 문자열입니다. 예를 들어, `[]` 가 올바른 괄호 문자열이므로, `([])` 도 올바른 괄호 문자열입니다.

만약 `A`, `B`가 올바른 괄호 문자열이라면, `AB`도 올바른 괄호 문자열입니다. 예를 들어, `{}` 와 `([])` 가 올바른 괄호 문자열이므로, `{}([])` 도 올바른 괄호 문자열입니다.

대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 `s`가 매개변수로 주어집니다. 이 `s`를 왼쪽으로 `x (0 ≤ x < (s의 길이))` 칸만큼 회전시켰을 때 `s`가 올바른 괄호 문자열이 되게 하는 `x`의
개수를 return 하도록 solution 함수를 완성해주세요.

---

### 제한사항

s의 길이는 1 이상 1,000 이하입니다.

---

## 풀이

### Solution 1

무난하게 괄호의 짝을 찾는 방식으로 해결

(1) 문자열의 길이만큼 반복하며 해당 문자열이 올바른 괄호인지 검사하고 올바른 괄호인 경우 정답을 1 올려줍니다. <br>
(2) 문자열을 왼쪽으로 한 칸씩 회전시킵니다. <br>
(3) 여는 괄호일 때는 스택에 괄호를 `push` 합니다. <br>
(4.a) 닫는 괄호일 때 스택이 비어있으면 올바른 괄호가 아닙니다. <br>
(4.b) 비어있지 않은 경우엔 스택의 top에 있는 값을 확인해 현재 닫는 괄호와 짝이 되는 여는 괄호인지 확인합니다. <br>
(4.b.ㄱ) 짝이 되는 괄호일 경우 스택의 top을 제거(pop) 합니다. <br>
(4.b.ㄴ) 짝이 되는 괄호가 아닐 경우 올바른 괄호가 아닙니다. <br>

```java
import java.util.Stack;

public class Solution2 {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isValid(s)) { // (1)
                answer++;
            }
            s = String.format("%s%s", s.substring(1), s.charAt(0)); // (2)
        }
        return answer;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '[': // (3)
                case '{': // (3)
                case '(': // (3)
                    stack.push(c);
                    break;
                case ']': // (4)
                    if (!isValid(stack, '[')) return false;
                    break;
                case '}': // (4)
                    if (!isValid(stack, '{')) return false;
                    break;
                case ')': // (4)
                    if (!isValid(stack, '(')) return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    private boolean isValid(Stack<Character> stack, char c2) {
        if (!stack.isEmpty() && stack.peek() == c2) {
            stack.pop();
            return true;
        }
        return false;
    }
}
```

### Solution 2

switch 문에 중복되는 조건 비교가 보기 싫어서 BiFunction 인터페이스를 활용해 보았습니다.

(1) 괄호 별로 `Stack`을 이용해 어떤 작업을 할지 정의한 `functionMap`을 초기화합니다. <br>
    정의하는 `BiFunction`은 Stack과 괄호(`character`)를 전달하고 `Boolean` 값을 반환합니다. <br>
    여는 괄호일 때 해당 괄호를 `Stack`에 `push` 하고 `true`를 반환합니다. <br>
    닫는 괄호일 때 `Stack`이 비어있거나 `Stack`의 `top`에 있는 괄호가 현재 괄호와 짝이 아닌 경우 `false`를 반환합니다. <br>
    그렇지 않으면 `Stack`의 `top` 엘리먼트를 제거(`pop`)하고 `true`를 반환합니다. <br>
(2) 문자열의 길이만큼 반복하며 해당 문자열이 올바른 괄호인지 검사하고 올바른 괄호인 경우 정답을 1 올려줍니다. <br>
(3) 문자열을 왼쪽으로 한 칸씩 회전시킵니다. <br>
(4) 괄호에 해당하는 function을 호출(1에서 정의)해 유효한 괄호인지 검증합니다. <br>

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class Solution {

    private Map<Character, BiFunction<Stack<Character>, Character, Boolean>> functions;

    public int solution(String s) {
        initFunctions(); // (1)
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isValid(s)) { // (2)
                answer++;
            }
            s = String.format("%s%s", s.substring(1), s.charAt(0)); // (3)
        }
        return answer;
    }

    private void initFunctions() { // (1)
        functions = new HashMap<>();
        BiFunction<Stack<Character>, Character, Boolean> pushFunction = (stack, c) -> {
            stack.push(c);
            return true;
        };
        functions.put('[', pushFunction);
        functions.put('{', pushFunction);
        functions.put('(', pushFunction);
        functions.put(']', (stack, c) -> isValid(stack, '['));
        functions.put('}', (stack, c) -> isValid(stack, '{'));
        functions.put(')', (stack, c) -> isValid(stack, '('));
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!functions.get(c).apply(stack, c)) { // (4)
                return false;
            }
        }
        return stack.isEmpty();
    }

    private Boolean isValid(Stack<Character> stack, char c) {
        if (!stack.isEmpty() && stack.peek() == c) {
            stack.pop();
            return true;
        }
        return false;
    }
}
```


## 결과

[##_Image|kage@cSzot9/btq8HtNZB7P/JYtjuVpvBkTj4z9OhzKik1/img.png|alignCenter|data-origin-width="1898" data-origin-height="766" data-ke-mobilestyle="widthOrigin"|||_##]

[##_Image|kage@bBi9SQ/btq8IfPfczK/Bq8ebkEymqT5KNbcK3kKj1/img.png|alignCenter|data-origin-width="1916" data-origin-height="770" data-ke-mobilestyle="widthOrigin"|||_##]

둘 다 제출해봤는데 `Solution 1`이 근소하게 성능이 좋았습니다.

`Solution 2`는 `Map`을 이용했기 때문에 당연히 메모리는 더 많이 사용할 줄 알았지만 시간은 빨라질 줄 알았는데 Boolean을 반환해야하는 구조다보니 메서드 레퍼런스를 활용하지 못해서 그런지 call stack이 증가하여 시간이 늘어난 거 같습니다.

테스트 케이스 중 몇 가지 케이스의 경우 시간은 Solution 1이 조금 빠르지만 메모리는 오히려 Solution 2가 더 절약되는 결과를 확인할 수 있었는데 어떤 작업을 하느라 메모리가 많이 사용되었는지 궁금하네요.

---

알고리즘 문제를 풀다보면 가독성과 효율, 유지보수에 유리한 객체지향적 특징들을 모두 잡을 순 없을까 항상 고민하게 됩니다.

시간, 공간 복잡도를 고민하는 게 더 좋은 습관일지 다른 요소들도 고려해야할지..

제가 면접관이라면 후자를 더 높게 평가할 거 같은데 K-코테는 전자를 더 많이 보는 거 같아 안타깝습니다 ㅜㅜ