/**
 *
 */
package com.example.hero.service;

import java.util.List;

/**
 * @author lepra
 *
 */
public interface Hero {
  /**
   * 全英雄を取得する
   * */
  List<com.example.hero.model.entity.Hero> getHeroList();
  /**
   * 指定した情報の英雄を取得する
   * */
  List<com.example.hero.model.entity.Hero> getHero(com.example.hero.model.entity.Hero hero);
  /**
   * 英雄を登録する
   * */
  Boolean addHero(com.example.hero.model.entity.Hero hero);
  /**
   * 英雄を削除する
   * */
  Boolean removeHeroName(Integer id);
  /**
   * 英雄の名前を変更する
   * */
  Boolean setHeroName(com.example.hero.model.entity.Hero hero);
}
