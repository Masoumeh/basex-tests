package org.basex.test.qt3ts.fn;

import org.basex.tests.bxapi.XQuery;
import org.basex.test.qt3ts.QT3TestSet;

/**
.
 *
 * @author BaseX Team 2005-12, BSD License
 * @author Leo Woerteler
 */
@SuppressWarnings("all")
public class FnSubstringBefore extends QT3TestSet {

  /**
   * K-SubstringBeforeFunc-1  A test whose essence is: `substring-before()`. .
   */
  @org.junit.Test
  public void kSubstringBeforeFunc1() {
    final XQuery query = new XQuery(
      "substring-before()",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPST0017")
    );
  }

  /**
   * K-SubstringBeforeFunc-10  A test whose essence is: `substring-before("a string", "not in other") eq ""`. .
   */
  @org.junit.Test
  public void kSubstringBeforeFunc10() {
    final XQuery query = new XQuery(
      "substring-before(\"a string\", \"not in other\") eq \"\"",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   * K-SubstringBeforeFunc-2  A test whose essence is: `substring-before(())`. .
   */
  @org.junit.Test
  public void kSubstringBeforeFunc2() {
    final XQuery query = new XQuery(
      "substring-before(())",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPST0017")
    );
  }

  /**
   * K-SubstringBeforeFunc-3  A test whose essence is: `substring-before((), (), "http://www.w3.org/2005/xpath-functions/collation/codepoint", "wrong param")`. .
   */
  @org.junit.Test
  public void kSubstringBeforeFunc3() {
    final XQuery query = new XQuery(
      "substring-before((), (), \"http://www.w3.org/2005/xpath-functions/collation/codepoint\",\n" +
      "         \"wrong param\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPST0017")
    );
  }

  /**
   * K-SubstringBeforeFunc-4  A test whose essence is: `substring-before("a string", "a string", "http://www.example.com/COLLATION/NOT/SUPPORTED")`. .
   */
  @org.junit.Test
  public void kSubstringBeforeFunc4() {
    final XQuery query = new XQuery(
      "substring-before(\"a string\", \"a string\",\n" +
      "         \"http://www.example.com/COLLATION/NOT/SUPPORTED\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("FOCH0002")
    );
  }

  /**
   * K-SubstringBeforeFunc-5  A test whose essence is: `substring-before("foo", "oo", "http://www.w3.org/2005/xpath-functions/collation/codepoint") eq "f"`. .
   */
  @org.junit.Test
  public void kSubstringBeforeFunc5() {
    final XQuery query = new XQuery(
      "substring-before(\"foo\", \"oo\",\n" +
      "         \"http://www.w3.org/2005/xpath-functions/collation/codepoint\") eq \"f\"",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   * K-SubstringBeforeFunc-6  A test whose essence is: `substring-before("tattoo", "attoo") eq "t"`. .
   */
  @org.junit.Test
  public void kSubstringBeforeFunc6() {
    final XQuery query = new XQuery(
      "substring-before(\"tattoo\", \"attoo\") eq \"t\"",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   * K-SubstringBeforeFunc-7  A test whose essence is: `substring-before("tattoo", "tatto") eq ""`. .
   */
  @org.junit.Test
  public void kSubstringBeforeFunc7() {
    final XQuery query = new XQuery(
      "substring-before(\"tattoo\", \"tatto\") eq \"\"",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   * K-SubstringBeforeFunc-8  A test whose essence is: `substring-before((), ()) eq ""`. .
   */
  @org.junit.Test
  public void kSubstringBeforeFunc8() {
    final XQuery query = new XQuery(
      "substring-before((), ()) eq \"\"",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   * K-SubstringBeforeFunc-9  A test whose essence is: `substring-before("a string", "") eq ""`. .
   */
  @org.junit.Test
  public void kSubstringBeforeFunc9() {
    final XQuery query = new XQuery(
      "substring-before(\"a string\", \"\") eq \"\"",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   * fn-substring-before-1 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = "" $arg2 = "" .
   */
  @org.junit.Test
  public void fnSubstringBefore1() {
    final XQuery query = new XQuery(
      "fn:substring-before(\"\",\"\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-10 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = " " $arg2 = " AAAAABBBBB" .
   */
  @org.junit.Test
  public void fnSubstringBefore10() {
    final XQuery query = new XQuery(
      "fn:substring-before(\" \",\"AAAAABBBBB\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-11 Evaluates The "substring-before" function using it as a argument of a fn:not - returns true .
   */
  @org.junit.Test
  public void fnSubstringBefore11() {
    final XQuery query = new XQuery(
      "fn:not(fn:substring-before(\"A\",\"A\"))",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   * fn-substring-before-12 Evaluates The "substring-before" function using it as a argument of a fn:not - returns true .
   */
  @org.junit.Test
  public void fnSubstringBefore12() {
    final XQuery query = new XQuery(
      "fn:not(fn:substring-before(\"A\",\"B\"))",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   * fn-substring-before-13 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = xs:string("A") $arg2 = "A" .
   */
  @org.junit.Test
  public void fnSubstringBefore13() {
    final XQuery query = new XQuery(
      "fn:substring-before(xs:string(\"A\"),\"A\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-14 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = "A" $arg2 = xs:string("A") .
   */
  @org.junit.Test
  public void fnSubstringBefore14() {
    final XQuery query = new XQuery(
      "fn:substring-before(\"A\",xs:string(\"A\"))",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-15 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = "A" $arg2 = "a" .
   */
  @org.junit.Test
  public void fnSubstringBefore15() {
    final XQuery query = new XQuery(
      "fn:substring-before(\"A\",\"a\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-16 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = "a" $arg2 = "A" .
   */
  @org.junit.Test
  public void fnSubstringBefore16() {
    final XQuery query = new XQuery(
      "fn:substring-before(\"a\",\"A\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-17 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = "substring-before" $arg2 = "substring-before" .
   */
  @org.junit.Test
  public void fnSubstringBefore17() {
    final XQuery query = new XQuery(
      "fn:substring-before(\"substring-before\",\"substring-before\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-18 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = "substring-beforesubstring-before" $arg2 = "substring-before" .
   */
  @org.junit.Test
  public void fnSubstringBefore18() {
    final XQuery query = new XQuery(
      "fn:substring-before(\"substring-beforesubstring-before\",\"substring-before\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-19 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = "****" $arg2 = "***" .
   */
  @org.junit.Test
  public void fnSubstringBefore19() {
    final XQuery query = new XQuery(
      "fn:substring-before(\"****\",\"***\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-2 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = "" $arg2 = "A Character String" .
   */
  @org.junit.Test
  public void fnSubstringBefore2() {
    final XQuery query = new XQuery(
      "fn:substring-before(\"\",\"A Character String\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-20 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = "12345" $arg2 = "2345" .
   */
  @org.junit.Test
  public void fnSubstringBefore20() {
    final XQuery query = new XQuery(
      "fn:substring-before(\"12345\",\"2345\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"1\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-21 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = "substring-before $arg2 = "erofeb-gnirtsbus ("substring-before" backwards) .
   */
  @org.junit.Test
  public void fnSubstringBefore21() {
    final XQuery query = new XQuery(
      "fn:substring-before(\"substring-before\",\"erofeb-gnirtsbus\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * Use absolute collation URI.
   */
  @org.junit.Test
  public void fnSubstringBefore22() {
    final XQuery query = new XQuery(
      "substring-before(\"banana\", \"a\",\n" +
      "         \"http://www.w3.org/2005/xpath-functions/collation/codepoint\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("\"b\"")
    );
  }

  /**
   * Use relative collation URI.
   */
  @org.junit.Test
  public void fnSubstringBefore23() {
    final XQuery query = new XQuery(
      "substring-before(\"banana\", \"a\", \"collation/codepoint\")",
      ctx);
    query.baseURI("http://www.w3.org/2005/xpath-functions/");

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("\"b\"")
    );
  }

  /**
   * Use non-BMP characters.
   */
  @org.junit.Test
  public void fnSubstringBefore25() {
    final XQuery query = new XQuery(
      "substring-before(\"𐀁𐀂𐀃\", \"𐀂\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertEq("\"𐀁\"")
    );
  }

  /**
   * fn-substring-before-3 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = "" $arg2 = "A Character String" .
   */
  @org.junit.Test
  public void fnSubstringBefore3() {
    final XQuery query = new XQuery(
      "fn:substring-before(\"A Character String\",\"\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-4 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = () $arg2 = "" .
   */
  @org.junit.Test
  public void fnSubstringBefore4() {
    final XQuery query = new XQuery(
      "fn:substring-before((),\"\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-5 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = "" $arg2 = () .
   */
  @org.junit.Test
  public void fnSubstringBefore5() {
    final XQuery query = new XQuery(
      "fn:substring-before(\"\",())",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-6 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = "A Character String" $arg2 = () .
   */
  @org.junit.Test
  public void fnSubstringBefore6() {
    final XQuery query = new XQuery(
      "fn:substring-before(\"A Character String\",())",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-7 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = () $arg2 = "A Character String" .
   */
  @org.junit.Test
  public void fnSubstringBefore7() {
    final XQuery query = new XQuery(
      "fn:substring-before((),\"A Character String\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }

  /**
   * fn-substring-before-8 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = "AAAAABBBBBCCCCC" $arg2 = "BBBBB" .
   */
  @org.junit.Test
  public void fnSubstringBefore8() {
    final XQuery query = new XQuery(
      "fn:substring-before(\"AAAAABBBBBCCCCC\",\"BBBBB\")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertStringValue(false, "AAAAA")
    );
  }

  /**
   * fn-substring-before-9 Evaluates The "substring-before" function with the arguments set as follows: $arg1 = "AAAAABBBBB" $arg2 = " " .
   */
  @org.junit.Test
  public void fnSubstringBefore9() {
    final XQuery query = new XQuery(
      "fn:substring-before(\"AAAAABBBBB\",\" \")",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        assertEq("\"\"")
      &&
        assertCount(1)
      )
    );
  }
}
