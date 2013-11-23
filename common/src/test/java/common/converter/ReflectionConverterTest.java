package common.converter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitry Tsydzik
 * @since Date: 23.11.13
 */
public class ReflectionConverterTest {

    public static class A {
        private String a = "Aa";
        private String b = "Ab";

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }

    public static class B {
        private String a = "Ba";
        private String c = "Ac";

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }
    }

    @Test
    public void testConvert() throws Exception {
        A a = new A();
        Converter<A, B> converter = new ReflectionConverter<>(A.class, B.class);
        B b = converter.convert(a);
        assertEquals(a.getA(), b.getA());
    }

    @Test
    public void testInheritedConvert() throws Exception {
        A a = new A();
        Converter<A, B> converter = new ReflectionConverter<A, B>() {};
        B b = converter.convert(a);
        assertEquals(a.getA(), b.getA());
    }
}
