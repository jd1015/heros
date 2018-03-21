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
  List<Hero> getHeroList();
  /**
   * 指定した情報の英雄を取得する
   * */
  List<Hero> getHero(Hero hero);
  /**
   * 英雄を登録する
   * */
  Boolean addHero(Hero hero);
  /**
   * 英雄を削除する
   * */
  Boolean removeHeroName(Integer id);
  /**
   * 英雄の名前を変更する
   * */
  Boolean setHeroName(Hero hero);
}
