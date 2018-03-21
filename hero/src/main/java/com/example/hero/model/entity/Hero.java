/**
 *
 */
package com.example.hero.model.entity;

/**
 * @author lepra
 *
 */
public class Hero {

  private final Integer id;
  private final String name;

  /**
   * コンストラクタ
   */
  public Hero() {
    this.id = null;
    this.name = null;
  }
  /**
   * @return id
   */
  public Integer getId() {
    return id;
  }
  /**
   * @return name
   */
  public String getName() {
    return name;
  }

}
