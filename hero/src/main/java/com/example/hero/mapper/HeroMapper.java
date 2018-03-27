/**
 *
 */
package com.example.hero.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author lepra
 *
 */
@Mapper
public interface HeroMapper {
  /**
   * 全英雄を取得する
   * */
  @Select("SELECT id,name FROM Hero")
  List<com.example.hero.model.entity.Hero> selectHeroList();

  /**
   * 指定したIDの英雄を取得する
   * */
  @Select("SELECT id,name FROM Hero WHERE id = #{id}")
  com.example.hero.model.entity.Hero selectHeroById(Integer id);

  /**
   * 指定した文字が含まれる名前の英雄を取得する
   * */
  @Select("SELECT id,name FROM Hero WHERE name LIKE %#{name}%")
  List<com.example.hero.model.entity.Hero> selectHeroByName(String name);

  /**
   * 新たな英雄を登録する
   * */
  @Insert("INSERT INTO Hero (id, name) VALUES(#{id} , #{name})")
  Boolean insertHero(com.example.hero.model.entity.Hero hero);

  /**
   * 指定したIDの英雄を削除する
   * */
  @Delete("DELETE FROM Hero WHERE id = #{id}")
  Boolean deleteHeroById(Integer id);

  /**
   * 指定したIDの英雄の名前を変更する
   * */
  @Update("UPDATE Hero SET name = #{name} WHERE id = #{id}")
  Boolean deleteHero(com.example.hero.model.entity.Hero hero);
}
