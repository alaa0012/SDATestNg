package SDA.Tests.day15;
import org.testng.annotations.Test;

public class C07Description {


    // To describe what test methods do, we use description attribute.

    @Test(description = "this is testcase1")
    void testCase1() {
        System.out.println("SDET");
    }


    @Test(description = "this is testcase2")
    void testCase2() {
        System.out.println("QA Analyst");
    }


    @Test(description = "this is testcase3")
    void testCase3() {
        System.out.println("Software Developer");
    }

    /*
    SDET
    QA Analyst
    Software Developer
     */

}