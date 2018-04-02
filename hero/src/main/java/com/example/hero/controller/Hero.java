/**
 *
 */
package com.example.hero.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lepra
 *
 */
@RestController
@RequestMapping("/heros")
public class Hero {
  @Autowired
  private com.example.hero.service.Hero heroService;


  /**
   * "/heros"で英雄のリストを取得する
   * */
  @RequestMapping(method=RequestMethod.GET)
  public List<com.example.hero.model.response.Hero> getHeros() {
    return entityToResponse(heroService.getHeroList());
  }

  /**
   * "/heros/xx"で指定したIDの英雄を取得する
   * */
  @RequestMapping(value="/{id}",method=RequestMethod.GET)
  public com.example.hero.model.response.Hero getHeroId(@PathVariable Integer id) {
    return entityToResponse(heroService.getHero(new com.example.hero.model.entity.Hero(id, null))).get(0);
  }

  /**
   * "/heros"で英雄の情報を変更する
   * */
  @RequestMapping(method=RequestMethod.PUT)
  public void putHero(@RequestBody com.example.hero.model.response.Hero hero) {
    heroService.setHeroName(new com.example.hero.model.entity.Hero(hero.getId(), hero.getName()));
  }

  /**
   * "/heros"で英雄の情報を登録する
   * */
  @RequestMapping(method=RequestMethod.POST)
  public void postHero(@RequestBody com.example.hero.model.response.Hero hero) {
    heroService.addHero(new com.example.hero.model.entity.Hero(hero.getId(), hero.getName()));
  }

  /**
   * "/heros/?name=xx"で指定した名前の英雄を取得する
   * */
  @RequestMapping(value="/", params="name", method=RequestMethod.GET)
  public List<com.example.hero.model.response.Hero> getHeroName(@RequestParam(name="name") String name) {
    return entityToResponse(heroService.getHero(new com.example.hero.model.entity.Hero(null, name)));
  }
  /**
   * "/heros/xx"で指定したIDの英雄を削除する
   * */
  @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
  public void deleteHero(@PathVariable Integer id) {
    heroService.removeHeroName(id);
  }
  /**
   * 変換する
   * */
  private List<com.example.hero.model.response.Hero> entityToResponse(List<com.example.hero.model.entity.Hero> entityHeroList) {
    List<com.example.hero.model.response.Hero> responseHeroList = new ArrayList<>();
    entityHeroList.stream().forEach(hero ->{
      com.example.hero.model.response.Hero responseHero = new com.example.hero.model.response.Hero(hero.getId(),hero.getName());
      responseHeroList.add(responseHero);
    });
    return responseHeroList;
  }
}
