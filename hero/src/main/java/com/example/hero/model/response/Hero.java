/**
 *
 */
package com.example.hero.model.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author lepra
 *
 */
public class Hero {
  private final Integer id;
  private final String name;

  /**
   * コンストラクタ
   * */
  public Hero(Integer id, String name) {
    this.id = id;
    this.name = name;
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
  public String toString() {
    ObjectMapper mapper = new ObjectMapper();

    String json;
    try {
      json = mapper.writeValueAsString(this);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return null;
    }
    return json;
  }

}
