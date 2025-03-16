# Java Collection Framework

## 미션 1: 기능 요구사항
- [x] `SimpleList` 인터페이스의 `ArrayList` 구현체인 `SimpleArrayList`를 구현한다
  - 내부적으로 동적으로 배열의 크기를 조절하는 동작을 이해하는 것이 목표다

## 미션 2: 기능 요구사항
- [x] `SimpleList` 구현체인 `SimpleLinkedList`를 구현한다
  - 내부적으로 배열 없이 연결을 유지하여 동작을 이해하는 것을 목표로 한다
  - 양방향 연결은 필요 없고, 최대한 단순화하여 구현

# 제네릭 학습하기

## 미션 1: 기능 요구사항
- [ ] 제네릭 클래스에 대해 학습한다
- [ ] 제네릭을 사용하여 `SimpleList`에서 String 이외의 타입도 다룰 수 있도록 개선한다
```java
SimpleList<Integer> values = new SimpleArrayList<Integer>();
values.add(1);
values.add(2);

Integer first = values.get(0);
Integer second = values.get(1);
```

## 미션 2: 기능 요구사항
- [ ] 제네릭 메서드에 대해 학습한다
- [ ] 배열을 받아 `SimpleList`로 변환하는 메서드를 구현
  -  제네릭을 사용해 외부에서 생성되는 리스트의 타입을 지정할 수 있어야 한다
```java
final String[] arrays = {"first", "second"};

final SimpleList<String> values = SimpleList.<String>fromArrayToList(values);
```

## 미션 3: 기능 요구사항
- [ ] 제한된 타입 매개변수(Bounded Type Parameters)에 대해 학습한다
- [ ] 숫자 타입의 `SimpleList`를 받아 모든 값을 더해주는 메서드를 구현해본다
  - `String`과 같은 숫자가 아닌 타입이 들어올 경우 예외가 발생해야 한다
  - 숫자 처리를 위해 모든 숫자 클래스의 부모 타입인 Number 타입으로 제한한다
```java
final SimpleList<Double> doubleValues = new SimpleArrayList<Double>(0.5, 0.7);
final SimpleList<Integer> intValues = new SimpleArrayList<Integer>(1, 2);

final double doubleTotal = SimpleList.sum(doubleValues); // 1.2
final double intTotal = SimpleList.sum(intValues);  // 3
```

## 미션 4: 기능 요구사항
- [ ] 상위 제한 와일드카드(Upper Bounded Wildcard)에 대해 학습한다
- [ ] 숫자 타입의 `SimpleList`를 받아 음수를 제외하고 반환하는 메서드를 구현해본다
  -  숫자 처리를 위해 모든 숫자 클래스의 부모 타입인 Number 타입으로 제한한다
```java
final SimpleList<Double> doubleValues = new SimpleArrayList<Double>(-0.1, 0.5, 0.7);
final SimpleList<Integer> intValues = new SimpleArrayList<Integer>(-10, 1, 2);

final SimpleList<Double> filteredDoubleValues = SimpleList.filterNegative(doubleValues);
final SimpleList<Integer> filteredIntValues = SimpleList.filterNegative(intValues);
```

## 미션 5: 기능 요구사항
- [ ] 제네릭의 변성 특징인 공변, 반공변 특성에 대해 학습한다
- [ ] PECS(Producer Extends Consumer Super) 개념에 대해 학습한다
- [ ] 리스트의 값을 다른 리스트로 복사하는 메서드를 구현해본다
  - 같은 타입이 아닌 상속 관계의 타입도 복사가 가능해야 한다
```java
class Printer { }
class LaserPrinter extends Printer { }

---

final var laserPrinter = new LaserPrinter();

final SimpleList<Printer> printers = new SimpleArrayList<Printer>();
final SimpleList<LaserPrinter> laserPrinters = new SimpleArrayList<LaserPrinter>(laserPrinter);

SimpleList.copy(lazerPrinters, printers);

System.out.println(printers.get(0) == laserPrinter); // true
```
