package org.basex.test.qt3ts.fn;

import org.basex.tests.bxapi.XQuery;
import org.basex.test.qt3ts.QT3TestSet;

/**
 * Tests for the has-children() function.
 *
 * @author BaseX Team 2005-12, BSD License
 * @author Leo Woerteler
 */
@SuppressWarnings("all")
public class FnHasChildren extends QT3TestSet {

  /**
   * Attempts to reference the "has-children" function with arity zero..
   */
  @org.junit.Test
  public void fnHasChildren001() {
    final XQuery query = new XQuery(
      "fn:exists( fn:has-children#0 )",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPST0112")
    );
  }

  /**
   * Attempts to reference the "has-children" function with arity one..
   */
  @org.junit.Test
  public void fnHasChildren002() {
    final XQuery query = new XQuery(
      "fn:exists( fn:has-children#1 )",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   * Attempts to evaluate the "has-children" function with two arguments..
   */
  @org.junit.Test
  public void fnHasChildren003() {
    final XQuery query = new XQuery(
      "fn:has-children( fn:contains#2, fn:contains#2 )",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPST0017")
    );
  }

  /**
   * Attempts to reference the "has-children" function with arity two..
   */
  @org.junit.Test
  public void fnHasChildren004() {
    final XQuery query = new XQuery(
      "fn:has-children#2",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPST0017")
    );
  }

  /**
   * Evaluates the zero-arity "has-children" function with absent context item..
   */
  @org.junit.Test
  public void fnHasChildren005() {
    final XQuery query = new XQuery(
      "fn:has-children()",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        error("XPDY0002")
      ||
        error("XPTY0004")
      )
    );
  }

  /**
   * Evaluates the (arity one) "has-children" function with absent context item..
   */
  @org.junit.Test
  public void fnHasChildren006() {
    final XQuery query = new XQuery(
      "fn:has-children(.)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        error("XPDY0002")
      ||
        error("XPTY0004")
      )
    );
  }

  /**
   * Evaluates the zero-arity "has-children" function with context item which is not a node..
   */
  @org.junit.Test
  public void fnHasChildren007() {
    final XQuery query = new XQuery(
      "(1)[fn:has-children()]",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      (
        error("XPTY0004")
      )
    );
  }

  /**
   * Tests the type checking of the argument..
   */
  @org.junit.Test
  public void fnHasChildren008() {
    final XQuery query = new XQuery(
      "fn:has-children(1)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPTY0004")
    );
  }

  /**
   * Tests the type checking of the argument..
   */
  @org.junit.Test
  public void fnHasChildren010() {
    final XQuery query = new XQuery(
      "fn:has-children(fn:concat#2)",
      ctx);

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPTY0004")
    );
  }

  /**
   * Tests the type checking of the argument..
   */
  @org.junit.Test
  public void fnHasChildren011() {
    final XQuery query = new XQuery(
      "fn:has-children( (.,.) )",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPTY0004")
    );
  }

  /**
   * Tests the type checking of the argument..
   */
  @org.junit.Test
  public void fnHasChildren014() {
    final XQuery query = new XQuery(
      "(., 1) ! fn:has-children()",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPTY0004")
    );
  }

  /**
   * Tests the type checking of the argument..
   */
  @org.junit.Test
  public void fnHasChildren015() {
    final XQuery query = new XQuery(
      "(., 1) ! fn:has-children(.)",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      error("XPTY0004")
    );
  }

  /**
   * Tests the return type of the "has-children" function..
   */
  @org.junit.Test
  public void fnHasChildren016() {
    final XQuery query = new XQuery(
      "fn:has-children()",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertType("xs:boolean")
    );
  }

  /**
   * Tests the return type of the "has-children" function..
   */
  @org.junit.Test
  public void fnHasChildren017() {
    final XQuery query = new XQuery(
      "fn:has-children(.)",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertType("xs:boolean")
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: context item of type attribute() .
   */
  @org.junit.Test
  public void fnHasChildren018() {
    final XQuery query = new XQuery(
      "/root/@attribute/fn:has-children()",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(false)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: $node of type attribute() .
   */
  @org.junit.Test
  public void fnHasChildren019() {
    final XQuery query = new XQuery(
      "fn:has-children( /root/@attribute )",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(false)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: context item of type comment() .
   */
  @org.junit.Test
  public void fnHasChildren022() {
    final XQuery query = new XQuery(
      "/root/comment()/fn:has-children()",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(false)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: $node of type comment() .
   */
  @org.junit.Test
  public void fnHasChildren023() {
    final XQuery query = new XQuery(
      "fn:has-children( /root/comment() )",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(false)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: context item of type processing-instruction() .
   */
  @org.junit.Test
  public void fnHasChildren024() {
    final XQuery query = new XQuery(
      "/root/processing-instruction()/fn:has-children()",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(false)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: $node of type processing-instruction() .
   */
  @org.junit.Test
  public void fnHasChildren025() {
    final XQuery query = new XQuery(
      "fn:has-children( /root/processing-instruction() )",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(false)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: context item of type text() .
   */
  @org.junit.Test
  public void fnHasChildren026() {
    final XQuery query = new XQuery(
      "/root/text()/fn:has-children()",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(false)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: $node of type text() .
   */
  @org.junit.Test
  public void fnHasChildren027() {
    final XQuery query = new XQuery(
      "fn:has-children( /root/text() )",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(false)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: context item of type element() .
   */
  @org.junit.Test
  public void fnHasChildren028() {
    final XQuery query = new XQuery(
      "/root/empty/fn:has-children()",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(false)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: context item of type element() .
   */
  @org.junit.Test
  public void fnHasChildren029() {
    final XQuery query = new XQuery(
      "fn:has-children( /root/empty )",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(false)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: context item of type element() .
   */
  @org.junit.Test
  public void fnHasChildren030() {
    final XQuery query = new XQuery(
      "/root/fn:has-children()",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: $node of type element() .
   */
  @org.junit.Test
  public void fnHasChildren031() {
    final XQuery query = new XQuery(
      "fn:has-children( /root )",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: context item of type element() .
   */
  @org.junit.Test
  public void fnHasChildren032() {
    final XQuery query = new XQuery(
      "/root/non-empty/fn:has-children()",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: $node of type element() .
   */
  @org.junit.Test
  public void fnHasChildren033() {
    final XQuery query = new XQuery(
      "fn:has-children( /root/non-empty )",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: context item of type document-node() .
   */
  @org.junit.Test
  public void fnHasChildren034() {
    final XQuery query = new XQuery(
      "/fn:has-children()",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: $node of type document-node() .
   */
  @org.junit.Test
  public void fnHasChildren035() {
    final XQuery query = new XQuery(
      "fn:has-children( / )",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertBoolean(true)
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: context item of type node() .
   */
  @org.junit.Test
  public void fnHasChildren036() {
    final XQuery query = new XQuery(
      "/root/node()/fn:has-children()",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertStringValue(false, "false false false false true")
    );
  }

  /**
   * Evaluates the "has-children" function with the argument set as follows: $node of type node() .
   */
  @org.junit.Test
  public void fnHasChildren037() {
    final XQuery query = new XQuery(
      "/root/node()/fn:has-children(.)",
      ctx);
    query.context(node(file("fn/has-children/has-children.xml")));

    final QT3Result res = result(query);
    result = res;
    test(
      assertStringValue(false, "false false false false true")
    );
  }
}
