public class Day26 {
    private String secret = "Day26의 캡슐화된 인스턴스 변수";
    String s = "Day26의 인스턴스 변수";

    class MemberClass {
        String s = "Day26의 MemberClass의 인스턴스 변수";

        public void show() {
            System.out.println("내부 클래스(Inner Class)"); // MemberClass = InnerClass
            System.out.println(secret); // 비공개
            System.out.println(s);  // 내부
            System.out.println(Day26.this.s);   // 외부(instance)
        }

        static String s3 = "정적 멤버 필드";
        static void info() {
            System.out.println("Static Member Method");
        }
    }

    public static void main(String[] args) {
        Day26 m = new Day26();
        Day26.MemberClass mc = m.new MemberClass();
        // MemberClass mc = new MemberClass(); // 선언 방식에 주의. 바깥쪽에서 instance 선언이 선행되지 않음.

        System.out.println(mc.s);   // Day26의 MemberClass의 인스턴스 변수
        mc.show(); // Day26의 인스턴스 변수

        mc.s3 = "test";
        System.out.println(Day26.MemberClass.s3);
        Day26.MemberClass.info();   // Static Member Method -> 객체로 접근 불가하기 때문에 class 생성이 필요.
    }
}